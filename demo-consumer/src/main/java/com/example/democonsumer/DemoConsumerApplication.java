package com.example.democonsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan({"com.example.democonsumer.mapper"})
@EnableDubbo
@SpringBootApplication
@ComponentScan({"com.example.democonsumer.common","com.example.democonsumer.controller","com.example.democonsumer.entity","com.example.democonsumer.service","com.example.democonsumer.beans"})
@EnableSwagger2
public class DemoConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoConsumerApplication.class, args);
    }

}
