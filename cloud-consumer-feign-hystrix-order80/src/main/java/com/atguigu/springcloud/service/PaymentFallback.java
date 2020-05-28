package com.atguigu.springcloud.service;


import org.springframework.stereotype.Component;

@Component
public class PaymentFallback implements PaymentService {

    @Override
    public String testok() {
        return "消费者繁忙.....";
    }

    @Override
    public String testTime()  {
        return "消费者超时繁忙.....";
    }
}
