package com.ross.dao;

import com.ross.entry.Grade;
import com.ross.entry.GradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeMapper {
    long countByExample(GradeExample example);

    int deleteByExample(GradeExample example);

    int deleteByPrimaryKey(Integer grId);

    int insert(Grade record);

    int insertSelective(Grade record);

    List<Grade> selectByExample(GradeExample example);

    Grade selectByPrimaryKey(Integer grId);

    int updateByExampleSelective(@Param("record") Grade record, @Param("example") GradeExample example);

    int updateByExample(@Param("record") Grade record, @Param("example") GradeExample example);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}