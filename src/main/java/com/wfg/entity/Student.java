package com.wfg.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = -2540180221416421377L;
    private String sno; // 学号
    private String sname ;// 学生姓名
    private Integer  sex; // 性别
    private String photoUrl; // 头像存储地址
    private Date  birthday; // 生日
    private String college; // 学院
    private String major ; //  专业
    private String grade; // 班级
    private Timestamp createTime ; // 创建时间
    private Timestamp updateTime; // 修改时间
    private Integer isDelete; // 是否禁用


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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Student(String sno, String sname, Integer sex, String photoUrl, Date birthday, String college, String major, String grade, Timestamp createTime, Timestamp updateTime, Integer isDelete) {
        this.sno = sno;
        this.sname = sname;
        this.sex = sex;
        this.photoUrl = photoUrl;
        this.birthday = birthday;
        this.college = college;
        this.major = major;
        this.grade = grade;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sex=" + sex +
                ", photoUrl='" + photoUrl + '\'' +
                ", birthday=" + birthday +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }



}
