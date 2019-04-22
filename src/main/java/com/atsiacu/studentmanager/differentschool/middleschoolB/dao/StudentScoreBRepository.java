package com.atsiacu.studentmanager.differentschool.middleschoolB.dao;


import com.atsiacu.studentmanager.differentschool.middleschoolB.entity.StudentScoreB;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StudentScoreBRepository extends MongoRepository<StudentScoreB,String> {
    //按照学校，学号，课号查找一门课程成绩
    Optional<StudentScoreB> findOneByStudentNoAndClassNoAndSchoolId(String studentNo, String classNo, String schoolId);

    //按照学号查找该生所有课程 成绩
    List<StudentScoreB> findAllByStudentNoAndSchoolId(String StudentNo, String schoolId);

    StudentScoreB insert(StudentScoreB studentScoreB);

    void deleteByStudentNoAndClassNoAndSchoolId(String studentNo, String classNo, String schoolId);
}
