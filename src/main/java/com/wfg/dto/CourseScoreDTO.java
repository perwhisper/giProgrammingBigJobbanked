package com.wfg.dto;

import lombok.Data;

@Data
public class CourseScoreDTO {

    private String courseName;  // 课程名称
    private double score; // 分数


    public CourseScoreDTO() {
    }

    public CourseScoreDTO(String courseName, double score) {
        this.courseName = courseName;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}


