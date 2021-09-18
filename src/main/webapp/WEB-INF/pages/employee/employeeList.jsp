<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sovket
  Date: 9/17/2021
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>#</tr>
    <tr>Name</tr>
    <tr>Surname</tr>
    <tr>Father name</tr>
    <tr>Date of birth</tr>
    <tr>Note</tr>
    <tr>Organization</tr>
    <tr>Sector</tr>
    <tr>Position</tr>
    </thead>
    <tbody>
    <c:forEach  items="${employeeList}" var="el">
        <td>${el.id}</td>
        <td>${el.name}</td>
        <td>${el.surname}</td>
        <td>${el.father_name}</td>
        <td>${el.dob}</td>
        <td>${el.note}</td>
        <td>${el.osp.organization.org_name}</td>
        <td>${el.osp.sector.sector_name}</td>
        <td>${el.osp.position.position_name}</td>
        <td></td>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
