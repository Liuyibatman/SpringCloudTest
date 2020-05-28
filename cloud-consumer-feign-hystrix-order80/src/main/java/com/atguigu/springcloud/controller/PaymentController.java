package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 2020/5/15.
 */

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;


    @GetMapping("/consumer/testok")
    public String testok()
    {
        return paymentService.testok();
    }

    @GetMapping("/consumer/testtime")
    public String  testTime() throws Exception
    {
        return paymentService.testTime();
    }

}
