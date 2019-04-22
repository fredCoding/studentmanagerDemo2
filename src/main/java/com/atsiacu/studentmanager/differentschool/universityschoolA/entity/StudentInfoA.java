package com.atsiacu.studentmanager.differentschool.universityschoolA.entity;

import com.atsiacu.studentmanager.differentschool.commonbasicentity.StudentInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@ToString(callSuper = true)
@Setter
@Getter
@Document(collection = "StudentInfo")
public class StudentInfoA extends StudentInfo {
    //对于大学A的定制化扩展
    @Field("home")
    private String homeAddress;

    private String email;

}
