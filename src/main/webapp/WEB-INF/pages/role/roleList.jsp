<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sovket
  Date: 9/17/2021
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="width: 100%" border="1">
    <thead>
    <tr>#</tr>
    <tr>Role name</tr>
    <tr>Description</tr>
    </thead>
    <tbody>
    <c:forEach items="${roleList}" var="rl">
        <td>${rl.id}</td>
        <td>${rl.role_name}</td>
        <td>${rl.description}</td>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
