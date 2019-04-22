package com.atsiacu.studentmanager.differentschool.universityschoolA.dao;

import com.atsiacu.studentmanager.differentschool.commonbasicentity.StudentScore;
import com.atsiacu.studentmanager.differentschool.universityschoolA.entity.StudentScoreA;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StudentScoreARepository extends MongoRepository<StudentScoreA,String>{
    //按照学校，学号，课号查找一门课程成绩
    Optional<StudentScoreA> findOneByStudentNoAndClassNoAndSchoolId(String studentNo,String classNo,String schoolId);

    //按照学号查找该生所有课程 成绩
    List<StudentScoreA> findAllByStudentNoAndSchoolId(String StudentNo,String schoolId);

    StudentScoreA insert(StudentScoreA studentScoreA);

    void deleteByStudentNoAndClassNoAndSchoolId(String studentNo,String classNo,String schoolId);
}
