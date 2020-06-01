package com.atguigu.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

public class CustomerBlockHandler {


    public static CommonResult handleException(BlockException exception)
    {
        return new CommonResult(200,"自定义的处理器");
    }
}
