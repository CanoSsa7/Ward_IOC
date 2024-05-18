package com.example.ward.Dao;


import com.example.ward.Entity.Nurse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NurseMapper {
    //根据护士id获取护士信息
    @Select("select * from nurses where nurse_id = #{nurseId}")
    Nurse getNurseByNurseId(Long nurseId);
}
