<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>CPMS Service Repository</title>
    <script type="text/javascript" src="scripts/jquery-2.1.4.js"></script>
    <script type="text/javascript">
        function doAjax(mId) {
            $.ajax({
                url: 'details',
                data: ({machineId : mId}),
                success: function(data) {
                    $('#time').html(data);
                }
            });
        }
    </script>

    <style>
        table {
            width:100%;
        }
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
            text-align: left;
        }
        table#t01 tr:nth-child(even) {
            background-color: #eee;
        }
        table#t01 tr:nth-child(odd) {
            background-color:#fff;
        }
        table#t01 th	{
            background-color: black;
            color: white;
        }
    </style>
</head>
<body>
<div style="width : 50%; float: left;">
    <p>List of Services</p>
</div>
<div style="float: right">
    <p><button value="Add New Service">Add New Service</button></p>
</div>

<table id="t01">
    <tr>
        <th>ID</th>
        <th>Machine Model</th>
        <th>Description</th>
        <th>Control URL</th>
        <th>URL Specification</th>
        <th>Monitor URL</th>
        <th>URL Specification</th>
        <th>Edit</th>
    </tr>
    <c:forEach var="machineServices" items="${machineServicesList}" varStatus="status">
        <tr>
            <td>${machineServices.machineId}</td>
            <td>${machineServices.machineModel}</td>
            <td>${machineServices.machineDescription}</td>
            <td>${machineServices.controlServiceUrl}</td>
            <td>${machineServices.controlServiceDescription}</td>
            <td>${machineServices.monitorServiceUrl}</td>
            <td>${machineServices.monitorServiceDescription}</td>
            <td><button name="update" value="Edit Services">Edit</button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>