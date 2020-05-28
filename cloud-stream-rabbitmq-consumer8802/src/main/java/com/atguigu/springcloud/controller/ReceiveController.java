package com.atguigu.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Sink.class)
public class ReceiveController {


    @Value("${server.port}")
    String port;

    @RequestMapping("/revceive")
    public String revceive(Message<String> message)
    {
        return "消费者接收到信息为："+message.getPayload()+"=="+port;
    }
}
