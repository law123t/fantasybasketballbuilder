
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
                    <h1>Your Profile - View and Update</h1>
                </div>
            </div>
            <div id="message" class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h2>${message_update}</h2>
                    </div>
                </div>
            </div>
            <br/>
            <h2>User Data:</h2>
            <div id="table" class="container-fluid" style="height:500px;">
                <table border="5px" class="col-lg12" style="margin:auto;width:80%;">
                    <th>User Name</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Number of Teams</th>
                    </tr>
                    <tr>
                        <td>${user.getUserName()}</td>
                        <td>${user.getFirstName()}</td>
                        <td>${user.getLastName()}</td>
                        <td>${user.getEmail()}</td>
                        <td>${userTeamsNumber}</td>
                    </tr>
                </table>
                <br />
                <br />
                <h2>Teams Data:</h2>
                <table border="5px" class="col-lg12" style="margin:auto;width:80%;">
                        <th>Team Name</th>
                        <th>Point Guard</th>
                        <th>Shooting Guard</th>
                        <th>Small Forward</th>
                        <th>Power Forward</th>
                        <th>Center</th>
                        </tr>
                    <c:forEach var="teams" items="${userTeams}">
                        <tr>
                            <td>${teams.getTeamName()}</td>
                            <td>${teams.getPointGuard().getFirstName()} ${teams.getPointGuard().getLastName()}</td>
                            <td>${teams.getShootingGuard().getFirstName()} ${teams.getShootingGuard().getLastName()}</td>
                            <td>${teams.getSmallForward().getFirstName()} ${teams.getSmallForward().getLastName()}</td>
                            <td>${teams.getPowerForward().getFirstName()} ${teams.getPowerForward().getLastName()}</td>
                            <td>${teams.getCenter().getFirstName()} ${teams.getCenter().getLastName()}</td>
                        </tr>
                    </c:forEach>
                    </table>
                <br/>
                <br/>
                <div>
                <form action="deleteTeam" method="POST">
                    <table>
                        <tr>
                            <td>
                                <select name="deleteteam" id="deleteteam">
                                    <c:forEach var="teams" items="${userTeams}">
                                    <option value="${teams.getTeamID()}">${teams.getTeamName()}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td><input type="submit" id="submitteamdelete" value="Delete This Team" /></td>
                        </tr>
                    </table>
                </form>
                </div>
                <br/>
                <br/>
                <div class="container-fluid" id="update">
                    <form id="updateUser" action="updateUser" method="POST">
                        <div class="form-group">
                            <label for="updatedata">Update User Field:</label>
                            <select name="updatedata" id="updatedata">
                                <option value="firstname">First Name</option>
                                <option value="lastname">Last Name</option>
                                <option value="email">Email</option>
                                <option value="password">Password</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="updatevalue">Update To:</label>
                            <input type="text" name="updatevalue" id="updatevalue" />
                        </div>
                        <div class="form-group">
                            <label for="checkpassword">Enter Password(Only if selected password)</label>
                            <input type="password" name="checkpassword" id="checkpassword" />
                        </div>
                        <div class="form-group">
                            <input type="submit" value="Update User">
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
