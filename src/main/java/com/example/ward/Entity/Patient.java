package com.example.ward.Entity;

import lombok.Data;

@Data
public class Patient {
    private Long patientId; //病人id
    private String name; //病人姓名
    private String gender; //病人性别
    private Integer age; //病人年龄
    private String admissionNumber; //住院号
    private String admissionDate; //住院时间
    private String attendingDoctor; //主治医生姓名
    private Long responsibleNurseId; //责任护士编号
}
