<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<c:set var="pageTitle" value="Create Team" scope="session" />
<c:import url="/content-jsp/head.jsp" />

<body>
<div id="wrapper">
    <c:import url="/content-jsp/nav.jsp" />
    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <form action= "createTeam" method="POST">

                <div class="form-group">
                    <label for="teamName">Team Name: </label>
                    <input type="text" class="form-control" id="teamName" name="teamName"/>
                </div>

                <div class="form-group">
                    <label for="pointGuard">Point Guard: </label>
                    <select class="form-control" id="pointGuard" name="pointGuard">
                        <option value="select">Select a Point Guard</option>
                        <c:forEach var="pgPlayer1" items="${pg_data}">
                            <option value="${pgPlayer1.pointGuardID}">${pgPlayer1.firstName} ${pgPlayer1.lastName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="shootingGuard">shootingGuard: </label>
                    <select class="form-control" id="shootingGuard" name="shootingGuard">
                        <option value="select">Select a Shooting Guard</option>
                        <c:forEach var="sgPlayer2" items="${sg_data}">
                            <option value="${sgPlayer2.shootingGuardID}">${sgPlayer2.firstName} ${sgPlayer2.lastName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="smallForward">Small Forward: </label>
                    <select class="form-control" id="smallForward" name="smallForward">
                        <option value="select">Select a Small Forward</option>
                        <c:forEach var="sfPlayer3" items="${sf_data}">
                            <option value="${sfPlayer3.smallForwardID}">${sfPlayer3.firstName} ${sfPlayer3.lastName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="powerForward">Power Forward: </label>
                    <select class="form-control" id="powerForward" name="powerForward">
                        <option value="select">Select a Power Forward</option>
                        <c:forEach var="pfPlayer4" items="${pf_data}">
                            <option value="${pfPlayer4.powerForwardID}">${pfPlayer4.firstName} ${pfPlayer4.lastName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="center">Center: </label>
                    <select class="form-control" id="center" name="center">
                        <option value="select">Select a Center</option>
                        <c:forEach var="cPlayer5" items="${c_data}">
                            <option value="${cPlayer5.centerID}">${cPlayer5.firstName} ${cPlayer5.lastName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div>
                    <button type="submit" class="btn btn-success" name="submit" id="submit" value="submit">Create Team</button>
                </div>
            </form>
        </div>
    </div>
    <!-- /#page-content-wrapper -->
    <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
</div>
<!-- /#wrapper -->
<c:import url="/content-jsp/javascript.jsp" />
</body>

</html>