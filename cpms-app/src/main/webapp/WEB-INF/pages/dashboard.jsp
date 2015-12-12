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

        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
        <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <script>
        function bindTable(response) {
            var list = response.subscribedMachineList;
            $.each(list, function (i, item) {
                $('<tr>').append(
                        $('<td>').text(item.machineId),
                        $('<td>').text(item.remarks),
                        $('<td>').append(
                                $('<a>').attr('href', "<c:url value='/monitor/" + item.machineId + "' />")
                                        .attr('class', "btn btn-success custom-width").text("Visit Machine")
                        )).appendTo('#t01');
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

        function setCookie(cname,cvalue,exdays) {
            var d = new Date();
            d.setTime(d.getTime() + (exdays*24*60*60*1000));
            var expires = "expires=" + d.toGMTString();
            document.cookie = cname+"="+cvalue+"; "+expires;
        }

        function logout() {
            setCookie("cpmsUserEmail", "", 30);
            setCookie("cpmsLoginToken", "", 30);
            setCookie("cpmsUserRole", "", 30);
            window.location.replace("${loginViewUrl}");
        }

        function checkAuthToken() {
            var userEmail=getCookie("cpmsUserEmail");
            var userToken=getCookie("cpmsLoginToken");
            var userRole=getCookie("cpmsUserRole");
            if (userEmail == "" || userToken == "" || userRole == "") {
                window.location.replace("${loginViewUrl}");
            }
        }

        function validateToken() {
            var userToken=getCookie("cpmsLoginToken");
            $.post("http://130.184.104.115:8084/cpms-subscription/validate",
                    {"token": userToken},
                    function(data, status){
                        alert("Data: " + data + "\nStatus: " + status);
                    });
        }

        $(function () {
            checkAuthToken();
            var userEmail=getCookie("cpmsUserEmail");
            $.getJSON("${machineListUrl}" + "?email=" + userEmail, function(result){
                bindTable(result);
            });
        });
    </script>
</head>

<body>
<br/>
<div>
    <button class="btn btn-danger custom-width" style="float: right" onclick="validateToken()">Check Token</button>
    <button class="btn btn-warning custom-width" style="float: right" onclick="logout()">Logout</button>
</div>
<br/>

<c:choose>
    <c:when test="${authenticatedUserBean.userRole=='1'}">
        <div>
            <a href="${registerMachineViewUrl}" class="btn btn-success custom-width">Publish a machine</a>
        </div>
    </c:when>
    <c:otherwise>
        <div>
            <a href="${subscriptionViewUrl}" class="btn btn-success custom-width">Subscribe a machine</a>
        </div>
    </c:otherwise>
</c:choose>

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