package io.ymq.example.zuul.filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ZuulFilterApplication {

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    @Bean
    public PasswordFilter PasswordFilter() {
        return new PasswordFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulFilterApplication.class, args);
    }

}
