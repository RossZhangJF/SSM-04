<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  User: Ross
  Date: 2019/10/18
  Time: 18:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="static/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/jQuery/jquery-3.0.0.min.js"></script>
    <script src="static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <style>
        .allHeight{height:72px;}
        .allHeight p{margin:20px 0px;height:32px;}
    </style>
</head>
<body>
    <div class="container">
        <div class=""><h1>学生信息</h1></div>
        <div class="col-md-8 col-md-offset-9">
            <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                <span class="glyphicon glyphicon-plus" aria-hidden="true">新增学生信息</span>
            </button>

            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">添加信息</h4>
                        </div>
                        <div class="modal-body">
                            <form:form action="show" method="post" modelAttribute="student">
                                <form:label path="stuName">学生姓名</form:label>
                                <form:input path="stuName"></form:input>
                                <form:errors path="stuName"></form:errors>

                                <form:label path="stuPwd">学生密码</form:label>
                                <form:password path="stuPwd"></form:password>
                                <form:errors path="stuPwd"></form:errors>

                                <form:label path="stuAge">年龄</form:label>
                                <form:input path="stuAge"></form:input>
                                <form:errors path="stuAge"></form:errors>

                                <form:label path="stuSex">性别</form:label>
                                <%--<form:radiobuttons path="stuSex" items="${student.stuSex}"></form:radiobuttons>--%>
                                <%--<form:radiobutton path="stuSex" value="F" >男</form:radiobutton>
                                <form:radiobutton path="stuSex" value="M">女</form:radiobutton>--%>

                                <form:label path="stuBirthday">生日</form:label>
                                <form:input path="stuBirthday"></form:input>
                                <form:errors path="stuBirthday"></form:errors>

                                <form:label path="grId">班级</form:label>
                                <form:select path="grId" items="${student.grId}"
                                             itemValue="cgId" itemLabel="cgName">
                                </form:select>
                                <%--<form:select path="grId" items="">
                                    <form:option value=""></form:option>
                                </form:select>--%>

                            </form:form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary">保存</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="lead">
            <table class="table table-hover ">
                <tr class="">
                    <th>学生编号</th>
                    <th>姓名</th>
                    <th>年龄</th>
                    <th>性别</th>
                    <th>生日</th>
                    <th>班级</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
                <c:forEach items="${pages.list}" var="stu">
                    <tr class="table-view">
                        <td><span>${stu.stuId}</span></td>
                        <td><span>${stu.stuName}</span></td>
                        <td><span>${stu.stuAge}</span></td>
                        <td><span>${stu.stuSex}</span></td>
                        <td><span>${stu.stuBirthday}</span></td>
                        <td><span>${stu.grId}</span></td>
                        <td>
                            <button class="btn bg-info btn-xs" aria-label="Left Align">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true">编辑</span>
                            </button>
                        </td>
                        <td>
                            <button class="btn bg-danger btn-xs" aria-label="Left Align">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true">删除</span>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-6 allHeight">
                <p>总共${pages.pages}页/当前${pages.pageNum}页</p>
            </div>
            <div class="col-md-6">
                <ul class="pager">
                    <c:if test="${pages.navigateFirstPage >0}">
                        <li ><a href="show?pNum=1" aria-label="Previous"><span aria-hidden="true">首页</span></a></li>
                    </c:if>
                    <c:forEach items="${pages.navigatepageNums}" var="navNums">
                        <li ><a href="show?pNum=${navNums}">${navNums}<span class="sr-only">(current)</span></a></li>
                    </c:forEach>
                    <li ><a href="show?pNum=${pages.pages}" aria-label="Previous"><span aria-hidden="true">尾页</span></a></li>
                </ul>
            </div>
        </div>
    </div>

</body>
</html>