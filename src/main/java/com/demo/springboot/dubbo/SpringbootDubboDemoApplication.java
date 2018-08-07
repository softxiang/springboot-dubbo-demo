package com.demo.springboot.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootDubboDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboDemoApplication.class, args);
    }
}
