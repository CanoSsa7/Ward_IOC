package com.example.ward.Service;



import com.example.ward.Entity.Nurse;
import com.example.ward.Entity.Order;
import com.example.ward.Entity.PatientDTO;

import java.util.List;

/**
 * @author CanoSsa7
 */
public interface PatientService {
    //查询病人基础信息
    PatientDTO getPatientInfo(Long patientId);


}
