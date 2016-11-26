package com.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 创建security配置
 * Created by nickzhang on 2016/11/26.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/login").permitAll()  /*设置security对/和/login路径不拦截*/
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") /*设置登录页面的访问路径为/login*/
                .defaultSuccessUrl("/chat") /*登录成功后转向/chat路径*/
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("wyf").password("wyf").roles("USER")  /*创建两个用户*/
                .and()
                .withUser("wisely").password("wisely").roles("USER");
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");/*设置这个目录下的静态资源security不拦截*/
    }
}
