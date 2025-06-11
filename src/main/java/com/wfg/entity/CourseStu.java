package com.wfg.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.PrintWriter;
import java.io.Serializable;

@Data
public class CourseStu implements Serializable {
    private static final long serialVersionUID = 7810503141469919836L;
    private Integer id;
    private String sno;
    private String cno;
    private double score;

    public CourseStu() {
    }

    public CourseStu(Integer id, String sno, String cno, double score) {
        this.id = id;
        this.sno = sno;
        this.cno = cno;
        this.score = score;
    }

    @Override
    public String toString() {
        return "CourseStu{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", score=" + score +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
