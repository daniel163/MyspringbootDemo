package com.nickzhang.entity;

/**
 * 测试代码主要为传递数据所用
 * by nickzhang on 2016/11/23.
 */
public class UserInfo {

    private String username;
    private String password;
    private String address;

    public UserInfo() {
    }

    public UserInfo(String address, String password, String username) {
        this.address = address;
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
