package com.example.ward.Controller;


import com.example.ward.Entity.Nurse;
import com.example.ward.Entity.Order;
import com.example.ward.Entity.OrderDTO;
import com.example.ward.Entity.PatientDTO;
import com.example.ward.Service.NurseService;
import com.example.ward.Service.OrderService;
import com.example.ward.Service.PatientService;
import com.example.ward.Utilis.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DataController {
    @Autowired
    PatientService patientService;
    @Autowired
    NurseService nurseService;
    @Autowired
    OrderService orderService;
    /**
     * @param patientId 查询的病人id
     * @return 返回病人信息，如姓名、性别、年龄、住院号、住院日期、主治医生与责任护士
     */
    @RequestMapping("/patient")
    Result getPatientInfo(@RequestParam(value = "id") Long patientId){
        PatientDTO patientDTO = patientService.getPatientInfo(patientId);
        return Result.success(patientDTO);
    }

    /**
     *
     * @param nurseId 护士id
     * @return 护士详细信息
     */
    @RequestMapping("/nurse")
    Result getNurseInfo(@RequestParam(value = "id") Long nurseId){
        Nurse nurse = nurseService.getNurseInfo(nurseId);
        return Result.success(nurse);
    }

    /**
     *
     * @param patientId 医嘱对应的病人id
     * @return 医嘱信息（可能是多条）
     */
    @RequestMapping("/order")
    Result getOrderInfo(@RequestParam(value = "id") Long patientId){
        List<OrderDTO> orderList = orderService.getOrderByPatientId(patientId);
        return Result.success(orderList);
    }
}
