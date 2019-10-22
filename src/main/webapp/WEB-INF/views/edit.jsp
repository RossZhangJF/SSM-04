<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PC_01
  Date: 2019/10/21
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="common/js.jsp"></jsp:include>
    <style>
        .error{color:red;}
    </style>
</head>
<body>
<%
    Map <String ,String> sex=new HashMap <String ,String>();
    sex.put("F","男");
    sex.put("M","女");
    request.setAttribute("sex",sex);
%>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="jumbotron">
                <h1>修改学生信息</h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <form:form action="updateStu" method="post" modelAttribute="student" cssClass="form-horizontal">
                <form:hidden path="stuId"/>
                <div class="modal-body">
                    <div class="form-group">
                        <form:label path="stuName" cssClass="col-sm-2 control-label" >学生姓名</form:label>
                        <div class="col-sm-6">
                            <form:input path="stuName"  cssClass="form-control"></form:input>
                        </div>
                        <div class="col-sm-2">
                            <form:errors path="stuName"  cssClass="error"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label path="stuPwd" cssClass="col-sm-2 control-label">学生密码</form:label>
                        <div class="col-sm-6">
                            <form:password path="stuPwd" cssClass="form-control"></form:password>
                        </div>
                        <div class="col-sm-2">
                            <form:errors path="stuPwd" cssClass="error"></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label path="stuAge" cssClass="col-sm-2 control-label">年龄</form:label>
                        <div class="col-sm-6">
                            <form:input path="stuAge" cssClass="form-control" ></form:input>
                        </div>
                        <div class="col-sm-2">
                            <form:errors path="stuAge" cssClass="error" ></form:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label path="stuSex" cssClass="col-sm-2 control-label">性别</form:label>
                        <div class="col-sm-6">
                            <form:radiobuttons path="stuSex" items="${sex}" ></form:radiobuttons>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label path="stuBirthday" cssClass="col-sm-2 control-label">生日</form:label>
                        <div class="col-sm-6">
                            <form:input path="stuBirthday" id="stuBir" cssClass="form-control"></form:input>
                        </div>
                        <div class="col-sm-2">
                            <span id="error-birthday" class="error"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label path="grId" cssClass="col-sm-2 control-label">班级</form:label>
                        <div class="col-sm-6">
                            <form:select path="grId" items="${grade}" itemValue="grId" itemLabel="grName"></form:select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <form:button value="submit" class="btn btn-success">保存</form:button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
<script>
    $(function() {
        var stuBir=$("#stuBir").val();
        console.log("123:"+stuBir);
    });
</script>
</body>
</html>
