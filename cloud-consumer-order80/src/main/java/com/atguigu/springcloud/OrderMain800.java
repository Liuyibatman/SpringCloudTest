package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Admin on 2020/5/15.
 */


@EnableEurekaClient
@SpringBootApplication
public class OrderMain800 {

    public static void main(String[] args)
    {
        SpringApplication.run(OrderMain800.class,args);
    }

}
