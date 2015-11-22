<%--
  Created by IntelliJ IDEA.
  User: Rakib
  Date: 11/21/2015
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Add/Update CPMS Services</title>
</head>
<body>

<div align="center">
    <form:form action="register" method="post" commandName="machineServices">
        Machine model name:<br>
        <form:input path="machineModel" />
        <br>
        Machine Description:<br>
        <form:input path="machineDescription" />
        <br>
        Control Service URL:<br>
        <form:input path="controlServiceUrl" />
        <br>
        Control Service Description:<br>
        <form:input path="controlServiceDescription" />
        <br>
        Monitor Service URL:<br>
        <form:input path="monitorServiceUrl" />
        <br>
        Monitor Service Description:<br>
        <form:input path="monitorServiceDescription" />
        <br><br>
        <input type="submit" value="Register">
    </form:form>
</div>
</body>
</html>
