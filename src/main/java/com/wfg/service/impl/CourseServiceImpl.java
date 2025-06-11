package com.wfg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfg.entity.Course;
import com.wfg.mapper.CourseMapper;
import com.wfg.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> getCoursesByIsDelete(Integer isDelete) {
        return courseMapper.selectByIsDelete(isDelete);
    }
}
