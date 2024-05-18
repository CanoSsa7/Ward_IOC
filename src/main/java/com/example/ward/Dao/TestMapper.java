package com.example.ward.Dao;

import com.example.ward.Entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {
    @Select("select * from hospital.patients where patient_id = #{patientId} ")
    Patient getPatient(Long patientId);
}
