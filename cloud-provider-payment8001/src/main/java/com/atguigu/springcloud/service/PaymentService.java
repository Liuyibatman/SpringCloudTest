package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * Created by Admin on 2020/5/15.
 */
public interface PaymentService {

    int create (Payment payment);

    Payment getPaymentById(Long id);
}
