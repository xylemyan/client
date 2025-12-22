package com.cruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(
        exclude = {
                DataSourceAutoConfiguration.class, // 核心：排除数据源自动配置
                HibernateJpaAutoConfiguration.class, // 可选：排除JPA自动配置（如果有）
                SecurityAutoConfiguration.class
        }
)
@EnableFeignClients(basePackages = "com.cruoyi.feign") // 扫描Feign接口
//@ComponentScan(basePackages = {"com.cruoyi.client"}) // 扫描客户端所有组件
public class RuoYiConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RuoYiConsumerApplication.class, args);
        System.out.println("==================\n----------------\n======================\n");
    }
}