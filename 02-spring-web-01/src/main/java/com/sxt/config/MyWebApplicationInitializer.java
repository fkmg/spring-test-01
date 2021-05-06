package com.sxt.config;

import com.sxt.servlet.Myservlet;
import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Component
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    /**
     * 添加servlet
     * @param servlet
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servlet) throws ServletException {
        ServletRegistration.Dynamic myServlet = servlet.addServlet("myServlet", Myservlet.class);
        myServlet.addMapping("/servlet/hello");
    }
}
