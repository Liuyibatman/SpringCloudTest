package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentFallback.class)
public interface PaymentService {

    @GetMapping("/payment/testok")
    public String testok();

    @GetMapping("/payment/testtime")
    public String  testTime() ;

}
