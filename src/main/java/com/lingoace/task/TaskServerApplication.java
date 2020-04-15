package com.lingoace.task;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * lingoAce-task应用入口
 * @author zhanglifeng
 * @date 2020-04-14
 */
@SpringBootApplication
public class TaskServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskServerApplication.class, args);
    }
}