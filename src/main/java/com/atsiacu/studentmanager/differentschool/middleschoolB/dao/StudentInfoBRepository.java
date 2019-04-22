package com.atsiacu.studentmanager.differentschool.middleschoolB.dao;

import com.atsiacu.studentmanager.differentschool.middleschoolB.entity.StudentInfoB;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentInfoBRepository extends MongoRepository<StudentInfoB,String>{

    Optional<StudentInfoB> findOneByStudentNoAndSchoolId(String studenNo,String schoolId);

    StudentInfoB insert(StudentInfoB studentInfoB);

    void deleteByStudentNoAndSchoolId(String studentNo,String schoolId);
}
