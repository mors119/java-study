package com.study.spring;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ApplicationRunner runner(ApplicationContext context) {
        return args -> {
            String[] beanNames = context.getBeanDefinitionNames();

            for (String name : beanNames) {
                System.out.println("Bean: " + name);
            }
        };
    }
}
