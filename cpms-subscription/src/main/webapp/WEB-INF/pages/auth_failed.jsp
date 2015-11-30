<%--
  Created by IntelliJ IDEA.
  User: Rakib
  Date: 11/29/2015
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentication Error</title>
</head>
<body>
<h3>Authentication error occurred, please check your user name/password</h3>
<a href="${retryUrl}">Try Again</a>
</body>
</html>
