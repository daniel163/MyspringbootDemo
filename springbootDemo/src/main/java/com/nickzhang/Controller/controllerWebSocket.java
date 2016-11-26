package com.nickzhang.Controller;

import com.nickzhang.entity.nickzhangMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import com.nickzhang.entity.nickzhangResponse;

/**
 *webSocket演示控制器
 * Created by nickzhang on 2016/11/25.
 */
@Controller
public class controllerWebSocket {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")/*当服务端有信息时会给订阅了此路径的浏览器发送消息*/
    public nickzhangResponse say(nickzhangMessage message) throws Exception{
        Thread.sleep(1000);
        return new nickzhangResponse("Welcome , " + message.getName() + "!");
    }

}
