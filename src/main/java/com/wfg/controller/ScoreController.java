package com.wfg.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.wfg.dto.CourseScoreDTO;
import com.wfg.dto.ScoreBoardDTO;
import com.wfg.dto.StudentScoreDTO;
import com.wfg.entity.Course;
import com.wfg.entity.CourseStu;
import com.wfg.mapper.CourseStuMapper;
import com.wfg.service.ScoreService;
import com.wfg.service.StudentService;
import com.wfg.utils.Result;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    StudentService studentService;


    @Autowired
    ScoreService scoreService;

    @GetMapping("/board")
    public Result getScoreForBoard(){
        Map<String,List<ScoreBoardDTO>> mapperBoradScore = scoreService.getScoreBorad();

        return Result.success(mapperBoradScore);
    }


    @PostMapping("/grades")
    public Result updateCourse(@RequestBody CourseStu courseStu){


        int result = studentService.updateScoreBySno(courseStu);

        return Result.success();

    }


    @GetMapping("/courses")
    public Result<List<Course>> getCourse(){
        List<Course> courseList= studentService.selectAllCourse();

        return  Result.success(courseList);
    }



    @GetMapping("/scores")
    public Result getStudentScore(){

        List<StudentScoreDTO> studentScores = studentService.getStudentScores();
        return Result.success(studentScores);
    }

    @GetMapping("/export/students")
    public void exportStudentScore(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String sortType, //asc ,desc
            HttpServletResponse response
    ) throws IOException {
        // 拿到数据
        List<StudentScoreDTO> studentScoreList = studentService.getStudentScores();

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=学生成绩表.xlsx");

        // 使用 easyexcel 写入 Excel 文件到响应流
        ExcelWriterBuilder writerBuilder = EasyExcel.write(response.getOutputStream());
        ExcelWriterSheetBuilder sheetBuilder = writerBuilder.sheet("学生成绩表");

        // 处理数据结构，将 StudentScoreDTO 转换为适合导出的格式
        List<List<Object>> dataList = new ArrayList<>();
        for (StudentScoreDTO student : studentScoreList) {
            List<Object> row = new ArrayList<>();
            row.add(student.getSno());
            row.add(student.getSname());
            for (CourseScoreDTO course : student.getScores()) {
                row.add(course.getCourseName());
                row.add(course.getScore());
            }
            dataList.add(row);
        }
        // 写入数据
        sheetBuilder.doWrite(dataList);
    }
}
