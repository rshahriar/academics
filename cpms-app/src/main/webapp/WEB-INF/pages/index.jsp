<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rakib
  Date: 12/10/2015
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CPMS Web Application</title>

    <script src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>

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
            var userEmail=getCookie("cpmsUserEmail");
            var userToken=getCookie("cpmsLoginToken");
            if (userEmail != "" && userToken != "") {
                window.location.replace("${dashboardViewUrl}");
            } else {
                window.location.replace("${loginViewUrl}");
            }
        });
    </script>
</head>
<body>

</body>
</html>
