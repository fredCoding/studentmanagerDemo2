package com.atsiacu.studentmanager.differentschool.universityschoolA.service;

import com.atsiacu.studentmanager.differentschool.commonbasicentity.ClassInfo;
import com.atsiacu.studentmanager.differentschool.universityschoolA.dao.ClassInfoARepository;
import com.atsiacu.studentmanager.differentschool.universityschoolA.dao.StudentInfoARepository;
import com.atsiacu.studentmanager.differentschool.universityschoolA.dao.StudentScoreARepository;
import com.atsiacu.studentmanager.differentschool.universityschoolA.entity.ClassInfoA;
import com.atsiacu.studentmanager.differentschool.universityschoolA.entity.ObjectValueA;
import com.atsiacu.studentmanager.differentschool.universityschoolA.entity.StudentInfoA;
import com.atsiacu.studentmanager.differentschool.universityschoolA.entity.StudentScoreA;
import com.mongodb.client.result.UpdateResult;
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
public class SchoolAService {
    //针对A学校schoolId直接方法内部传入
    private final static String schoolId = "A";

    @Autowired
    MongoTemplate mongoTemplate;


    //对ClassInfoA进行更新操作
    public ClassInfoA upateClassInfoABySet(String classsNo,ClassInfoA classInfoA){
        Update update = new Update();

        if (classInfoA.getClassRoom() != null)
            update.set("classRoom",classInfoA.getClassRoom());
        if (classInfoA.getClassTime() != null)
            update.set("classTime",classInfoA.getClassTime());
        if (classInfoA.getClassName() != null)
            update.set("className",classInfoA.getClassName());
        if (classInfoA.getClassNo() != null)
            update.set("classNo",classInfoA.getClassNo());

        if (update.toString().equals("{ }"))
            return null;


        Query query = new Query();
        query.addCriteria(Criteria.where("classNo").is(classsNo)).addCriteria(Criteria.where("school_id").is(schoolId));

        ClassInfoA backClassInfoA = mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true).upsert(false), ClassInfoA.class);

        return backClassInfoA;

    }

    //对StudentInfoA进行更新操作
    public StudentInfoA updateStudentInfoABySet(String studentNo,StudentInfoA studentInfoA){
        Update update = new Update();

        if (studentInfoA.getHotelNo() != null)
            update.set("hotelNo",studentInfoA.getHotelNo());
        if (studentInfoA.getPhoneNo() != null)
            update.set("phoneNo",studentInfoA.getPhoneNo());
        if (studentInfoA.getHomeAddress() != null)
            update.set("home",studentInfoA.getHomeAddress());
        if (studentInfoA.getEmail() != null)
            update.set("email",studentInfoA.getEmail());
        if (studentInfoA.getStudentName() != null)
            update.set("studentName",studentInfoA.getStudentName());
        if (studentInfoA.getStudentNo() != null)
            update.set("studentNo",studentInfoA.getStudentNo());

        if (update.toString().equals("{ }"))
            return null;

        Query query = new Query();
        query.addCriteria(Criteria.where("studentNo").is(studentNo)).addCriteria(Criteria.where("school_id").is(schoolId));

        StudentInfoA backStudentInfoA = mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true).upsert(false), StudentInfoA.class);


        return  backStudentInfoA;
    }

    //对StudentScoreA进行更新
    public StudentScoreA updateStudentScoreABySet(String studentNo,String classNo,StudentScoreA studentScoreA){
        Update update = new Update();

        if (studentScoreA.getScore() >= 0 && studentScoreA.getScore() <= 100)
            update.set("score",studentScoreA.getScore());
        if (studentScoreA.getClassRake() >0)
            update.set("classRake",studentScoreA.getClassRake());
        if (studentScoreA.getClassNo() != null)
            update.set("classNo",studentScoreA.getClassNo());

        if (update.toString().equals("{ }"))
            return null;

        Query query = new Query();
        query.addCriteria(Criteria.where("studentNo").is(studentNo)).addCriteria(Criteria.where("school_id").is(schoolId)).addCriteria(Criteria.where("classNo").is(classNo));

        StudentScoreA backStudentScoreA = mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true).upsert(false), StudentScoreA.class);

        return backStudentScoreA;

    }


    //针对ObjectValueA查询

    @Autowired
    StudentInfoARepository studentInfoARepository;

    @Autowired
    StudentScoreARepository studentScoreARepository;

    @Autowired
    ClassInfoARepository classInfoARepository;

    public ObjectValueA findByStudentNoAndSchoolId(String studentNo){
        Optional<StudentInfoA> op = studentInfoARepository.findOneByStudentNoAndSchoolId(studentNo, schoolId);

        ObjectValueA objectValueA = new ObjectValueA();

        //将分文档查询出来的信息赋值给ObjectValue
        if (op.isPresent()) {
            StudentInfoA studentInfoA = op.get();

            objectValueA.setStudentNo(studentInfoA.getStudentNo());
            objectValueA.setStudentName(studentInfoA.getStudentName());
            objectValueA.setHotelNo(studentInfoA.getHotelNo());
            objectValueA.setPhoneNo(studentInfoA.getPhoneNo());

            objectValueA.setHomeAddress(studentInfoA.getHomeAddress());
            objectValueA.setEmail(studentInfoA.getEmail());
        }

        List<StudentScoreA> studentScoreAS = studentScoreARepository.findAllByStudentNoAndSchoolId(studentNo,schoolId);
        //假设取第一条数据
        StudentScoreA studentScoreA = studentScoreAS.get(0);
        objectValueA.setScore(studentScoreA.getScore());

        Optional<ClassInfo> opclassInfo = classInfoARepository.findOneByClassNoAndSchoolId(studentScoreA.getClassNo(), schoolId);
        if (opclassInfo.isPresent()){
            ClassInfo classInfo = opclassInfo.get();
            objectValueA.setClassName(classInfo.getClassName());
        }


        return objectValueA;
    }



}
