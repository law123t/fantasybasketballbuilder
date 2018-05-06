
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%--
  Created by IntelliJ IDEA.
  User: Ren
  Date: 5/2/2018
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<c:set var="pageTitle" value="My Info" scope="session" />
<c:import url="content-jsp/head.jsp" />
<body>
<div id="wrapper">
    <c:import url="content-jsp/nav.jsp" />
    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="hero-section">
                <div class="hero-section-text">
                    <h1>Your Team</h1>
                </div>
            </div>
            <div id="table" class="container-fluid" style="height:500px;">
                <table border="5px" class="col-lg12" style="margin:auto;width:80%;">
                    <th>User Name</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Number of Teams</th>
                    </tr>
                    <tr>
                        <td>${username}</td>
                        <td>${firstName}</td>
                        <td>${lastName}</td>
                        <td>${email}</td>
                        <td>${teams}</td>
                    </tr>
                </table>
                <table border="5px" class="col-lg-12" style="margin:auto;width:80%;">
                    <tr>
                    <tr><th class="col-lg-4">Total Points:</th>
                        <td class="col-lg-8">${teamPoints}</td></tr>
                    <tr>
                </table>
            </div>
            <div class="container-fluid">
                <form>
                    <select name="updatedata" id="updatedata">
                        <option value="username">Username</option>
                        <option value="firstname">First Name</option>
                        <option value="lastname">Last Name</option>
                        <option value="email">Email</option>
                    </select>
                    <input type="text" name="updatetext" id="updatetext" />
                </form>
            </div>
            <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
        </div>
    </div>
</div>
<c:import url="content-jsp/javascript.jsp" />
</body>
</html>
