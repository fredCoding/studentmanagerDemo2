package com.atsiacu.studentmanager.differentschool.commonbasicentity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@ToString
public class ClassInfo {

    @Field("school_id")
    protected String schoolId;

    protected String classNo;

    protected String className;

    protected String classRoom;

    protected String classTime;


}
