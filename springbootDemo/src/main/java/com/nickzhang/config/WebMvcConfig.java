package com.nickzhang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 自定义配置类,重写方法不会覆盖原有的,会同时生效
 * Created by nickzhang on 2016/11/24.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*http://localhost:7033/nickzhang 自动映射到 test 视图*/
        registry.addViewController("/ws").setViewName("/ws");
    }

}
