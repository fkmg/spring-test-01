package com.sxt.test;

import com.sxt.bean.Resource;
import com.sxt.bean.Role;
import com.sxt.bean.User;
import com.sxt.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext-servlet.xml","classpath:applicationContext-spring.xml"})
public class TestMapper {
    
    @Autowired
    private UserService userService;
    
    @Test
    public void testUserServiceCache(){

        User user = userService.getUserByAccount("test");
        
        if(user != null){
            List<Role> roles = user.getRoles();
            
            if(roles != null && roles.size()>0){
                Role role = roles.get(0);
                List<Resource> resourceList = role.getResourceList();
                if(resourceList != null){
                    System.out.println(resourceList.size());
                }
            }

            //测试二级缓存
            user =userService.getUserByAccount("test");
        }
    }
    
}
