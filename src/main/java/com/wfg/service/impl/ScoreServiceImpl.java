package com.wfg.service.impl;

import com.wfg.dto.ScoreBoardDTO;
import com.wfg.entity.Course;
import com.wfg.entity.CourseStu;
import com.wfg.entity.Student;
import com.wfg.mapper.CourseMapper;
import com.wfg.mapper.CourseStuMapper;
import com.wfg.mapper.StudentMapper;
import com.wfg.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseStuMapper courseStuMapper;

    @Override
    public Map<String, List<ScoreBoardDTO>> getScoreBorad() {

        Map<String,List<ScoreBoardDTO>> scoreMap = new HashMap<>();
        List<Course> courses = courseMapper.selectList(null);
        for (Course cours : courses) {

            List<ScoreBoardDTO> scoreBoardDTOS=courseStuMapper.selectByCno(cours.getCno());
            scoreMap.put(cours.getCname(),scoreBoardDTOS);
        }
        return scoreMap;
    }
}
