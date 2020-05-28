package com.atguigu.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {


    @Value("${server.port}")
    private String port;

    @RequestMapping("/get/{id}")
    public String getId(@PathVariable("id") String id)
    {
        return "nacos test port is :"+port+"  id is : "+id;
    }


}
