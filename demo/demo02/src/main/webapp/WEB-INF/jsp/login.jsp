<%--
  Created by IntelliJ IDEA.
  User: Jaeger
  Date: 2019/1/6
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Packy Login Page</h3>
<c:if test="${not empty param.error}">
    <font color="red">User name or password wrong</font>
</c:if>
<%--同步登陆--%>
<%--<form action="${pageContext.request.contextPath}/securityLogin" method="post">--%>
<%--My UserName:<input type="text" name="username"/><br>--%>
<%--My Password:<input type="password" name="password"/><br>--%>
<%--<input type="submit" value="Submit">--%>
<%--</form>--%>
<%--异步登陆--%>
<form id="loginForm" method="post">
    My UserName:<input type="text" name="username"/><br>
    My Password:<input type="password" name="password"/><br>
    Code:<input type="text" name="imageCode"/><img src="${pageContext.request.contextPath}/imageCode"><br>
    Remember Me:<input type="checkbox" name="remember-me" value="true">
    <input id="loginBtn" type="button" value="Submit">
</form>
<script type="text/javascript">
    $(function () {
        $("#loginBtn").click(function () {
            $.post(
                "${pageContext.request.contextPath}/securityLogin",
                $("#loginForm").serialize(),
                function (data) {
                    if (data.success) {
                        window.location.href = "${pageContext.request.contextPath}/product/index";
                    } else {
                        alert(data.errorMsg);
                    }
                },
                "json"
            );
        })
    })
</script>
</body>
</html>
