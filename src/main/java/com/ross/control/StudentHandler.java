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

    @ModelAttribute
    public void Student(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("grade", gradeService.getList());
    }

    @RequestMapping(value = "/showGrade")
    public void showGrade(Model model){
        model.addAttribute("grade", gradeService.getList());
    }

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    @RequestMapping(value = "/inputStu",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    public String addStudent(Student student,@RequestParam(value = "pNum")Integer pNum){
        System.out.println(student);
        studentService.insertStudent(student);
        return "redirect:/shows?pNum="+pNum;
    }

    /**
     * 编辑学生信息
     * @param student
     * @return
     */
    @RequestMapping(value = "/updateStu",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String updateStudent(Student student){
//        Student student= studentService.getById(stuId);
//        System.out.println(student);
        studentService.updateStudent(student);
        return "redirect:/shows";
    }
    @RequestMapping(value = "/editStu",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String editStudent(@RequestParam(value = "stuId")Integer stuId,Model model){
//        System.out.println("stuId="+stuId);
        model.addAttribute("student",studentService.getById(stuId));
        return "edit";
    }

    @RequestMapping(value = "/deleteStu",method = RequestMethod.DELETE)
    public String deleteStudent(@RequestParam(value = "stuId")Integer stuId){
        System.out.println("My Delete");
        studentService.deleteStudentById(stuId);
        return "redirect:/shows";
    }

    /**
     *  首页显示学生信息
     * @param pNum
     * @param model
     * @return
     */
    @RequestMapping(value = "/shows",method = RequestMethod.GET)
    public String showStudent(@RequestParam(value = "pNum",defaultValue = "1")Integer pNum, Model model){
        PageHelper.startPage(pNum, 15);
        List<Student> students = studentService.getStudentContainGrade();

        PageInfo<Student> pageInfo = new PageInfo <>(students,10);
        model.addAttribute("pages", pageInfo);
//        System.out.println(pageInfo);
        return "list";
    }

}
