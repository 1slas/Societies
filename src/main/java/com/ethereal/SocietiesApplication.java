package com.ethereal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.ethereal.mapper")      
public class SocietiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocietiesApplication.class, args);
    }

}
