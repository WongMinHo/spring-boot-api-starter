package com.minhow.springbootapistarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class SpringBootApiStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApiStarterApplication.class, args);
    }

}
