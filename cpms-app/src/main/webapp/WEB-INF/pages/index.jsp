<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>
    <title>CPMS</title>
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

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
        function bindTable(response) {
            $.each(response, function (i, item) {
                $('<tr>').append(
                        $('<td>').text(item.machineId),
                        $('<td>').text(item.machineModel),
                        $('<td>').text(item.machineDescription),
                        $('<td>').append(
                                $('<a>').attr('href', "<c:url value='/monitor/" + item.machineId + "' />")
                                        .attr('class', "btn btn-success custom-width").text("Monitor")
                        )).appendTo('#t01');
            });
        }

        $(function () {
            $.getJSON("${servicesUrl}", function(result){
                bindTable(result);
            });
        });
    </script>
</head>

<body>
<h3>Your Cyber Physical Manufacturing Machines</h3>

<table id="t01">
    <tr>
        <th>ID</th>
        <th>Machine Model</th>
        <th>Description</th>
        <th>Visit</th>
    </tr>
</table>
</body>
</html>