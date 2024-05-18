package com.example.ward.Dao;

import com.example.ward.Entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper


public interface OrderMapper {
    //根据病人id获取医嘱，一个病人可能有多个医嘱
    @Select("select medical_orders.* from medical_orders " +
            "left join patient_medical_orders p " +
            "on medical_orders.order_id = p.order_id " +
            "where p.patient_id = #{patientId}")
    List<Order> getOrderByPatientId(Long patientId);
}
