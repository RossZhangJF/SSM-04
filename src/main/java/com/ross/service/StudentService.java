package com.ross.service;

import com.github.pagehelper.PageInfo;
import com.ross.entry.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    List<Student> getList();
    Student getById(@Param("stuId") Integer stuId);
    int insertStudent(Student student);
    PageInfo <Student> getStudentPage(Integer stuId, Integer pageNum, Integer pageSize);
}
