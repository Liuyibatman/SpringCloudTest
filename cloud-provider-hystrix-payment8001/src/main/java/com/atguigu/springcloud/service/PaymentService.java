package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Admin on 2020/5/15.
 */

@Service
public class PaymentService {

    @HystrixCommand(fallbackMethod = "testTime_fallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")  //3秒钟以内就是正常的业务逻辑
    })
    public String testok()
    {
        int i=10/0;
        return Thread.currentThread().getName()+"testok！";
    }


    @HystrixCommand(fallbackMethod = "testTime_fallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")  //3秒钟以内就是正常的业务逻辑
    })
    public String  testTime()
    {
        try{
            Thread.sleep(3000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return Thread.currentThread().getName()+"time out !";
    }



    @HystrixCommand(fallbackMethod = "Rongduan_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
            //3秒钟以内就是正常的业务逻辑
    })
    public String testRongduan(@PathVariable("num") int num)
    {
        if(num<0)throw new RuntimeException("不能是负数");

        return Thread.currentThread().getName()+"==="+num;
    }


    public String testTime_fallback()
    {
        return "服务正忙，请稍后再试...";
    }

    public String Rongduan_fallback(@PathVariable("num") int num)
    {
        return "熔断服务正忙，请稍后再试...";
    }

}
