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
            });
        }

        function bindTable(response) {
            $.each(response, function (i, item) {
                $('<tr>').append(
                        $('<td>').text(item.timeStamp),
                        $('<td>').text(item.bedTemperature),
                        $('<td>').text(item.nozzleTemperature),
                        $('<td>').append(item.progress)).appendTo('#t01');
            });
        }
    </script>
</head>
<body>
<div>
    <div style="width : 30%; float: left">
        <p>
            <input type="submit" value="Connect Device">
        </p>
    </div>
    <div style="width: 40%; float: left">
        <p>
            <b>Machine Connected</b>
        </p>
    </div>
    <div style="width: 30%; float: right">
        <p>
            <input type="submit" value="Disconnect Device">
        </p>
    </div>
</div>

<div align="left" style="width: 100%">
    <form method="POST" enctype="multipart/form-data" action="/print">
        Select Model File: <input type="file" name="file">
        <br />
        <br />
        <input type="submit" value="Print">
        <%--<input type="submit" value="Cancel">--%>
    </form>
</div>

<div>
    <button onclick="fetchMonitorData()">Fetch Monitoring Information</button>
</div>

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
