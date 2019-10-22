package com.ross.entry;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Student {
    private Integer stuId;

    @NotEmpty
    private String stuName;

    @NotEmpty
    @Size(min = 6,max = 20,message = "密码长度只能在6-20之间")
    private String stuPwd;

    @Max(value = 200,message = "年龄不能大于200岁")
    @Min(value = 1,message = "年龄不能小于1岁")
    private Integer stuAge;

    private String stuSex;

    private Grade grade;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stuBirthday;

    private Integer grId;

    private Integer pages;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd == null ? null : stuPwd.trim();
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex == null ? null : stuSex.trim();
    }

    public Date getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(Date stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public Integer getGrId() {
        return grId;
    }

    public void setGrId(Integer grId) {
        this.grId = grId;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Student() {
    }

    public Student(Integer stuId, String stuName, String stuPwd, Integer stuAge, String stuSex, Date stuBirthday, Integer grId) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuPwd = stuPwd;
        this.stuAge = stuAge;
        this.stuSex = stuSex;
        this.stuBirthday = stuBirthday;
        this.grId = grId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuPwd='" + stuPwd + '\'' +
                ", stuAge=" + stuAge +
                ", stuSex='" + stuSex + '\'' +
                ", grade=" + grade +
                ", stuBirthday=" + stuBirthday +
                '}';
    }
}