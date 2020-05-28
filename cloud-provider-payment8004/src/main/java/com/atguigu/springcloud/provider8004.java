package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Admin on 2020/5/15.
 */


@SpringBootApplication
@EnableDiscoveryClient
public class provider8004 {

    public static void main(String[] args)
    {
        SpringApplication.run(provider8004.class,args);
    }
}
