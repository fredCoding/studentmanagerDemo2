package com.atsiacu.studentmanager.differentschool.universityschoolA.dao;

import com.atsiacu.studentmanager.differentschool.commonbasicentity.StudentInfo;
import com.atsiacu.studentmanager.differentschool.universityschoolA.entity.StudentInfoA;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentInfoARepository  extends MongoRepository<StudentInfoA,String>{
//    <StudentInfoA extends StudentInfo> Optional<StudentInfoA> findOneByStudentNoAndSchoolId(String studentNo,String schoolId);

    Optional<StudentInfoA> findOneByStudentNoAndSchoolId(String studentNo,String schoolId);

    StudentInfoA insert(StudentInfoA studentInfoA);

    void deleteByStudentNoAndSchoolId(String studentNo,String schoolId);
}
