package com.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(HelloServiceProperties.class)
@EnableConfigurationProperties(HelloServiceProperties.class)
//To be configured in application.properties of the project that use this project
//as a third-party jar.
//Import class ... and then add dependency on module ***.main when imported into another project.
@ConditionalOnProperty(prefix = "hello", value = "enabled",matchIfMissing = false)
public class HelloServiceAutoConfiguration {

    @Autowired
    private HelloServiceProperties helloServiceProperties;

    @Bean
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        helloService.setMsg(helloServiceProperties.getMsg());
        return helloService;
    }

}
