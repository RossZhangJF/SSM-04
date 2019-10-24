package com.ross.control;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ross.entry.Avator;
import com.ross.entry.Student;
import com.ross.service.impl.GradeServiceImpl;
import com.ross.service.impl.StudentServiceImpl;
import com.ross.utils.UploadUtil;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
        Avator avator=new Avator(1,"static/upload/img/i03.png",1);
        model.addAttribute("avator",avator);
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
     *  首页显示学生信息,显示搜索到的信息
     * @param pNum
     * @param model
     * @return
     */
    @RequestMapping(value = "/shows",method = RequestMethod.GET)
    public String showStudent(@RequestParam(value = "pNum",defaultValue = "1")Integer pNum,
                              /*RequestParam中设置了可以Word自动是可有可无的*/
                              @RequestParam(value = "keyWord",required = false) String keyWord,Model model){
        PageHelper.startPage(pNum, 15);
        List<Student> students=null;
        if (keyWord == null ){
            students= studentService.getStudentContainGrade();
        }else{
            students=studentService.getStudentContainGradeSearch(keyWord);
        }
        PageInfo<Student> pageInfo = new PageInfo <>(students,10);
        model.addAttribute("pages", pageInfo);
        return "list";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String uploadImg(HttpServletRequest request,
                            @RequestParam("fileImg") MultipartFile fileImg){
        /*将上传的图片写入到指定的路径下*/
        if (fileImg!=null){
            /*得到绝对路径*/
            String path=request.getServletContext().getRealPath("/upload/");
            /*获取上传文件的全部名称*/
            String fileName=fileImg.getOriginalFilename();
            //获取上传文件的后缀名
            String suffix=fileName.substring(fileName.lastIndexOf("."));
            //重新指定文件名称
            String realImgName= UUID.randomUUID().toString()+suffix;
            // 创建File对象,注意这里不是创建一个目录或一个文件,你可以理解为是
            // 获取指定目录中文件的管理权限(增改删除判断等 . . .)
            File fileTemp=new File(path);
            if (!fileTemp.exists()){
                // 创建以此抽象路径名命名的目录,注意mkdir()只能创建一级目录,所以它的父级目录必须存在
                fileTemp.mkdir();
            }
            File file=new File(path+"\\"+realImgName);
//            File file=new File(path+realImgName);
            System.out.println("在指定路径创建："+file);
            try {
                fileImg.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            request.setAttribute("uploadImg", realImgName);
        }
        return "success";
    }
}
