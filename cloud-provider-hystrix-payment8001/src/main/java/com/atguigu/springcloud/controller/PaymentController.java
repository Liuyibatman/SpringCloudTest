package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 2020/5/15.
 */

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String port;



    @GetMapping("/payment/testnum/{num}")
    public String testnum(@PathVariable("num") int num)
    {
        return paymentService.testRongduan(num);
    }



    @GetMapping("/payment/testok")
    public String testok()
    {
        return paymentService.testok();
    }

    @GetMapping("/payment/testtime")
    public String  testTime()
    {
        return paymentService.testTime();
    }



    }
