package com.example.ward.Service;

import com.example.ward.Entity.Order;
import com.example.ward.Entity.OrderDTO;

import java.util.List;

public interface OrderService {
    //根据病人id查询医嘱信息
    List<OrderDTO> getOrderByPatientId(Long patientId);
}
