package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by Admin on 2020/5/15.
 */

@Slf4j
@RestController
public class PaymentController {



    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/test")
    public String test()
    {
        return "port:"+port+ UUID.randomUUID().toString();
    }



}
