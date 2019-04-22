package com.atsiacu.studentmanager.differentschool.universityschoolA.entity;

import com.atsiacu.studentmanager.differentschool.commonbasicentity.StudentScore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString(callSuper = true)
@Setter
@Getter
@Document(collection = "StudentScore")
public class StudentScoreA extends StudentScore {



}
