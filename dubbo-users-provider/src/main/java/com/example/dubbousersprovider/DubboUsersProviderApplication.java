package com.example.dubbousersprovider;



import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
// 开启基于注解的dubbo功能（主要是包扫描@DubboComponentScan）

@EnableDubbo
@MapperScan({"com.example.dubbousersprovider.mapper"})
@SpringBootApplication
@ComponentScan({"com.example.dubbousersprovider.entity","com.example.dubbousersprovider.common","com.example.dubbousersprovider.client","com.example.dubbousersprovider.service"})
public class DubboUsersProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboUsersProviderApplication.class, args);
    }

}
