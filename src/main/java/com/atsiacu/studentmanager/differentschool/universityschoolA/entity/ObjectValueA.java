package com.atsiacu.studentmanager.differentschool.universityschoolA.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//用来接收和输出本学校 想要管理查看的内容，主要用来查询并展示页面
@ToString
@Setter
@Getter
public class ObjectValueA {

    private String studentNo;

    private String studentName;

    private String hotelNo;

    private String email;

    private String phoneNo;

    private String homeAddress;

    //查看该生一个课程的成绩分数
    private  String className;

    private Integer score;

    //需要其他内容可继续扩展

}
