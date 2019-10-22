<%--
  Created by IntelliJ IDEA.
  User: PC_01
  Date: 2019/10/22
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="static/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- 16:9 aspect ratio -->
<div class="container-fluid" >
    <div class="row">
        <div class="col-md-12">
            <iframe class="embed-responsive-item " width="100%" align="top" scrolling="no" src="WEB-INF/views/common/top.jsp">
            </iframe>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <iframe class="embed-responsive-item " height="700" align="left" scrolling="no"
                    src="WEB-INF/views/common/left.jsp"></iframe>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <iframe class="embed-responsive-item " width="100%" height="200" align="bottom" scrolling="no"
                    src="WEB-INF/views/common/left.jsp"></iframe>
        </div>
    </div>
</div>

</body>
</html>
