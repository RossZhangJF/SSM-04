<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  User: Ross
  Date: 2019/10/18
  Time: 18:23
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>Title</title>
    <jsp:include page="common/js.jsp"/>
</head>
<body>
    <div class="container">
        <div class="container-fluid">
            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#uploadModal">
                <%--<img src="static/upload/img/i03.png" id="img" class="img-circle">--%>
                <img src="${avator.imgUrl}" id="img" class="img-circle">
                <%--<img src="upload/i03.png" id="img" class="img-circle">--%>
            </button>
            <jsp:include page="common/upload.jsp"></jsp:include>
        </div>
        <div class="row">
            <div class="col-md-3"><h1>学生信息</h1></div>
            <div class="col-md-4 col-md-offset-5">
                <form class="form-inline " >
                    <input id="keyWord" name="keyWord" class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                    <button id="submit_search" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-md-offset-6">
                <a href="showGrade" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true">新增学生信息</span>
                </a>
                <jsp:include page="common/input.jsp"></jsp:include>
            </div>
            <%--全部删除学生信息--%>
            <div class="col-md-3">
                <button type="button" id="delete_all" class="btn btn-danger btn-lg">
                    <span class="glyphicon glyphicon-trash" aria-hidden="true">全部删除</span>
                </button>
            </div>
        </div>
        <div class="row">
            <table class="table table-hover ">
                <form method="post">
                    <input type="hidden" value="DELETE" name="_method">
                </form>
                <thead>
                <tr>
                    <%---<th><input type="checkbox" οnclick="checkAll()" id="check_all" name="check_all">全选</th>---%>
                    <th><input type="checkbox"  name="all">全选</th>
                    <th>姓名</th>
                    <th>年龄</th>
                    <th>性别</th>
                    <th>生日</th>
                    <th>班级</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr></thead>
                <tbody id="tb">
                <c:forEach items="${pages.list}" var="stu">
                    <tr class="table-view">
                        <td>
                            <input type="checkbox" name="id" value="${stu.stuId}" οnclick="userCheck(this)">&nbsp;
                            <span>${stu.stuId}</span>
                        </td>
                        <td><span>${stu.stuName}</span></td>
                        <td><span>${stu.stuAge}</span></td>
                        <td><span>${stu.stuSex=="F"?"男":"女"}</span></td>
                        <td><span><fmt:formatDate value="${stu.stuBirthday}" pattern="yyyy-MM-dd" /></span></td>
                        <td><span>${stu.grade.grName}</span></td>
                        <td>
                            <a href="editStu?stuId=${stu.stuId}"  class="btn bg-info btn-sm" aria-label="Left Align">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true">编辑</span>
                            </a>
                        </td>
                        <td >
                            <a href="deleteStu?stuId=${stu.stuId}" class="delete btn bg-danger btn-sm" aria-label="Left Align" >
                                <span class="glyphicon glyphicon-trash" aria-hidden="true">删除</span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row">
            <div class="col-md-4 allHeight">
                <p>总共${pages.pages}页/当前${pages.pageNum}页</p>
            </div>
            <div class="col-md-8">
                <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li ><a href="shows?pNum=1" aria-label="Previous"><span aria-hidden="true">首页</span></a></li>
                    <!--循环遍历显示分页，若是当前页就高亮显示-->
                    <c:forEach items="${pages.navigatepageNums}" var="navNums">
                        <c:if test="${navNums == pages.pageNum}">
                            <li class="active"><a href="#">${navNums}</a></li>
                        </c:if>
                        <c:if test="${navNums != pages.pageNum}">
                            <li><a href="shows?pNum=${navNums}">${navNums}</a></li>
                        </c:if>
                    </c:forEach>
                    <li ><a href="shows?pNum=${pages.pages}" aria-label="Previous"><span aria-hidden="true">尾页</span></a></li>
                </ul>
                </nav>
            </div>
        </div>

    </div>

    <script type="text/javascript">
        $(function(){
            $(".delete").click(function(){
                if(confirm("是否确定删除，此操作不可逆")){
                    //console.log(44444);
                    var href=$(this).attr("href");
                    $("form").attr("action",href).submit();
                }
                return false;
            })
        })

    </script>

    <script>

        $("#submit_search").on("click",function(){
            $.ajax({
                url:"shows",
                type:"GET",
                data:{"keyWord":$("#keyWord").val()},
                datatype:"json",
                success:function(){
                    console.log("查询到数据了");
                },
                error:function(){
                    alert("没有查询的数据");
                }
            }) ;
        })

        $(function(){
            //全选，设置checkbox name='all' id=tb
            $("input[name=all]").click(function(){
                if(this.checked){
                    $("input[name=id]:checkbox").prop("checked",true);
                }else{
                    $("input[name=id]:checkbox").prop("checked",false);
                }
            });
        });

        //单选 设置 name=id;
        function userCheck(ths){
            if(ths.checked== false){
                $("input[name=all]:checkbox").prop("checked",false);
            }else{
                var count = $("input[name='id']:checkbox:checked").length;
                if(count == $("input[name='id']:checkbox").length){
                    $("input[name=all]:checkbox").prop("checked",true);
                }
            }
        }

        /*全部删除操作*/
        $(function(){
            $("#delete_all").click(function(e){
                console.log("delete_all");
                var dataOne=getSelect();
                if(dataOne.length == 0){
                    alert("请至少选择一条数据");return false;
                }
                if(confirm("确定删除所选项目?")){
                    var checkedList = new Array();
                    $.ajax({
                        type:"POST",
                        url:"deleteStuAll",
                        /*
                            Spring使用AJAX将post请求装换为DELETE
                            在data中加入_method:"DELETE",即可
                        */
                        data:{_method:"DELETE","delItems":dataOne.toString()},
                        datatype:"json",
                        success:function(data){
                            $("[name='id']:checkbox").attr("checked",false);
                            location.reload();//页面刷新
                        },
                        error:function(data){
                            art.dialog.tips('删除失败!');
                        }
                    });
                }
            });
        });


        //获取选中
        function getSelect(){
            var allData=new Array();
            var num=0;
            $("input[name='id']:checkbox:checked").each(function(){
                allData[num] = $(this).val();
                num ++;
                //console.log(allData);
            });
            return allData;
        }
    </script>
    <script src="static/jQuery/jquery-3.0.0.min.js"></script>
    <script src="static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</body>
</html>