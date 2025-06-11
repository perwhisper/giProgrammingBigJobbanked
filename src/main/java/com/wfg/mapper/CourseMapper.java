package com.wfg.mapper;

import com.wfg.entity.Course;
import com.wfg.entity.CourseStu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {


    // 查询所有课程
    List<Course> selectList(Object o);


}
