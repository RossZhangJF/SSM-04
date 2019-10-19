package com.ross.service.impl;

import com.ross.dao.GradeMapper;
import com.ross.entry.Grade;
import com.ross.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public List <Grade> getList() {
        return gradeMapper.selectByExample(null);
    }

    @Override
    public Grade getById(Integer grId) {
        return gradeMapper.selectByPrimaryKey(grId);
    }
}
