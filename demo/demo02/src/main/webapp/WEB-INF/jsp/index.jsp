<%--
  Created by IntelliJ IDEA.
  User: Jaeger
  Date: 2019/1/5
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>Index</title>
</head>
<body>
    Welcome, ${userName}<br>
    <security:authorize access="hasAuthority('ROLE_ADD_PRODUCT')">
        <a href="${pageContext.request.contextPath}/product/add">Add Product</a><br>
    </security:authorize>
    <security:authorize access="hasAuthority('ROLE_UPDATE_PRODUCT')">
        <a href="${pageContext.request.contextPath}/product/update">Update Product</a><br>
    </security:authorize>
    <security:authorize access="hasAuthority('ROLE_LIST_PRODUCT')">
        <a href="${pageContext.request.contextPath}/product/list">List Product</a><br>
    </security:authorize>
    <security:authorize access="hasAuthority('ROLE_DELETE_PRODUCT')">
        <a href="${pageContext.request.contextPath}/product/delete">Delete Product</a>
    </security:authorize>
</body>
</html>
