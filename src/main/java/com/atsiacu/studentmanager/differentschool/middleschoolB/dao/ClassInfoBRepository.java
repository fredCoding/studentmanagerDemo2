package com.atsiacu.studentmanager.differentschool.middleschoolB.dao;

import com.atsiacu.studentmanager.differentschool.middleschoolB.entity.ClassInfoB;
import com.atsiacu.studentmanager.differentschool.universityschoolA.entity.ClassInfoA;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClassInfoBRepository extends MongoRepository<ClassInfoB,String>{
    Optional<ClassInfoB> findOneByClassNoAndSchoolId(String classNo,String schoolId);

    ClassInfoB insert(ClassInfoB classInfoB);

    void deleteByClassNoAndSchoolId(String classNo,String schoolId);
}
