<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
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
        .error{color:red;}
    </style>
    <script type="text/javascript">
        $(function(){
            $(".delete").click(function(){
                console.log(44444);
                var href=$(this).attr("href");
                $("form").attr("action",href).submit();
                return false;
            })
        })
    </script>
</head>
<body>
    <div class="container">
        <div class=""><h1>学生信息</h1></div>
        <div class="col-md-8 col-md-offset-9">
            <a href="showGrade" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                <span class="glyphicon glyphicon-plus" aria-hidden="true">新增学生信息</span>
            </a>
            <jsp:include page="common/input.jsp"></jsp:include>
        </div>
        <div class="lead">
            <table class="table table-hover ">
                <form method="post">
                    <input type="hidden" value="DELETE" name="_method">
                </form>
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
                        <td><span>${stu.stuSex=="F"?"男":"女"}</span></td>
                        <td><span>${stu.stuBirthday}</span></td>
                        <td><span>${stu.grId}</span></td>
                        <td>
                            <a href="editStu?stuId=${stu.stuId}" class="btn bg-info btn-sm" aria-label="Left Align">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true">编辑</span>
                            </a>
                        </td>
                        <td>
                            <a href="deleteStu?stuId=${stu.stuId}" class="delete btn bg-danger btn-sm" aria-label="Left Align">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true">删除</span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-4 allHeight">
                <p>总共${pages.pages}页/当前${pages.pageNum}页</p>
            </div>
            <div class="col-md-8">
                <ul class="pager">
                    <li ><a href="shows?pNum=1" aria-label="Previous"><span aria-hidden="true">首页</span></a></li>
                    <c:forEach items="${pages.navigatepageNums}" var="navNums">
                        <li ><a href="shows?pNum=${navNums}">${navNums}<span class="sr-only">(current)</span></a></li>
                    </c:forEach>
                    <li ><a href="shows?pNum=${pages.pages}" aria-label="Previous"><span aria-hidden="true">尾页</span></a></li>
                </ul>
            </div>
        </div>
    </div>

</body>
</html>