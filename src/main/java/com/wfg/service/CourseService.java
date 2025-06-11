package com.wfg.service;

import java.util.List;

import com.wfg.entity.Course;

public interface CourseService {

    List<Course> getCoursesByIsDelete(Integer isDelete);
}
