package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;


/**
 * Created by Admin on 2020/5/15.
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
