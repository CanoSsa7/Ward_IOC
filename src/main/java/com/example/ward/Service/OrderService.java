package com.example.ward.Service;

import com.example.ward.Entity.Order;

import java.util.List;

public interface OrderService {
    //根据病人id查询医嘱信息
    List<Order> getOrderByPatientId(Long patientId);
}
