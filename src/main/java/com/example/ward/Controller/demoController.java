package com.example.ward.Controller;

import com.example.ward.Dao.TestMapper;
import com.example.ward.Entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {
    @Autowired
    TestMapper mapper;
    @RequestMapping("/patient")
    Patient getPatient(@RequestParam(value = "id") Long patientId){
        return mapper.getPatient(patientId);
    }
}
