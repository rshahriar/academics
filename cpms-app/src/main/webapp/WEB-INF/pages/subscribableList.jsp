<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rakib
  Date: 11/30/2015
  Time: 1:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subscribe a machine</title>

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

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

    <script>
        function bindTable(response) {
            $.each(response, function (i, item) {
                var subscriptionUrl = "${baseUrl}/subscription/" + item.machineId;
                $('<tr>').append(
                        $('<td>').text(item.machineId),
                        $('<td>').text(item.machineModel),
                        $('<td>').text(item.machineDescription),
                        $('<td>').append(
                                $('<a>').attr('href', subscriptionUrl)
                                        .attr('class', "btn btn-success custom-width").text("Subscribe")
                        )).appendTo('#t01');
            });
        }

        $(function () {
            $.getJSON("${machineListUrl}", function(result){
                bindTable(result);
            });
        });
    </script>
</head>

<body>

<div class="container">
    <h3>List of machines for published for subscription</h3>

    <table id="t01">
        <tr>
            <th>ID</th>
            <th>Machine Model</th>
            <th>Description</th>
            <th>Visit Machine</th>
        </tr>
    </table>
</div>
</body>
</html>
