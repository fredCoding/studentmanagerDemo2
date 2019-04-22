package com.atsiacu.studentmanager.differentschool.universityschoolA.dao;

import com.atsiacu.studentmanager.differentschool.commonbasicentity.ClassInfo;
import com.atsiacu.studentmanager.differentschool.universityschoolA.entity.ClassInfoA;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

public interface ClassInfoARepository extends MongoRepository<ClassInfoA,String>{
    //以课程号和schoohl_id为查询条件 查询课程信息
    <ClassInfoA extends ClassInfo> Optional<ClassInfoA> findOneByClassNoAndSchoolId(String classNo,String school_id);

//    <ClassInfoA extends ClassInfo> Optional<ClassInfoA> findOneByClassNoAndSchoolId(String classNo);

//    Optional<ClassInfoA> findOneByClassNoAndSchoolId(String classNo,String school_id);

    //增加一门课
    ClassInfoA insert(ClassInfoA classInfoA);


    //删除一门课
    void deleteByClassNoAndSchoolId(String classNo,String schoolId);
}
