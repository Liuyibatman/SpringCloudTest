package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Admin on 2020/5/15.
 */

@EnableEurekaClient
@SpringBootApplication
public class provider8001 {

    public static void main(String[] args)
    {
        SpringApplication.run(provider8001.class,args);
    }
}
