<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ren
  Date: 5/3/2018
  Time: 3:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="pageTitle" value="Sign Up!" scope="session" />
<c:set var="img" value="content-jsp/img/kobejumper.jpg" scope="session" />
<c:import url="content-jsp/head-launch.jsp" />

<body>
<div id="wrapper">
    <c:import url="content-jsp/nav-launch.jsp"/>
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="hero-section">
                <div class="hero-section-text">
                    <h1>Welcome to Fantasy Basketball Builder!</h1>
                    <h5>Sign Up Here!</h5>
                </div>
            </div>
        <div id="errormessage"><div><p>${errormessage}</p></div></div>
        <div class="container-fluid">
            <div class="col-lg-8">
            <form method="POST" action="signup">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" name="username" id="username" required/>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" name="password" id="password" required/>
                </div>
                    <label for="firstName">First Name:</label>
                    <input type="text" name="firstName" id="firstName" required/>
                <div class="form-group">
                    <label for="lastName">Last Name:</label>
                    <input type="text" name="lastName" id="lastName" required/>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" name="email" id="email" required/>
                </div>
                <div class="form-group">
                    <label for="admin">Enter Admin Key:</label>
                    <input type="text" name="admin" id="admin"/>
                </div>
                <div class="form-group">
                    <input type="submit" value="Sign Up">
                </div>
            </form>
            </div>
        </div>
        <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
    </div>
</div>
<c:import url="content-jsp/javascript.jsp" />
</body>
</html>
