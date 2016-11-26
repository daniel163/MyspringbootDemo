package com.nickzhang.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by huangqing91 on 2016/11/23.
 */
@Component
/*prefix指定配置信息前缀,locations指定配置文件的位置*/
@ConfigurationProperties(prefix = "info",locations = "classpath:config/nickzhang.properties")
public class Info {

    private String name;
    private String address;
    private String username;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
