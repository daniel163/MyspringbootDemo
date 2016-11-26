package com.nickzhang.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 通用配置类
 * 配置servlet相关的参数
 * 在同时配置了配置文件和这里的时候,这里优先级更高
 * Created by nickzhang on 2016/11/24.
 */
/*@Component*/
public class CustomServletContainer implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        /*配置端口*/
        configurableEmbeddedServletContainer.setPort(7004);
        /*配置当http请求状态为404的时候跳转的页面*/
        configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/html/404.html")); /* status , path */
        configurableEmbeddedServletContainer.setSessionTimeout(10, TimeUnit.MINUTES);
    }


}
