package com.atsiacu.studentmanager.differentschool;

import com.atsiacu.studentmanager.differentschool.middleschoolB.entity.ObjectValueB;
import com.atsiacu.studentmanager.differentschool.middleschoolB.service.SchoolBService;
import com.atsiacu.studentmanager.differentschool.universityschoolA.dao.ClassInfoARepository;
import com.atsiacu.studentmanager.differentschool.universityschoolA.dao.StudentInfoARepository;
import com.atsiacu.studentmanager.differentschool.universityschoolA.dao.StudentScoreARepository;
import com.atsiacu.studentmanager.differentschool.universityschoolA.entity.ObjectValueA;
import com.atsiacu.studentmanager.differentschool.universityschoolA.entity.StudentInfoA;
import com.atsiacu.studentmanager.differentschool.universityschoolA.entity.StudentScoreA;
import com.atsiacu.studentmanager.differentschool.universityschoolA.service.SchoolAService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentmanagerApplicationTests {

	@Test
	public void contextLoads() {

	}

	//////////////////////////   测试大学A    /////////////////////////

	//测试ClassInfoARepository
	@Autowired
	ClassInfoARepository classInfoARepository;

	@Test
	public void testclassInfoA(){

//	    Optional<ClassInfoA> backclassInfo = classInfoARepository.findOneByClassNoAndSchoolId("101","A");

//        Optional<ClassInfoA> backclassInfo = classInfoARepository.findOneByClassNoAndSchoolId("101");

//		System.out.println(backclassInfo.toString());
//        ClassInfoA classInfoA = new ClassInfoA();
//        classInfoA.setSchoolId("A");
//        classInfoA.setClassName("大数据");
//        classInfoA.setClassNo("105");
//        classInfoA.setClassRoom("1-102");
//        classInfoA.setClassTime("7-8");
//
//
//        ClassInfoA backClassInfoA = classInfoARepository.insert(classInfoA);
//        System.out.println(backClassInfoA);

        classInfoARepository.deleteByClassNoAndSchoolId("101", "A");


    }

    //测试schoolService
	@Autowired
	SchoolAService schoolAService;
	@Test
	public void testupdate(){
		//测试ClassInfoA的更新
//		ClassInfoA classInfoA = new ClassInfoA();
//		classInfoA.setClassName("计算机操作系统");
////		classInfoA.setClassRoom("1-301");
//
////		classInfoA.setClassTime("1-2");
////		classInfoA.setClassNo("102");
//
//		ClassInfoA backClassInfoA = schoolAService.upateClassInfoABySet("102", classInfoA);
//		System.out.println(backClassInfoA);


		//测试studentInfoA更新
//		StudentInfoA studentInfoA1 = new StudentInfoA();
//		studentInfoA1.setEmail("777@163.com");
//		studentInfoA1.setHomeAddress("郑州");
//		studentInfoA1.setSchoolId("A");
//		studentInfoA1.setHotelNo("C-701");
////		studentInfoA1.setStudentNo("20200897");
//		studentInfoA1.setStudentName("李秀儿");
//		studentInfoA1.setPhoneNo("15378901611");
//		StudentInfoA backStudentInfoA = schoolAService.updateStudentInfoABySet("20200489", studentInfoA1);
//		System.out.println(backStudentInfoA);

		StudentScoreA studentScoreA = new StudentScoreA();
		studentScoreA.setScore(90);
		studentScoreA.setClassRake(10);
		studentScoreA.setSchoolId("A");

		StudentScoreA backStudentScoreA = schoolAService.updateStudentScoreABySet("20200476","104",studentScoreA);

		System.out.println(backStudentScoreA);


	}

	//测试studenInfoARespository
	@Autowired
	StudentInfoARepository studentInfoARepository;

	@Test
	public void testStudentInfoA(){
		Optional<StudentInfoA> studentInfoA = studentInfoARepository.findOneByStudentNoAndSchoolId("20200489", "A");

//		Optional<StudentInfoA> studentInfoA = studentInfoARepository.findOneByStudentNoAndSchoolId("20200489", "A");

		System.out.println(studentInfoA);


//		StudentInfoA studentInfoA1 = new StudentInfoA();
//		studentInfoA1.setEmail("777@163.com");
//		studentInfoA1.setHomeAddress("郑州");
//		studentInfoA1.setSchoolId("A");
//		studentInfoA1.setHotelNo("C-701");
//		studentInfoA1.setStudentNo("20200897");
//		studentInfoA1.setStudentName("李秀儿");
//		studentInfoA1.setPhoneNo("15378901611");
//
//		StudentInfoA studentInfoA2 = studentInfoARepository.insert(studentInfoA1);
//		System.out.println(studentInfoA2);

		studentInfoARepository.deleteByStudentNoAndSchoolId("20200897","A");

	}


	//测试StudentScoreA
	@Autowired
	StudentScoreARepository studentScoreARepository;

	@Test
	public void testStudentScoreA(){
//		Optional<StudentScoreA> backStudentScoreA = studentScoreARepository.findOneByStudentNoAndClassNoAndSchoolId("20200476", "103","A");
//		System.out.println(backStudentScoreA);

		List<StudentScoreA> backStudentScoreList = studentScoreARepository.findAllByStudentNoAndSchoolId("20200476", "A");
		for (StudentScoreA i : backStudentScoreList){

			System.out.println(i);
		}

//		StudentScoreA studentScoreA = new StudentScoreA();
//		studentScoreA.setClassNo("106");
//		studentScoreA.setStudentNo("20200476");
//		studentScoreA.setScore(90);
//		studentScoreA.setClassRake(10);
//		studentScoreA.setSchoolId("A");
//
//		StudentScoreA backStudentScoreA1 = studentScoreARepository.insert(studentScoreA);
//		System.out.println(backStudentScoreA1);
//
//		studentScoreARepository.deleteByStudentNoAndClassNoAndSchoolId("20200476","106","A");
	}


	//测试ObjectValueA查询

	@Test
	public void testfindObjectValue(){
		ObjectValueA backObjectValue = schoolAService.findByStudentNoAndSchoolId("20200489");
		System.out.println(backObjectValue);


	}

	///////////////////////////////////////  测试middleschoolB ////////////////////////////////////////////////////

	//测试ObjectValueB
	@Autowired
	SchoolBService schoolBService;

	@Test
	public void testschoolBServiceObjectBFind(){
		ObjectValueB backObectValueB = schoolBService.findByStudentNoAndSchoolId("B102");
		System.out.println(backObectValueB);

	}


}
