package com.ross.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ross.dao.StudentMapper;
import com.ross.entry.Student;
import com.ross.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    /*  依赖注入  */
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List <Student> getList() {
        return studentMapper.selectByExample(null);
    }

    @Override
    public Student getById(Integer stuId) {
        return studentMapper.selectByPrimaryKey(stuId);
    }

    @Override
    public int insertStudent(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public PageInfo <Student> getStudentPage(Integer stuId, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null?1:pageNum;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Student> list = studentMapper.selectUserByUserName(stuId);

        //用PageInfo对结果进行包装
        PageInfo<Student> page = new PageInfo<>(list);

        return page;
    }
}
