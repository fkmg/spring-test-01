package com.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("msg","你在世界的那一边还好么?");
        return "login";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(Model model){

        return "hello wold!";
    }

    @RequestMapping(value = "/msg",method = RequestMethod.GET)
    @ResponseBody
    public String sayLike(Model model){

        return "hello mg!";
    }

}
