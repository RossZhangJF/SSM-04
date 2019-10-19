package com.ross.test;

import com.github.pagehelper.PageInfo;
import com.ross.entry.Student;
import com.ross.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class TestService {
    @Autowired
    private StudentServiceImpl studentService;

    @Test
    public void testPage(){
        PageInfo <Student> pageInfo = studentService.getStudentPage(2, 1, 10);
        System.out.println(pageInfo);
    }
    public void testList(){
        List<Student> student=studentService.getList();
        System.out.println(student.size());
    }

    public void test(){
        Student student=studentService.getById(5);
        System.out.println(student);
    }
}
