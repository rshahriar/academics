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
</head>
<body>
<h3>Successfully added new service</h3>
<form:form action="indexView" method="get" commandName="model">
  <input type="submit" value="Return to Services List">
</form:form>
</body>
</html>
