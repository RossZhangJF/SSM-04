package com.ross.dao;

import com.github.pagehelper.PageInfo;
import com.ross.entry.Student;
import com.ross.entry.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer stuId);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    List<Student> selectWithLeftByExample(StudentExample example);

    List<Student> selectWithLeftBySearch(@Param("keyWord") String keyWord);

    Student selectByPrimaryKey(Integer stuId);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectUserByUserName(@Param("stuId") Integer stuId);
}