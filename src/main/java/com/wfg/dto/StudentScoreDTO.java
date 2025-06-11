package com.wfg.dto;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.List;

@Data
public class StudentScoreDTO {
    @ExcelProperty("学号")
    private String sno;  // 学号

    @ExcelProperty("姓名")
    private String sname; // 学生姓名
    private List<CourseScoreDTO> scores; // 课程创建列表


    public StudentScoreDTO() {
    }

    public StudentScoreDTO(String sno, String sname, List<CourseScoreDTO> scores) {
        this.sno = sno;
        this.sname = sname;
        this.scores = scores;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public List<CourseScoreDTO> getScores() {
        return scores;
    }

    public void setScores(List<CourseScoreDTO> scores) {
        this.scores = scores;
    }
}

//public class StudentScoreDTO {
//    private String sno;       // 学号
//    private String sname;     // 姓名
//    private List<CourseScoreDTO> scores; // 课程成绩列表
//}
