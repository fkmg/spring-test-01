package com.sxt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        //auth.inMemoryAuthentication().withUser("admin").password("admin123").roles("admin","user").and()
                //.withUser("fk").password("admin123").roles("user");

        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("SELECT account username,PASSWORD FROM sys_user WHERE account= ?")
        .authoritiesByUsernameQuery("SELECT \n" +
                "  su.account username,\n" +
                "  CONCAT('ROLE_', sr.role_name) rolename \n" +
                "FROM\n" +
                "  sys_user su \n" +
                "  LEFT JOIN sys_user_role sur \n" +
                "    ON su.user_id = sur.user_id \n" +
                "  LEFT JOIN sys_role sr \n" +
                "    ON sur.`role_id` = sr.`role_id` \n" +
                "WHERE su.account = ?" );
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.formLogin().and().authorizeRequests().antMatchers("/hello").authenticated()
                .anyRequest().permitAll();
    }
}
