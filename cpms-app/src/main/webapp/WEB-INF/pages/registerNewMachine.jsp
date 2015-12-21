<%--
  Created by IntelliJ IDEA.
  User: Rakib
  Date: 11/21/2015
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Register Machine Visualization Services</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
</head>

<script>
    function getCookie(cname) {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for(var i=0; i<ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0)==' ') c = c.substring(1);
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
    }

    $(function () {
/*
        var mailElem = document.getElementById("userEmail");
        mailElem.value = getCookie("cpmsUserEmail");

        var tokenElem = document.getElementById("userToken");
        tokenElem.value = getCookie("cpmsLoginToken");

        var machineIdElem = document.getElementById("machineId");
        machineIdElem.value = "${machineId}";
*/

        var $form = $('form');
        $form.submit(function(){
            $.post($(this).attr('action'), $(this).serialize(), function(response){
                // do something here on success
                alert("Machine Registration Successful");
                window.location.replace("${dashboardUrl}");
            });
            return false;
        });
    });
</script>
<body>

<div class="container">
    <div class="container">
        <h3 style="text-align: center">Register a Machine</h3>
        <form role="form" action="${registrationUrl}" method="post">
            <div class="form-group">
                <label for="machineModel">Machine model name</label>
                <input id="machineModel" name="machineModel" class="form-control" />
            </div>
            <div class="form-group">
                <label for="machineDescription">Machine Description</label>
                <input id="machineDescription" name="machineDescription" class="form-control" />
            </div>
            <div class="form-group">
                <label for="machineTags">Machine Tags (comma seperated)</label>
                <input id="machineTags" name="tags" class="form-control" />
            </div>
            <input type="submit" class="btn btn-default" value="Register">
        </form>
    </div>
</div>

</body>
</html>
