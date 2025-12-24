package com.cruoyi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication(
        exclude = {
                DataSourceAutoConfiguration.class, // 核心：排除数据源自动配置
                HibernateJpaAutoConfiguration.class, // 可选：排除JPA自动配置（如果有）
                SecurityAutoConfiguration.class
        }
)
@EnableFeignClients(basePackages = "com.cruoyi.feign") // 扫描Feign接口
//@ComponentScan(basePackages = {"com.cruoyi.client"}) // 扫描客户端所有组件
public class RuoYiConsumerApplication implements CommandLineRunner {
    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(RuoYiConsumerApplication.class, args);
        System.out.println("==================\n----------------\n======================\n");
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("SSL enabled: " + env.getProperty("server.ssl.enabled"));
        System.out.println("Key store: " + env.getProperty("server.ssl.key-store"));
    }
}