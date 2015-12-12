<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Rakib
  Date: 11/30/2015
  Time: 2:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subscribe Machine</title>
</head>
<body>
<div align="center">
    <form:form action="" method="post" commandName="machineEntry">
        User Id:<br>
        <form:input path="userEmail" disabled="true"/>
        <br>
        Machine Id:<br>
        <form:input path="machineId" disabled="true"/>
        <br>
        Subscription Note:<br>
        <form:input path="remark" />
        <br><br>
        <input type="submit" value="Subscribe">
    </form:form>
</div>
</body>
</html>
