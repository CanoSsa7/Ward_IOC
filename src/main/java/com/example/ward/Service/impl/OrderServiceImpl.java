package com.example.ward.Service.impl;

import com.example.ward.Dao.NurseMapper;
import com.example.ward.Dao.OrderMapper;
import com.example.ward.Entity.Nurse;
import com.example.ward.Entity.Order;
import com.example.ward.Entity.OrderDTO;
import com.example.ward.Exception.OrderNotFoundException;
import com.example.ward.Service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    NurseMapper nurseMapper;
    //根据病人id查询医嘱信息
    @Override
    public List<OrderDTO> getOrderByPatientId(Long patientId) {
        List<Order> orderList = orderMapper.getOrderByPatientId(patientId);
        if(orderList.isEmpty()) {
            throw new OrderNotFoundException("未查找到对应医嘱");
        }
        List<OrderDTO> orderDTOList = new ArrayList<>();

        // 收集所有需要查询的护士ID
        Set<Long> nurseIds = orderList.stream()
                .map(Order::getExecutionNurseId)
                .collect(Collectors.toSet());

        // 一次性查询所有护士信息
        Map<Long, Nurse> nurseMap = nurseMapper.getNursesByIds(nurseIds);

        // 转换订单列表为DTO列表
        for(Order order : orderList) {
            OrderDTO orderDTO = new OrderDTO();
            BeanUtils.copyProperties(order, orderDTO);

            // 从预先查询的护士信息Map中获取对应的护士信息
            Nurse execNurse = nurseMap.get(order.getExecutionNurseId());
            orderDTO.setExecNurse(execNurse);

            orderDTOList.add(orderDTO);
        }

        return orderDTOList;
    }

}
