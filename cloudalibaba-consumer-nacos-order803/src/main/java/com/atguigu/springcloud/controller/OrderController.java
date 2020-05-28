package com.atguigu.springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class OrderController {

    private static String url="http://nacos-payment-provider";

    @Value("${service-url.nacos-user-service}")
    private String serverURL;


    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/get/{id}")
    public String getId(@PathVariable("id") String id)
    {
        return restTemplate.getForObject(url+"/payment/get/"+id,String.class);
    }

}
