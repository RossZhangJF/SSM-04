package com.ross.control;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ross.entry.Student;
import com.ross.service.impl.GradeServiceImpl;
import com.ross.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentHandler {
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private GradeServiceImpl gradeService;

//    @ModelAttribute
//    public void Student(Model model){
//        model.addAttribute("student", new Student());
//    }

    @RequestMapping(value = "/shows",method = RequestMethod.GET)
    public String showStudent(@RequestParam(value = "pNum",defaultValue = "1")Integer pNum, Model model){
        PageHelper.startPage(pNum, 15);
        List<Student> students = studentService.getList();
        PageInfo<Student> pageInfo = new PageInfo <>(students,10);
        model.addAttribute("pages", pageInfo);
        System.out.println(pageInfo);
        return "list";
    }

}
