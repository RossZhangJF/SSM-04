package com.ross.control;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ross.entry.Student;
import com.ross.service.impl.GradeServiceImpl;
import com.ross.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String addStudent( Student student, @RequestParam(value = "pNum")Integer pNum){
        System.out.println("Wo shi POST  ,INPUT STU");
        studentService.insertStudent(student);
        return "redirect:/shows?pNum="+pNum;
    }

    /**
     * 编辑学生信息
     * @param student
     * @return
     */
    @RequestMapping(value = "/updateStu",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String updateStudent(@Valid Student student,Errors errors){
        if (errors.hasErrors()){
            List <FieldError> errorList = errors.getFieldErrors();
            for (FieldError fieldError : errorList) {
                System.out.println("field:" + fieldError.getField() + "\terrors:" + fieldError.getDefaultMessage());
            }
            return "edit";
        }
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
//        System.out.println("My Delete");
        studentService.deleteStudentById(stuId);
        return "redirect:/shows";
    }

    /**
     * 删除全部信息
     * @param delItems
     * @return
     */
    @RequestMapping(value = "/deleteStuAll")
    public String deleteStudentAll(@RequestParam(value = "delItems")String delItems){
//        System.out.println("My Delete ALL");
        String[] strS=delItems.split(",");
        int count=0;
        for (int i=0;i<strS.length;i++){
            System.out.print(strS[i]+"\t");
            String str = strS[i];
            count += studentService.deleteStudentById(Integer.parseInt(str));
        }
        System.out.println(count);
        return "redirect:/shows";
    }

    /**
     *  首页显示学生信息,或者显示搜索到的信息
     * @param pNum
     * @param model
     * @return
     */
    @RequestMapping(value = "/shows",method = RequestMethod.GET)
    public String showStudent(@RequestParam(value = "pNum",defaultValue = "1")Integer pNum,
                              @RequestParam(value = "keyWord",required = false) String keyWord, Model model){
        PageHelper.startPage(pNum, 15);
        List<Student> students = studentService.getStudentContainGrade();

        PageInfo<Student> pageInfo = new PageInfo <>(students,10);
        model.addAttribute("pages", pageInfo);
//        System.out.println(pageInfo);
        return "list";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

}
