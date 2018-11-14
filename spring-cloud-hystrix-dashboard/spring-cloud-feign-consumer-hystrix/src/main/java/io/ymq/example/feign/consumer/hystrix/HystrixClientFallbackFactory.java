package io.ymq.example.feign.consumer.hystrix;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<HomeClient> {

    @Override
    public HomeClient create(Throwable throwable) {
        return () -> "Feign + hystrix ,提供者服务挂了";
    }

}
