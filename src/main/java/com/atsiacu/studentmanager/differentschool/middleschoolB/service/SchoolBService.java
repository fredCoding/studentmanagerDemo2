package com.atsiacu.studentmanager.differentschool.middleschoolB.service;


import com.atsiacu.studentmanager.differentschool.middleschoolB.dao.ClassInfoBRepository;
import com.atsiacu.studentmanager.differentschool.middleschoolB.dao.StudentInfoBRepository;
import com.atsiacu.studentmanager.differentschool.middleschoolB.dao.StudentScoreBRepository;
import com.atsiacu.studentmanager.differentschool.middleschoolB.entity.ClassInfoB;
import com.atsiacu.studentmanager.differentschool.middleschoolB.entity.ObjectValueB;
import com.atsiacu.studentmanager.differentschool.middleschoolB.entity.StudentInfoB;
import com.atsiacu.studentmanager.differentschool.middleschoolB.entity.StudentScoreB;
import com.atsiacu.studentmanager.differentschool.universityschoolA.entity.StudentScoreA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SchoolBService {
    private final static String schoolId = "B";

    @Autowired
    MongoTemplate mongoTemplate;

    //对于StudentInfoB进行更新
    public StudentInfoB updateStudentInfoBBySet(String studentNo, StudentInfoB studentInfoB){
        Update update = new Update();

        if (studentInfoB.getHotelNo() != null)
            update.set("hotelNo",studentInfoB.getHotelNo());
        if (studentInfoB.getPhoneNo() != null)
            update.set("phoneNo",studentInfoB.getPhoneNo());
        if (studentInfoB.getHomeAddress() != null)
            update.set("home",studentInfoB.getHomeAddress());
        if (studentInfoB.getStudentName() != null)
            update.set("studentName",studentInfoB.getStudentName());
        if (studentInfoB.getStudentNo() != null)
            update.set("studentNo",studentInfoB.getStudentNo());

        if (studentInfoB.getHomeAddress() != null)
            update.set("home",studentInfoB.getHomeAddress());
        if (studentInfoB.getGuardianName() != null)
            update.set("guardianName",studentInfoB.getGuardianName());
        if (studentInfoB.getGuardianPhoneNo() != null)
            update.set("guardianPhoneNo",studentInfoB.getGuardianPhoneNo());


        if (update.toString().equals("{ }"))
            return null;

        Query query = new Query();
        query.addCriteria(Criteria.where("studentNo").is(studentNo)).addCriteria(Criteria.where("school_id").is(schoolId));

        StudentInfoB backStudentInfoB = mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true).upsert(false), StudentInfoB.class);

        return backStudentInfoB;
    }


    //对于ClassInfoB进行更新操作
    public ClassInfoB upateClassInfoBBySet(String classsNo, ClassInfoB classInfoB){
        Update update = new Update();

        if (classInfoB.getClassRoom() != null)
            update.set("classRoom",classInfoB.getClassRoom());
        if (classInfoB.getClassTime() != null)
            update.set("classTime",classInfoB.getClassTime());
        if (classInfoB.getClassName() != null)
            update.set("className",classInfoB.getClassName());
        if (classInfoB.getClassNo() != null)
            update.set("classNo",classInfoB.getClassNo());

        if (update.toString().equals("{ }"))
            return null;


        Query query = new Query();
        query.addCriteria(Criteria.where("classNo").is(classsNo)).addCriteria(Criteria.where("school_id").is(schoolId));

        ClassInfoB backClassInfoB = mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true).upsert(false), ClassInfoB.class);

        return backClassInfoB;

    }

    //对于StudentScoreB进行更新操作
    public StudentScoreB updateStudentScoreBBySet(String studentNo, String classNo, StudentScoreB studentScoreB){
        Update update = new Update();

        if (studentScoreB.getScore() >= 0 && studentScoreB.getScore() <= 100)
            update.set("score",studentScoreB.getScore());
        if (studentScoreB.getClassRake() >0)
            update.set("classRake",studentScoreB.getClassRake());
        if (studentScoreB.getClassNo() != null)
            update.set("classNo",studentScoreB.getClassNo());

        if (update.toString().equals("{ }"))
            return null;

        Query query = new Query();
        query.addCriteria(Criteria.where("studentNo").is(studentNo)).addCriteria(Criteria.where("school_id").is(schoolId)).addCriteria(Criteria.where("classNo").is(classNo));

        StudentScoreB backStudentScoreB = mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true).upsert(false), StudentScoreB.class);

        return backStudentScoreB;

    }

    //对于ObjectB进行查询操作
    @Autowired
    StudentInfoBRepository studentInfoBRepository;
    @Autowired
    StudentScoreBRepository studentScoreBRepository;
    @Autowired
    ClassInfoBRepository classInfoBRepository;

    public ObjectValueB findByStudentNoAndSchoolId(String studentNo){
        Optional<StudentInfoB> op = studentInfoBRepository.findOneByStudentNoAndSchoolId(studentNo, schoolId);

        ObjectValueB objectValueB = new ObjectValueB();

        if (op.isPresent()){
            StudentInfoB studentInfoB = op.get();

            objectValueB.setStudentNo(studentInfoB.getStudentNo());
            objectValueB.setStudentName(studentInfoB.getStudentName());


            objectValueB.setHomeAddress(studentInfoB.getHomeAddress());
            objectValueB.setGuardianName(studentInfoB.getGuardianName());
            objectValueB.setGuardianPhoneNo(studentInfoB.getGuardianPhoneNo());
        }

        List<StudentScoreB> studentScoreBS = studentScoreBRepository.findAllByStudentNoAndSchoolId(studentNo, schoolId);

        StudentScoreB studentScoreB = studentScoreBS.get(0);
        objectValueB.setScore(studentScoreB.getScore());

        Optional<ClassInfoB> opclassInfoB = classInfoBRepository.findOneByClassNoAndSchoolId(studentScoreB.getClassNo(), schoolId);
        if (opclassInfoB.isPresent()){
            ClassInfoB classInfoB = opclassInfoB.get();
            objectValueB.setClassName(classInfoB.getClassName());

        }

        return objectValueB;

    }


}
