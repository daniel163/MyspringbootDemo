package com.nickzhang.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 配置http自动跳转https
 * Created by nickzhang on 2016/11/24.
 */
/*@Component*/
public class TomcatEmbeddedServletContainerFactoryConfig {

    @Bean
    public EmbeddedServletContainerFactory servletContainer(){
        TomcatEmbeddedServletContainerFactory tomcatFactory = new TomcatEmbeddedServletContainerFactory(){
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };

        tomcatFactory.addAdditionalTomcatConnectors(httpConnector());
        return tomcatFactory;

    }


    /***
     * 设置访问http://localhost:7007/
     * 会自动跳转到
     * https://localhost:7005/
     * @return
     */
    public Connector httpConnector(){
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(7007);
        connector.setSecure(false);
        connector.setRedirectPort(7005);
        return connector;
    }

}
