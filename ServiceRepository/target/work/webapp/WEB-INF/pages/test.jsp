<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Result from Database</h1>

<table style=" background-repeat:no-repeat; width:450px;margin:0;" cellpadding="0" cellspacing="0" border="1">
    <thead>
        <td>Id</td>
        <td>Name</td>
        <td>Person</td>
    </thead>
    <c:forEach var="person" items="${persons}" varStatus="status">
    <tr>
        <td>${person.id}</td>
        <td>${person.name}</td>
        <td>${person.country}</td>
    </tr>
    </c:forEach>
</table>

</body>
</html>