<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>
    <title>CPMS Dashboard</title>
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

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
        function bindTable(response) {
            var list = response.subscribedMachineList;
            $.each(list, function (i, item) {
                $('<tr>').append(
                        $('<td>').text(item.machineId),
                        $('<td>').text(item.remarks),
//                        $('<td>').text(item.machineDescription),
                        $('<td>').append(
                                $('<a>').attr('href', "<c:url value='/monitor/" + item.machineId + "' />")
                                        .attr('class', "btn btn-success custom-width").text("Visit Machine")
                        )).appendTo('#t01');
            });
        }

        $(function () {
            console.log(${userBean.email});
            $.getJSON("${servicesUrl}", function(result){
                bindTable(result);
            });
        });
    </script>
</head>

<body>
<div>
    <a href="${subscriptionViewUrl}">Subscribe a machine</a>
</div>
<br/><br/>
<h3>List of accessible Cyber Physical Manufacturing Machines</h3>

<table id="t01">
    <tr>
        <th>ID</th>
        <th>Machine Model</th>
        <%--<th>Description</th>--%>
        <th>Visit Machine</th>
    </tr>
</table>
</body>
</html>