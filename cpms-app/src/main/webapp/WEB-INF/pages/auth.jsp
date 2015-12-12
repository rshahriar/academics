<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rakib
  Date: 12/10/2015
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authenticating....</title>

    <script src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>

    <script>

        function setCookie(cname,cvalue,exdays) {
            var d = new Date();
            d.setTime(d.getTime() + (exdays*24*60*60*1000));
            var expires = "expires=" + d.toGMTString();
            document.cookie = cname+"="+cvalue+"; "+expires;
        }

        $(function () {
            setCookie("cpmsUserEmail", "${authenticatedUserBean.userEmail}", 30);
            setCookie("cpmsLoginToken", "${authenticatedUserBean.userToken}", 30);
            setCookie("cpmsUserRole", "${authenticatedUserBean.userRole}", 30);
            window.location.replace("${dashboardViewUrl}");
            console.log("redirecting to dashboard");
        });
    </script>
</head>
<body>

</body>
</html>
