package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class JwtLoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwtLoginApplication.class, args);
    }
}
