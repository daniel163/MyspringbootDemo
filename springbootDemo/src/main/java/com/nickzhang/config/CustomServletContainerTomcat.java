package com.nickzhang.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by nickzhang on 2016/11/24.
 */
/*@Component*/
public class CustomServletContainerTomcat {


    /*特定的配置(这里以Tomcat为例)(优先级低于配置文件,属于最低)*/
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcatFactory = new TomcatEmbeddedServletContainerFactory();
        tomcatFactory.setPort(7006);
        /*此时文件路径为 src\main\resources\static\404.html */
        tomcatFactory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/html/404.html"));
        tomcatFactory.setSessionTimeout(10, TimeUnit.MINUTES);
        return tomcatFactory;
    }


}
