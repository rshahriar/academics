<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE html>
<html>
<head>
	<title>CPMSs Subscriber Login</title>
	<link href="<c:url value="/resources/css/normalize.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
	<section class="loginform cf">
        <form:form action="" method="post" commandName="userAuth">
            <ul>
                <li>
                    <label for="usermail">Email</label>
                    <form:input  path="user_email" type="email" name="usermail" placeholder="yourname@email.com" />
                </li>
                <li>
                    <label for="password">Password</label>
                    <form:input path="user_credential" type="password" name="password" placeholder="password" />
                </li>
                <li>
                    <input type="submit" value="Login">
                </li>
            </ul>
        </form:form>
    </section>
</body>
</html>