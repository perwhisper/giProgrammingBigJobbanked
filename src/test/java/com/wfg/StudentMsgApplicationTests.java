package com.wfg;

import com.wfg.dto.ScoreBoardDTO;
import com.wfg.entity.Student;
import com.wfg.mapper.CourseStuMapper;
import com.wfg.mapper.StudentMapper;
import com.wfg.service.ScoreService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class StudentMsgApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private ScoreService scoreService;

	@Test
	void testUpdate(){
		Student student = new Student();
		student.setSno("0000000");
		student.setSname("李四");
		int i = studentMapper.updateOneStudent(student);
		if(i!=0){
			System.out.println("修改成功");
		}
	}

	@Test
	void testDelete(){
		int i = studentMapper.deleteOneStudent("0000000");if(i!=0){
			System.out.println("修改成功");
		}

	}


	@Test
	void  testScoreBoard(){
		Map<String, List<ScoreBoardDTO>> borad = scoreService.getScoreBorad();
		System.out.println("结果为：");
		System.out.println(borad);
	}
}
