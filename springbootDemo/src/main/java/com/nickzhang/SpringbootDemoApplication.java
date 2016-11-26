package com.nickzhang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }


    /*在当前启动文件内配置,需要定位为static,此处配置的优先级最高*/
    /*@Component*/
    public static class CustomServletContainer implements EmbeddedServletContainerCustomizer {
        @Override
        public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
            /*配置端口*/
            configurableEmbeddedServletContainer.setPort(7005);
            /*配置当http请求状态为404的时候跳转的页面*/
            /*这里的页面路径是D:\IntellijSpace\SpringBootDemo\springbootDemo\src\main\resources\static\html\404.html*/
            configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/html/404.html"));/* status , path */
            configurableEmbeddedServletContainer.setSessionTimeout(10, TimeUnit.MINUTES);
        }
    }


}
