<%--
  Created by IntelliJ IDEA.
  User: Rakib
  Date: 11/22/2015
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Monitor and Control</title>

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
        function fetchMonitorData() {
            //call service for monitoring
            $.getJSON("${monitorServiceUrl}", function(result){
                bindTable(result);
                setTimeout(fetchMonitorData, 10000);
            });
        }

        function bindTable(response) {
                $('<tr>').append(
                        $('<td>').text(response.timeStamp),
                        $('<td>').text(response.bedTemperature),
                        $('<td>').text(response.nozzleTemperature),
                        $('<td>').append(response.progress)).appendTo('#t01');
        }

        $(function () {
            fetchMonitorData();
        });
    </script>
</head>
<body>

<div align="left" style="width: 100%">
    <form method="POST" enctype="multipart/form-data" action="${printServiceUrl}">
        Select Model File: <input type="file" name="file">
        <%--<br />--%>
        <%--<br />--%>
        <input type="submit" value="Print">
    </form>
</div>

<%--<div>--%>
    <%--<button onclick="fetchMonitorData()">Fetch Monitoring Information</button>--%>
<%--</div>--%>

<div>
    <br />
    <table id="t01">
        <tr>
            <th>Time</th>
            <th>Bed Temperature</th>
            <th>Nozzle Temperature</th>
            <th>Progress</th>
        </tr>
    </table>
</div>

</body>
</html>
