package com.wfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wfg.entity.Course;
import com.wfg.service.CourseService;
import com.wfg.utils.Result;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public Result<List<Course>> getCourses() {
        // 只返回未删除的课程
        return Result.success(courseService.getCoursesByIsDelete(0));
    }
}