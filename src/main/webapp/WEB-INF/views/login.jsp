<%--
  User: Ross
  Date: 2019/10/22
  Time: 14:04
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="common/js.jsp"></jsp:include>
</head>
<body>

<body class="text-center">
<form class="form-signin">
    <img class="mb-4" src="statis/img/i03.png" alt="" width="72" height="72">
<%-- <img class="mb-4" src="../../static/img/bootstrap-solid.svg" alt="" width="72" height="72">--%>
<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
<label for="inputEmail" class="sr-only">Email address</label>
<input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">
<label for="inputPassword" class="sr-only">Password</label>
<input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
<div class="checkbox mb-3">
    <label>
        <input type="checkbox" value="remember-me"> Remember me
    </label>
</div>
<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
<p class="mt-5 mb-3 text-muted">© 2017-2019</p>
</form>
</body>
</body>
</html>