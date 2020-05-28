package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Admin on 2020/5/15.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable{
    private Long id;
    private String serial;
}
