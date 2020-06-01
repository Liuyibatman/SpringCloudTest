package com.atguigu.springcloud.alibaba.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.service.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PaymentController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PaymentService paymentService;

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallBack",fallback = "handlerFallback")
//    @SentinelResource(value = "fallBack",blockHandler = "handlerBlock")
//    @SentinelResource(value = "fallBack",blockHandler = "handlerBlock",fallback ="handlerFallback")
    @SentinelResource(value = "fallBack",blockHandler = "handlerBlock",fallback ="handlerFallback",
            exceptionsToIgnore ={IllegalArgumentException.class})
    public CommonResult fallBack(@PathVariable("id") Long id)
    {
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class);
        if(id==4)
        {
            throw new IllegalArgumentException("非法参数异常！");
        }else if(result.getData()==null)
        {
            throw new NullPointerException("空指针异常！");
        }

        return result;
    }

    //fallback方法
    public CommonResult handlerFallback(@PathVariable  Long id,Throwable e)
    {
        return new CommonResult(444,"fallback兜底方法"+e.getMessage());
    }

    //block
    public CommonResult handlerBlock(@PathVariable  Long id, BlockException b)
    {
        return new CommonResult(444,"Block兜底方法"+b.getMessage());
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id)
    {
        return paymentService.
                paymentSQL(id);
    }
}
