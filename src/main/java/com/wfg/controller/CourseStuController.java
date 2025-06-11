package com.wfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wfg.entity.CourseStu;
import com.wfg.service.CourseStuService;
import com.wfg.utils.Result;

@RestController
@RequestMapping("/api")
public class CourseStuController {

    @Autowired
    private CourseStuService courseStuService;

    @GetMapping("/course-stu")
    public Result<List<CourseStu>> getCourseStu() {
        return Result.success(courseStuService.getAllCourseStu());
    }
}