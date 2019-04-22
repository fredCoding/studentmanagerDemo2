package com.atsiacu.studentmanager.differentschool.middleschoolB.entity;

import com.atsiacu.studentmanager.differentschool.commonbasicentity.StudentInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@ToString(callSuper = true)
@Getter
@Setter
@Document("StudentInfo")
public class StudentInfoB extends StudentInfo{
    //对于中学B的定制化内容

    @Field("home")
    protected String homeAddress;

    protected String guardianName;

    protected String guardianPhoneNo;


}
