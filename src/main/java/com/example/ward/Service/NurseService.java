package com.example.ward.Service;

import com.example.ward.Entity.Nurse;

public interface NurseService {
    //查询护士信息
    Nurse getNurseInfo(Long nurseId);
}
