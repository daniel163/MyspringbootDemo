package com.nickzhang.entity;

/**
 * 服务端向浏览器发送此类的消息
 * Created by nickzhang on 2016/11/25.
 */
public class nickzhangResponse {

    private String responseMessage;

    public nickzhangResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
