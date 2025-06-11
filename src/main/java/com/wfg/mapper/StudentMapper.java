package com.wfg.mapper;


import com.wfg.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

     List<Student> getAllStudents();

    void insertOneStudent(Student student);

    Student selectOneBySno(String sno);

    int updateOneStudent(Student student);

    int  deleteOneStudent(String sno);

    List<Student> selectByIsDelete(Integer isDelete);
}
