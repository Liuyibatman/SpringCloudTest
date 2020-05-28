package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    public ApplicationConfig applicationConfig;

    @Value("${config.info}")
    private  String configg;


    @GetMapping("/get")
    public String get()
    {
        return configg;
    }
}
