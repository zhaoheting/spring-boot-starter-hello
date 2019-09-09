package com.example.springbootstarterhello;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(HelloServiceProperties.class)

public class HelloServiceAutoConfiguration {
}
