package com.example.ward.Dao;


import com.example.ward.Entity.Nurse;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Mapper
public interface NurseMapper {
    //根据护士id获取护士信息
    @Select("select * from nurses where nurse_id = #{nurseId}")
    Nurse getNurseByNurseId(Long nurseId);

    //根据多个护士id批量查询护士信息
    @MapKey("nurseId")
    HashMap<Long, Nurse> getNursesByIds(@Param("nurseIds") Set<Long> nurseIds);
}
