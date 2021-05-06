package com.sxt.controller;

import com.sxt.bean.Emp;
import com.sxt.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class HomeController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "index";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(Model model,@RequestParam("file") MultipartFile file,String desc) throws IOException {
        String parth = "G:\\java学习\\spring学习\\";
        String contentType = file.getContentType();
        String originalFilename = file.getOriginalFilename();
        long size = file.getSize();

        return "index";
    }

    /**
     * 获取年龄比age大的集合
     * @param age
     * @return
     */
    @ResponseBody
    @RequestMapping("/getEmpList")
    public String getEmpList(Integer age){
        List<Emp> list = new ArrayList<>();
        //1、初始化empList
        list.add(new Emp("上海", "小名", 17));
        list.add(new Emp("北京", "小红", 18));
        list.add(new Emp("深圳", "小蓝", 19));
        list.add(new Emp("广州", "小灰", 20));
        list.add(new Emp("杭州", "小黄", 21));
        list.add(new Emp("贵阳", "小白", 22));

        Stream<Emp> empStream = list.stream().filter(emp -> emp.getAge() > age);
        List<Emp> collect = empStream.collect(Collectors.toList());
        return JsonUtils.objectToJson(collect);
    }

}
