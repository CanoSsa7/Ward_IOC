package com.example.ward.Entity;


import lombok.Data;

@Data
public class Nurse {
    private Long nurseId;     // 护士ID
    private String name;         // 姓名
    private String gender;       // 性别
    private Integer age;         // 年龄
    private String department;   // 科室
}
