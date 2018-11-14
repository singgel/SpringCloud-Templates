package io.ymq.example.feign.consumer.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:调用提供者的 `home` 方法
 *
 * @author yanpenglei
 * @create 2017-12-06 15:26
 **/
@RestController
public class ConsumerController {

    @Autowired
    private HomeClient homeClient;

    @GetMapping(value = "/hello")
    public String hello() {
        return  homeClient.consumer();
    }

}
