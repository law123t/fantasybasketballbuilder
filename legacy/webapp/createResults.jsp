<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ren
  Date: 3/22/2018
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Created Success!</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <style>
        #messagediv{
            padding: 70px;
            margin: 100px;
            width:75%;
            border: 5px solid black;
            background-color: palegoldenrod;
            text-align: center;
        }

        .row {
            padding: 50px;
            margin: 10px;
            width: 100%;
        }
    </style>
    <!-- Bootstrap core CSS -->
    <link href="../../src/main/webapp/basketballApp/content-jsp/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <!-- Custom styles for this template -->
    <link href="../../src/main/webapp/basketballApp/content-jsp/css/simple-sidebar.css" rel="stylesheet">
</head>
<body>
<!-- Sidebar -->
<div id="sidebar-wrapper">
    <ul class="sidebar-nav">
        <li class="sidebar-brand">
            <a href="#">
                Start Bootstrap
            </a>
        </li>
        <li>
            <a href="../../src/main/webapp/basketballApp/appIndex.jsp">Login tester 4</a>
        </li>
        <li>
            <a href="login">login servlet</a>
        </li>
        <li>
            <a href="createTeam">Create a Team</a>
        </li>
        <li>
            <a href="#">Events</a>
        </li>
        <li>
            <a href="#">About</a>
        </li>
        <li>
            <a href="#">Services</a>
        </li>
        <li>
            <a href="#">Contact</a>
        </li>
    </ul>
</div>
<!-- /#sidebar-wrapper -->
    <div class="container-fluid" id="messagediv">
        <div class="col-lg-12">
            <h1>Your Team Has Been Created!</h1>
        </div>
        <br />
        <div class="row">
            <div class="col-lg-4">
                <a href="../../src/main/webapp/basketballApp/appIndex.jsp" class="btn btn-secondary">Back To Homepage</a>
            </div>
            <div class="col-lg-4">
                <a href="/createTeam" class="btn btn-secondary">Back To Create-a-Team</a>
            </div>
        </div>
    </div>
<br/>
<br/>
<a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>

<!-- Bootstrap core JavaScript -->
<script src="../../src/main/webapp/basketballApp/content-jsp/vendor/jquery/jquery.min.js"></script>
<script src="../../src/main/webapp/basketballApp/content-jsp/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Menu Toggle Script -->
<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>
</body>
</html>
