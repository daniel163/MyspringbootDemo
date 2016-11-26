package com.websocket.controller;

import com.websocket.entity.nickzhangMessage;
import com.websocket.entity.nickzhangResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 *webSocket演示控制器
 * Created by nickzhang on 2016/11/25.
 */
@Controller
public class controllerWebSocket {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate; /*注入SimpMessagingTemplate向浏览器发送消息*/

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")/*当服务端有信息时会给订阅了此路径的浏览器发送消息*/
    public nickzhangResponse say(nickzhangMessage message) throws Exception{
        Thread.sleep(1000);
        return new nickzhangResponse("Welcome , " + message.getName() + "!");
    }


    @MessageMapping("/chat")
    public void handleChar(Principal principal,String msg){
        if (principal.getName().equals("wyf")){
            simpMessagingTemplate.convertAndSendToUser("wisely","/queue/notifications",principal.getName() + "-send:" + msg);
        }else {
            simpMessagingTemplate.convertAndSendToUser("wyf","/queue/notifications",principal.getName() + "-send:" + msg);
        }
    }

}
