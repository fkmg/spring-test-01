package com.sxt.controller;

import com.sxt.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Lenovo on 2019/10/14.
 */
@Controller
public class SysUserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        System.out.println("hello");
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String falil(Model model, HttpServletRequest request) throws Exception{
        // shiro在认证过程中出现错误后将异常类路径通过request返回
        String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
        System.err.println(exceptionClassName);
        model.addAttribute("message","用户名或密码错误");
        //认证未通过，返回登录页面
        return "login";
    }

    /**
     * 认证通过时，shiro框架请求该方法跳转到系统主页
     *
     * @return
     */
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
