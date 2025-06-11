package com.wfg.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class Course implements Serializable {

    private static final long serialVersionUID = -3756404168077849924L;
    private String cno; // 课程号
    private String cname; // 课程名
    private Timestamp createTime; // 创建时间
    private Integer isDelete;

    public Course() {
    }

    public Course(String cno, String cname, Timestamp createTime, Integer isDelete) {
        this.cno = cno;
        this.cname = cname;
        this.createTime = createTime;
        this.isDelete = isDelete;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
