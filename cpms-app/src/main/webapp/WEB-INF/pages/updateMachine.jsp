<%--
  Created by IntelliJ IDEA.
  User: Rakib
  Date: 11/21/2015
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Machine Update</title>

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
</head>

<script type="text/javascript">
    function bindInfo(response) {
        $('#machineDetail').append($('<li>').attr('class', "list-group-item").text(response.machineModel));
        $('#machineDetail').append($('<li>').attr('class', "list-group-item").text(response.machineDescription));
        $('#machineDetail').append($('<li>').attr('class', "list-group-item").text(response.tags));

        var list = response.serviceBeanList;
        if (typeof list != 'undefined') {
            $.each(list, function (i, item) {
                $('<tr>').append(
                        $('<td>').text(item.serviceName),
                        $('<td>').text(item.serviceUrl)
                ).appendTo('#t01');
            });
        }
    }

    $(function () {
        var machineIdElem = document.getElementById("machineId");
        machineIdElem.value = "${machineId}";
        $.getJSON("${machineServicesUrl}", function(response){
            bindInfo(response);
        });

        var $form = $('form');
        $form.submit(function(){
            $.post($(this).attr('action'), $(this).serialize(), function(response){
                // do something here on success
                alert("Service Publish Successful");
                window.location.replace("${dashboardUrl}");
            });
            return false;
        });
    });

</script>
<body>

<div class="container">
    <h4>Machine Details and Published Services</h4>
    <ul id="machineDetail" class="list-group">
    </ul>

    <h4>Publish a Service</h4>
    <form role="form" action="${servicePublishUrl}" method="post">
        <div class="form-group">
            <input id="machineId" name="machineId" type="hidden" />
        </div>
        <div class="form-group">
            <label for="serviceName">Service name</label>
            <input id="serviceName" name="serviceName" class="form-control" />
        </div>
        <div class="form-group">
            <label for="serviceUrl">Machine Description</label>
            <input id="serviceUrl" name="serviceUrl" class="form-control" />
        </div>
        <input type="submit" class="btn btn-default" value="Publish">
    </form>

    <br/>
    <h4>Published Services</h4>

    <table id="t01">
        <tr>
            <th>Service Name</th>
            <th>Url</th>
        </tr>
    </table>

</div>
</body>
</html>
