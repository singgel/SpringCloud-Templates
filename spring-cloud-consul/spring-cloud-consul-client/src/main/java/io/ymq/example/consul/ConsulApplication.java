package io.ymq.example.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulApplication {

    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

	public static void main(String[] args) {
		SpringApplication.run(ConsulApplication.class, args);
	}

}
