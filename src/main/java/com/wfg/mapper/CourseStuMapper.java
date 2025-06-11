package com.wfg.mapper;

import com.wfg.dto.ScoreBoardDTO;
import com.wfg.entity.CourseStu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CourseStuMapper {

    // 根据课程返回成绩表数据
    List<CourseStu> selectBySno(String sno);

    int updateOne(CourseStu courseStu);

    List<ScoreBoardDTO> selectByCno(String cno);
    List<CourseStu> selectAll();
}
