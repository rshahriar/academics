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
    <title>Register Machine Visualization Services</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <form:form role="form" action="register" method="post" commandName="machineServices">
        <div class="form-group">
            <label for="machineModel">Machine model name</label>
            <form:input id="machineModel" class="form-control" path="machineModel" />
        </div>
        <div class="form-group">
            <label for="machineDescription">Machine Description</label>
            <form:input id="machineDescription" class="form-control" path="machineDescription" />
        </div>
        <div class="form-group">
            <label for="controlServiceUrl">Control Service URL</label>
            <form:input id="controlServiceUrl" class="form-control" path="controlServiceUrl" />
        </div>
        <div class="form-group">
            <label for="controlServiceDescription">Control Service Description</label>
            <form:input id="controlServiceDescription" class="form-control" path="controlServiceDescription" />
        </div>
        <div class="form-group">
            <label for="monitorServiceUrl">Monitor Service URL</label>
            <form:input id="monitorServiceUrl" class="form-control" path="monitorServiceUrl" />
        </div>
        <div class="form-group">
            <label for="monitorServiceDescription">Monitor Service Description</label>
            <form:input id="monitorServiceDescription" class="form-control" path="monitorServiceDescription" />
        </div>
        <input type="submit" class="btn btn-default" value="Publish">
    </form:form>
</div>

</body>
</html>
