package com.example.ward.Dao;

import com.example.ward.Entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author CanoSsa7
 */
@Mapper

public interface PatientMapper {
    //根据病人id获取病人信息
    @Select("select * from hospital.patients where patient_id = #{patientId} ")
    Patient getPatientInfo(Long patientId);



}
