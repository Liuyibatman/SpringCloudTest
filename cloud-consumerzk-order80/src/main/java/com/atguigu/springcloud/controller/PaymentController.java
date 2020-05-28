package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * Created by Admin on 2020/5/15.
 */

@Slf4j
@RestController
public class PaymentController {

    private final String url="http://cloud-provider-payment";

    @Autowired
    RestTemplate template;

    @Value("${server.port}")
    private String port;

    @GetMapping("/consumer/test")
    public String test()
    {
        return template.getForObject(url+"/payment/test",String.class);
    }



}
