package com.wfg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfg.entity.CourseStu;
import com.wfg.mapper.CourseStuMapper;
import com.wfg.service.CourseStuService;

@Service
public class CourseStuServiceImpl implements CourseStuService {

    @Autowired
    private CourseStuMapper courseStuMapper;

    @Override
    public List<CourseStu> getAllCourseStu() {
        return courseStuMapper.selectAll();
    }
}
