package com.ssix.project02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"com.ssix.project02.mapper"})
public class Project02Application {
    public static void main(String[] args) {
        SpringApplication.run(Project02Application.class, args);
    }
}
