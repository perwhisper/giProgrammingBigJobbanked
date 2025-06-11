package com.wfg.dto;


import lombok.Data;

@Data
public class ScoreBoardDTO {

    private String sname;  // 姓名
    private double score; // 分数


    @Override
    public String toString() {
        return "ScoreBoardDTO{" +
                "sname='" + sname + '\'' +
                ", score=" + score +
                '}';
    }

    public ScoreBoardDTO() {
    }

    public ScoreBoardDTO(String sname, double score) {
        this.sname = sname;
        this.score = score;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
