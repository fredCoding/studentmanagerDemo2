package com.atsiacu.studentmanager.differentschool.middleschoolB.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class ObjectValueB {

    private String studentNo;

    private String studentName;

    private String homeAddress;

    private String guardianName;

    private String guardianPhoneNo;

    //展示一门课的成绩分数
    private  String className;

    private Integer score;

    //有扩展内容加入即可

}
