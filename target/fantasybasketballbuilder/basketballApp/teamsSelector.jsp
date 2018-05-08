<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ren
  Date: 5/3/2018
  Time: 7:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="pageTitle" value="Select a Team" scope="session" />
<c:import url="content-jsp/head.jsp" />
<body>
<div id="wrapper">
    <c:import url="content-jsp/nav.jsp" />
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="hero-section">
                <div class="hero-section-text">
                    <h1>Welcome to Fantasy Basketball Builder!</h1>
                    <h5>Our site provides the sandbox team builder of your dreams!</h5>
                </div>
            </div>
            <br />
            <br />
            <div class="container-fluid">
                <div class="col-lg-8">
                    <form method="GET" action="viewTeams">
                        <div class="form-group">
                            <label>Select Your Team</label>
                            <select name="team" id="team">
                                <c:forEach var="team" items="${team_data}">
                                    <option value="${team.teamID}">${team.teamName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="submit" value="View Team" id="teamselect">
                        </div>
                    </form>
                </div>
            </div>
        <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
        </div>
    </div>
</div>
<c:import url="content-jsp/javascript.jsp" />
</body>
</html>
