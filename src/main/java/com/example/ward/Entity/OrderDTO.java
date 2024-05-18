package com.example.ward.Entity;

import lombok.Data;

@Data
public class OrderDTO {
    private Long orderId; //医嘱id
    private String orderDetail; //医嘱内容
    private Long executionNurseId; //执行医嘱的护士id
    private String timestamp; //医嘱下达时间
    private String lastExecutionTime; //上一次执行时间
    //--------以下为面向传输的额外属性
    private Nurse execNurse; //执行医嘱的护士信息
}
