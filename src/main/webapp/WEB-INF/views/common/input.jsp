<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加信息</h4>
            </div>
            <%
                Map <String ,String> sex=new HashMap <String ,String>();
                sex.put("F","男");
                sex.put("M","女");
                request.setAttribute("sex",sex);
            %>
            <form:form action="inputStu?pNum=${pages.pages}" method="post" modelAttribute="student">
                <%--                            <form:hidden path="${pages.pages}"></form:hidden>--%>
                <div class="modal-body">
                    <table>
                        <tr>
                            <td><form:label path="stuName">学生姓名</form:label></td>
                            <td><form:input path="stuName" cssClass="form-control"></form:input></td>
                            <td><form:errors path="stuName" cssClass="error"></form:errors></td>
                        </tr>
                        <tr>
                            <td><form:label path="stuPwd">学生密码</form:label></td>
                            <td><form:password path="stuPwd" cssClass="form-control"></form:password></td>
                            <td><form:errors path="stuPwd" cssClass="error"></form:errors></td>
                        </tr>
                        <tr>
                            <td><form:label path="stuAge">年龄</form:label></td>
                            <td>
                                    <%--<div class="input-group">
                                        <span class="input-group-addon">@</span>
                                        <form:input path="stuAge" cssClass="form-control" ></form:input>
                                    </div>--%>
                                <form:input path="stuAge" cssClass="form-control" ></form:input>
                            </td>
                            <td><form:errors path="stuAge" cssClass="error"></form:errors></td>
                        </tr>
                        <tr>
                            <td><form:label path="stuSex">性别</form:label></td>
                            <td>
                                <form:radiobuttons path="stuSex" items="${sex}" ></form:radiobuttons>
                                    <%--<form:radiobutton path="stuSex" value="F" checked="true">男</form:radiobutton>
                                    <form:radiobutton path="stuSex" value="M">女</form:radiobutton>--%>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><form:label path="stuBirthday">生日</form:label></td>
                            <td><form:input path="stuBirthday"></form:input></td>
                            <td><form:errors path="stuBirthday" cssClass="error"></form:errors></td>
                        </tr>
                        <tr>
                            <td><form:label path="grId">班级</form:label></td>
                            <td><form:select path="grId" items="${grade}" itemValue="grId" itemLabel="grName"></form:select></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <form:button value="submit" class="btn btn-success">保存</form:button>
                </div>
            </form:form>
        </div>
    </div>
</div>
