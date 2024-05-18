package com.example.ward.Service.impl;

import com.example.ward.Dao.OrderMapper;
import com.example.ward.Entity.Order;
import com.example.ward.Exception.OrderNotFoundException;
import com.example.ward.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    //根据病人id查询医嘱信息
    @Override
    public List<Order> getOrderByPatientId(Long patientId) {
        List<Order> orderList =  orderMapper.getOrderByPatientId(patientId);
        if(orderList.size() == 0){
            throw new OrderNotFoundException("未查找到对应医嘱");
        }
        return orderList;
    }
}
