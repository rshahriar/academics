<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<html>
<head>
    <title>CPMSs Subscriber Login</title>
    <link href="<c:url value="/resources/css/normalize.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-2.1.4.js" />"></script>
</head>
<body>
<section class="loginform cf">
    <form:form action="" method="post" commandName="basicAuthenticationBean">
        <ul>
            <li>
                <label for="usermail">Email</label>
                <form:input  path="userEmail" type="email" name="usermail" placeholder="yourname@email.com" />
            </li>
            <li>
                <label for="password">Password</label>
                <form:input path="password" type="password" name="password" placeholder="password" />
            </li>
            <li>
                <input type="submit" value="Login">
            </li>
        </ul>
    </form:form>
</section>
</body>
</html>