
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
<c:set var="pageTitle" value="My Team" scope="session" />
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
                <table border="5px" class="col-lg-12" style="margin:auto;width:80%;">
                    <tr>
                        <th class="col-lg-4">Your Team:</th>
                        <td class="col-lg-8">${teamName}</td></tr>
                    <tr>
                </table>
                <table border="5px" class="col-lg12" style="margin:auto;width:80%;">
                        <th>Position</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Points</th>
                        <th>Assists</th>
                        <th>Rebounds</th>
                        <th>Steals</th>
                        <th>Blocks</th>
                        <th>Turnovers</th>
                        <th>Total Fantasy</th>
                    </tr>
                    <tr>
                        <td>Point Guard</td>
                        <td>${pgFirstName}</td>
                        <td>${pgLastName}</td>
                        <td>${pgPoints}</td>
                        <td>${pgAssists}</td>
                        <td>${pgRebounds}</td>
                        <td>${pgSteals}</td>
                        <td>${pgBlocks}</td>
                        <td>${pgTurnovers}</td>
                        <td>${pgTotal}</td>
                    </tr>
                    <tr>
                        <td>Shooting Guard</td>
                        <td>${sgFirstName}</td>
                        <td>${sgLastName}</td>
                        <td>${sgPoints}</td>
                        <td>${sgAssists}</td>
                        <td>${sgRebounds}</td>
                        <td>${sgSteals}</td>
                        <td>${sgBlocks}</td>
                        <td>${sgTurnovers}</td>
                        <td>${sgTotal}</td>
                    </tr>

                    <tr>
                        <td>Power Forward</td>
                        <td>${pfFirstName}</td>
                        <td>${pfLastName}</td>
                        <td>${pfPoints}</td>
                        <td>${pfAssists}</td>
                        <td>${pfRebounds}</td>
                        <td>${pfSteals}</td>
                        <td>${pfBlocks}</td>
                        <td>${pfTurnovers}</td>
                        <td>${pfTotal}</td>
                    </tr>
                    <tr>
                        <td>Small Forward</td>
                        <td>${sfFirstName}</td>
                        <td>${sfLastName}</td>
                        <td>${sfPoints}</td>
                        <td>${sfAssists}</td>
                        <td>${sfRebounds}</td>
                        <td>${sfSteals}</td>
                        <td>${sfBlocks}</td>
                        <td>${sfTurnovers}</td>
                        <td>${sfTotal}</td>
                    </tr>
                    <tr>
                        <td>Center</td>
                        <td>${cFirstName}</td>
                        <td>${cLastName}</td>
                        <td>${cPoints}</td>
                        <td>${cAssists}</td>
                        <td>${cRebounds}</td>
                        <td>${cSteals}</td>
                        <td>${cBlocks}</td>
                        <td>${cTurnovers}</td>
                        <td>${cTotal}</td>
                    </tr>
                </table>
                <table border="5px" class="col-lg-12" style="margin:auto;width:80%;">
                    <tr>
                    <tr><th class="col-lg-4">Total Points:</th>
                    <td class="col-lg-8">${teamPoints}</td></tr>
                    <tr>
                </table>
            </div>
            <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
        </div>
    </div>
</div>
<c:import url="content-jsp/javascript.jsp" />
</body>
</html>
