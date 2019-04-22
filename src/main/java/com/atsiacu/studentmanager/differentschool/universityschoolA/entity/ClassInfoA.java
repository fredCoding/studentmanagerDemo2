package com.atsiacu.studentmanager.differentschool.universityschoolA.entity;

import com.atsiacu.studentmanager.differentschool.commonbasicentity.ClassInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString(callSuper = true)
@Setter
@Getter
@Document(collection = "ClassInfo")
public class ClassInfoA extends ClassInfo {
//    protected static final String schoolId = "A";
    //有定制化的需求扩展即可

}
