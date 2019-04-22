package com.atsiacu.studentmanager.differentschool.commonbasicentity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@ToString
public class StudentScore {
    @Field("school_id")
    protected String schoolId;

    protected String studentNo;

    protected String classNo;

    protected Integer score;

    protected Integer classRake;

}
