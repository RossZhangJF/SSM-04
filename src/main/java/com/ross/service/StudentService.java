package com.ross.service;

import com.github.pagehelper.PageInfo;
import com.ross.entry.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    List<Student> getList();
    List<Student> getStudentContainGrade();
    Student getById(@Param("stuId") Integer stuId);
    int insertStudent(Student student);
    PageInfo <Student> getStudentPage(@Param("stuId")Integer stuId, Integer pageNum, Integer pageSize);
    int updateStudent(Student student);
    int deleteStudentById(@Param("stuId")Integer stuId);
}
