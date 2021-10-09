package com.hks.account.gateway;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("spring-boot-mybatis")
public interface MybatisClient {

    @RequestMapping("/database")
    String consumer();

}
