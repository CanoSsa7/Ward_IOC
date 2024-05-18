package com.example.ward.Service.impl;

import com.example.ward.Dao.NurseMapper;

import com.example.ward.Dao.OrderMapper;
import com.example.ward.Dao.PatientMapper;
import com.example.ward.Entity.Nurse;
import com.example.ward.Entity.Order;
import com.example.ward.Entity.Patient;
import com.example.ward.Entity.PatientDTO;
import com.example.ward.Exception.PatientNotFoundException;
import com.example.ward.Service.PatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CanoSsa7
 */
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    NurseMapper nurseMapper;

    /**
     * 根据病人id从数据库中查找病人信息
     * @param patientId
     * @return 封装的病人信息与负责护士信息
     */
    @Override
    public PatientDTO getPatientInfo(Long patientId) {

        Patient patient = patientMapper.getPatientInfo(patientId);
        if(patient == null){ //如果指定病人不存在
            throw new PatientNotFoundException("未查找到病人");
        }
        //获取责任护士id
        Long respNurseId = patient.getResponsibleNurseId();
        //获取责任护士对象
        Nurse respNurse = nurseMapper.getNurseByNurseId(respNurseId);
        //在DTO中增加责任护士信息
        PatientDTO patientDTO = new PatientDTO();
        BeanUtils.copyProperties(patient, patientDTO);
        patientDTO.setResponsibleNurse(respNurse);

        return patientDTO;
    }

}
