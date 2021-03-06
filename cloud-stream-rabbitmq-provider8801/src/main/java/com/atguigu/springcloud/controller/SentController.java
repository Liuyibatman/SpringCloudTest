package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentController {


    @Autowired
    IMessageProvider iMessageProvider;


    @GetMapping("/send")
    public String send()
    {
        return iMessageProvider.send();
    }
}
