package com.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * webSocket配置
 * Created by nickzhang on 2016/11/25.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{


    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        /*注册STOMP协议的节点,并映射到制定的URL*/
        /*注册一个endpoint,并制定使用SocketJS协议*/
        stompEndpointRegistry.addEndpoint("endpointNickzhang").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /*配置消息代理*/
        /*广播式应配置一个/topic消息代理*/
        registry.enableSimpleBroker("/topic");
    }
}
