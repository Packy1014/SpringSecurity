<%--
  Created by IntelliJ IDEA.
  User: Jaeger
  Date: 2019/1/6
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h3>Packy Login Page</h3>
    <form action="${pageContext.request.contextPath}/securityLogin" method="post">
        UserName:<input type="text" name="username"/><br>
        Password:<input type="password" name="password"/><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
