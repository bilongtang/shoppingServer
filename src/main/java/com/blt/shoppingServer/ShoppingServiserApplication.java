package com.blt.shoppingServer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blt.shoppingServer.dao")
public class ShoppingServiserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingServiserApplication.class, args);
    }

}
