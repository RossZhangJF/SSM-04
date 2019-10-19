package com.ross.service;

import com.ross.entry.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeService {
    List <Grade> getList();
    Grade getById(@Param("grId") Integer grId);

}
