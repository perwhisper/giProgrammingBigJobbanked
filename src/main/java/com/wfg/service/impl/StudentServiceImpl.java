package com.wfg.service.impl;

import com.wfg.dto.CourseScoreDTO;
import com.wfg.dto.StudentScoreDTO;
import com.wfg.entity.Course;
import com.wfg.entity.CourseStu;
import com.wfg.entity.Student;
import com.wfg.mapper.CourseMapper;
import com.wfg.mapper.CourseStuMapper;
import com.wfg.mapper.StudentMapper;
import com.wfg.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseStuMapper courseStuMapper;

    @Override
    public List<Student> getStudentInfoList() {
        return studentMapper.getAllStudents();
    }

    @Override
    public void addOneStudent(Student student) {
        studentMapper.insertOneStudent(student);
    }

    @Override
    public Student selectBySno(String sno) {
        Student student = studentMapper.selectOneBySno(sno);
        return student;
    }

    @Override
    public int updateStudentBySno(Student student) {

        int result = studentMapper.updateOneStudent(student);
        return 0;
    }

    @Override
    public int deleteStudent(String sno) {
        return studentMapper.deleteOneStudent(sno);
    }


    /**
     * 返回学生成绩数据
     *
     * @return
     */
    @Override
    public List<StudentScoreDTO> getStudentScores() {
        List<StudentScoreDTO> result = new ArrayList<>();
        // 1. 查询所有学生
        List<Student> students = studentMapper.getAllStudents();
        // 2. 查询所有课程（用于映射课程ID 到课程名）
        List<Course> courses = courseMapper.selectList(null);
        Map<String,String> courseMap = new HashMap<>();
        courses.forEach(course -> courseMap.put(course.getCno(), course.getCname()));
        // 3. 变量学生，组装成绩数据
        for(Student student:students){
            StudentScoreDTO dto  = new StudentScoreDTO();
            dto.setSno(student.getSno());
            dto.setSname((student.getSname()));
            // 查询该学生的所有课程成绩
            List<CourseStu> courseStus = courseStuMapper.selectBySno(student.getSno());
            // 装换为CourseScoreDTO列表
            List<CourseScoreDTO> scoreList = new ArrayList<>();
            for (CourseStu courseStu :courseStus){
                CourseScoreDTO scoreDTO = new CourseScoreDTO();
                scoreDTO.setCourseName(courseMap.get(courseStu.getCno())); // 通过cno  获得 课程名称
                scoreDTO.setScore(courseStu.getScore());  // 获得他的分数
                scoreList.add(scoreDTO);
            }
            dto.setScores(scoreList);
            result.add(dto);
        }
        return result;
    }

    @Override
    public List<Course> selectAllCourse() {
        return courseMapper.selectList(null);
    }

    @Override
    public int updateScoreBySno(CourseStu courseStu) {
        int result = courseStuMapper.updateOne(courseStu);
        return 0;
    }
}