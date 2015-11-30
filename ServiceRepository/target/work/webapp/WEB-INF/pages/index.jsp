<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>CPMS Service Repository</title>
    <link href="<c:url value='css/bootstrap.css' />" rel="stylesheet"/>
    <style>
        table {
            width:100%;
        }
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
            text-align: left;
        }
        table#t01 tr:nth-child(even) {
            background-color: #eee;
        }
        table#t01 tr:nth-child(odd) {
            background-color:#fff;
        }
        table#t01 th	{
            background-color: black;
            color: white;
        }
    </style>
</head>
<body>
<div style="width : 50%; float: left;">
    <p><b>List of Services</b></p>
</div>
<div style="float: right">
    <p>
        <form:form action="register" method="get" commandName="model">
        <input type="submit" value="Add New Service">
        </form:form>
</div>

<table id="t01">
    <tr>
        <th>ID</th>
        <th>Machine Model</th>
        <th>Description</th>
        <th>Control URL</th>
        <th>URL Specification</th>
        <th>Monitor URL</th>
        <th>URL Specification</th>
        <th>Edit</th>
    </tr>
    <c:forEach var="machineServices" items="${machineServicesList}" varStatus="status">
        <tr>
            <td>${machineServices.machineId}</td>
            <td>${machineServices.machineModel}</td>
            <td>${machineServices.machineDescription}</td>
            <td>${machineServices.controlServiceUrl}</td>
            <td>${machineServices.controlServiceDescription}</td>
            <td>${machineServices.monitorServiceUrl}</td>
            <td>${machineServices.monitorServiceDescription}</td>
            <td>
                <a href="<c:url value='/edit/${machineServices.machineId}' />" class="btn btn-success custom-width">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>