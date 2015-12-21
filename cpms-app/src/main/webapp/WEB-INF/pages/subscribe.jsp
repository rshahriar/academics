<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

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
            var mailElem = document.getElementById("userEmail");
            mailElem.value = getCookie("cpmsUserEmail");

            var tokenElem = document.getElementById("userToken");
            tokenElem.value = getCookie("cpmsLoginToken");

            var machineIdElem = document.getElementById("machineId");
            machineIdElem.value = "${machineId}";

            var $form = $('form');
            $form.submit(function(){
                $.post($(this).attr('action'), $(this).serialize(), function(response){
                    // do something here on success
                    alert("Machine Subscription Successful");
                    window.location.replace("${subscriptionListViewUrl}");
                });
                return false;
            });
        });
    </script>
</head>

<body>

<div class="container">
    <h3 style="text-align: center">Subscribe Machine : ${machineId}</h3>
    <form role="form" action="${subscriptionUrl}" method="post">
        <div class="form-group">
            <input id="userEmail" name="userEmail" type="hidden" />
        </div>
        <div class="form-group">
            <input id="userToken" name="userToken" type="hidden" />
        </div>
        <div class="form-group">
            <input id="machineId" name="machineId" type="hidden" />
        </div>
        <div class="form-group">
            <label for="machineRemark">Subscription Note</label>
            <input name="remark" id="machineRemark" class="form-control" />
        </div>
        <input type="submit" class="btn btn-default" value="Subscribe">
    </form>
</div>
</body>
</html>
