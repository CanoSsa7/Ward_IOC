package com.example.ward.Service.impl;

import com.example.ward.Dao.NurseMapper;
import com.example.ward.Entity.Nurse;
import com.example.ward.Exception.NurseNotFoundException;
import com.example.ward.Service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NurseServiceImpl implements NurseService {
    @Autowired
    NurseMapper nurseMapper;

    //根据护士id获取护士信息
    @Override
    public Nurse getNurseInfo(Long nurseId) {
        Nurse nurse = nurseMapper.getNurseByNurseId(nurseId);
        if(nurse == null){
            throw new NurseNotFoundException("未查找到对应护士");
        }
        return nurse;
    }
}
