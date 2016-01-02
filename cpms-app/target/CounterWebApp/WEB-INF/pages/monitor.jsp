<%--
  Created by IntelliJ IDEA.
  User: Rakib
  Date: 11/22/2015
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        table#t02 tr:nth-child(even) {
            background-color: #eee;
        }
        table#t02 tr:nth-child(odd) {
            background-color:#fff;
        }
        table#t02 th	{
            background-color: black;
            color: white;
        }
    </style>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">

    <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>

    <script>
        function fetchCharacteristicsData() {
            //call service for characteristics
            var userToken=getCookie("cpmsLoginToken");

            $.ajax({
                url: "${characteristicsServiceUrl}",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader('Authorization', userToken);
                },
                method: "GET",
                dataType: "json",
                success:function(result){
                    bindCharacteristicsTable(result);
                },
                error:function(result){
                    bindCharacteristicsTable(result);
                }
            });
        }

        function fetchStatusData() {
            //call service for status
            var userToken=getCookie("cpmsLoginToken");
            $.ajax({
                url: "${statusServiceUrl}",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader('Authorization', userToken);
                },
                method: "GET",
                success:function(result){
                    bindStatusImage(result);
                    setTimeout(fetchMonitorData, 60000);
                },
                error:function(result){
                    bindStatusImage(result);
                    setTimeout(fetchMonitorData, 60000);
                }
            });
        }

        function fetchMonitorData() {
            //call service for monitoring
            var userToken=getCookie("cpmsLoginToken");
            $.ajax({
                url: "${monitorServiceUrl}",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader('Authorization', userToken);
                },
                method: "GET",
                dataType: "json",
                success:function(result){
                    bindMonitorTable(result);
                    setTimeout(fetchMonitorData, 20000);
                },
                error:function(result){
                    bindMonitorTable(result);
                    setTimeout(fetchMonitorData, 20000);
                }
            });
        }

        function getCookie(cname) {
            var name = cname + "=";
            var ca = document.cookie.split(';');
            for(var i=0; i<ca.length; i++) {
                var c = ca[i];
                while (c.charAt(0)==' ') c = c.substring(1);
                if (c.indexOf(name) == 0) {
                    return c.substring(name.length, c.length);
                }
            }
            return "";
        }

        function bindCharacteristicsTable(response) {
            $('<tr>').append(
                    $('<td>').text("Machine Model Name"),
                    $('<td>').text(response.machineModelName))
                    .appendTo('#t02');
            $('<tr>').append(
                    $('<td>').text("Company"),
                    $('<td>').text(response.company))
                    .appendTo('#t02');
            $('<tr>').append(
                    $('<td>').text("Machine Type"),
                    $('<td>').text(response.machineType))
                    .appendTo('#t02');
            $('<tr>').append(
                    $('<td>').text("Material"),
                    $('<td>').text(response.material))
                    .appendTo('#t02');
            $('<tr>').append(
                    $('<td>').text("Maximum Width"),
                    $('<td>').text(response.maxWidth))
                    .appendTo('#t02');
            $('<tr>').append(
                    $('<td>').text("Maximum Depth"),
                    $('<td>').text(response.maxDepth))
                    .appendTo('#t02');
            $('<tr>').append(
                    $('<td>').text("Maximum Height"),
                    $('<td>').text(response.maxHeight))
                    .appendTo('#t02');
            $('<tr>').append(
                    $('<td>').text("Build Area Shape"),
                    $('<td>').text(response.buildAreaShape))
                    .appendTo('#t02');
            $('<tr>').append(
                    $('<td>').text("Connection Type"),
                    $('<td>').text(response.connectionType))
                    .appendTo('#t02');
        }

        function bindStatusImage(response) {
            var status = response;
            $('#freeBusy').text(status);
/*
            if (status == 'Available') {
                $('#freeBusy').text(status);
                <%--$('img1').attr('src', '<c:url value="/resources/images/Free.png" />');--%>
            } else {
                $('img1').attr('src', '<c:url value="/resources/images/Busy.png" />');
            }
*/
        }

        function bindMonitorTable(response) {
            $('tr#valueRow').replaceWith($('<tr id=\"valueRow\">').append(
                    $('<td>').text(response.timeStamp),
                    $('<td>').text(response.bedTemperature),
                    $('<td>').text(response.nozzleTemperature),
                    $('<td>').append("<div class=\"container\"><div class=\"progress\"><div class=\"progress-bar\" role=\"progressbar\" aria-valuenow=\"70\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:"
                            + response.progress
                            + "%\"><span class=\"sr-only\"></span></div></div></div>")));
        }

        $(function () {
            fetchCharacteristicsData();
            fetchStatusData();
            fetchMonitorData();
        });
    </script>
</head>
<body>

<div class="container">

    <h3>Machine Id: ${machineId}</h3>
    <h3>Machine Model: ${machineModel}</h3>

    <br/>

    <div>
        <br />
        <table id="t02">
            <tr>
                <th width="50%">Characteristics</th>
                <th width="50%">Data</th>
            </tr>
        </table>
    </div>
    <br/>

    <div>
        <table>
            <tr>
                <td width="50%">Machine Free Busy Information</td>
                <td id="freeBusy" width="50%">Available</td>
                <%--<img src="<c:url value="/resources/images/Free.png" />" id="img1">--%>
            </tr>
        </table>
    </div>

    <br />

    <div class="container" align="left" style="width: 100%">
        <form role="form" method="POST" enctype="multipart/form-data" action="${controlServiceUrl}">
            <%--<fieldset>--%>
            <legend>Control Panel:</legend>
            <div class="form-group">
                <label for="fileInput">Select Model File</label>
                <input id="fileInput" type="file" name="file">
            </div>
            <input type="submit" value="Print" class="btn btn-default">
            <%--</fieldset>--%>
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
            <tr id="valueRow">
                <td width="15%">-</td>
                <td width="15%">-</td>
                <td width="15%">-</td>
                <td>
                    <div class="container">
                        <div class="progress">
                            <div class="progress-bar" role="progressbar" aria-valuenow="00" aria-valuemin="0" aria-valuemax="100" style="width:10%">
                                <span class="sr-only"></span>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
