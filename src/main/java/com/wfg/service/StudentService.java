package com.wfg.service;

import com.wfg.dto.StudentScoreDTO;
import com.wfg.entity.Course;
import com.wfg.entity.CourseStu;
import com.wfg.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudentInfoList();

    void addOneStudent(Student student);

    Student selectBySno(String sno);

    int updateStudentBySno(Student student);

    int deleteStudent(String sno);

    // 获取学生成绩列表（简化版，仅包含前端需要的数据）
    public List<StudentScoreDTO> getStudentScores();

    List<Course> selectAllCourse();

    int updateScoreBySno(CourseStu courseStu);

    List<Student> getStudentsByIsDelete(Integer isDelete);
}
