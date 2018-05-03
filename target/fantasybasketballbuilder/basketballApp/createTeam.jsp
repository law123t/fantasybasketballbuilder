<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<c:set var="pageTitle" value="Create Team" scope="session" />
<c:import url="content-jsp/head-createteam.jsp" />

<body>
<div id="wrapper">
    <c:import url="content-jsp/nav.jsp" />
    <!-- Page Content -->
    <div class="hero-section">
        <div class="hero-section-text">
            <h1>Create Your Team!</h1>
        </div>
    </div>
    <div id="page-content-wrapper" style="width:90%;margin:auto;background-color:white">
        <div class="container-fluid">
        <h1 id="successtext"></h1>
        </div>
        <br/>
        <div>
            <h3>Team Name: </h3>
            <input type="text" class="form-control" id="teamName" name="teamName"/>
        </div>
        <br/>
            <div id="tmpl-view-builder-container">
                <h3 id="pgUpdater">Chosen Point Guard:</h3>
                <div id="tmpl-view-preview-container">
                    <div class="droppable" id="pgdata">
                    </div>
                </div>

                <div id="tmpl-view-legend-container">
                    <h3>Point Guards:</h3>
                    <div id="tmpl-view-legend-item-container">
                        <ul>
                            <c:forEach var="pgPlayer1" items="${pg_data}">
                                <li id="${pgPlayer1.pointGuardID}" value="${pgPlayer1.firstName} ${pgPlayer1.lastName}">${pgPlayer1.firstName} ${pgPlayer1.lastName}</li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>

            <div id="tmpl-view-builder-container2">
                <h3 id="sgUpdater">Chosen Shooting Guard:</h3>
                <div id="tmpl-view-preview-container2">
                    <div class="droppable" id="sgdata">
                    </div>
                </div>

                <div id="tmpl-view-legend-container2">
                    <h3>Shooting Guards:</h3>
                    <div id="tmpl-view-legend-item-container2">
                        <ul>
                            <c:forEach var="sgPlayer2" items="${sg_data}">
                                <li id="${sgPlayer2.shootingGuardID}" value="${sgPlayer2.firstName} ${sgPlayer2.lastName}">${sgPlayer2.firstName} ${sgPlayer2.lastName}</li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>

            <div id="tmpl-view-builder-container3">
                <h3 id="sfUpdater">Chosen Small Forward:</h3>
                <div id="tmpl-view-preview-container3">
                    <div class="droppable" id="sfdata">
                    </div>
                </div>

                <div id="tmpl-view-legend-container3">
                    <h3>Small Forwards:</h3>
                    <div id="tmpl-view-legend-item-container3">
                        <ul>
                            <c:forEach var="sfPlayer3" items="${sf_data}">
                                <li id="${sfPlayer3.smallForwardID}" value="${sfPlayer3.firstName} ${sfPlayer3.lastName}">${sfPlayer3.firstName} ${sfPlayer3.lastName}</li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>

            <div id="tmpl-view-builder-container4">
                <h3 id="pfUpdater">Chosen Power Forward:</h3>
                <div id="tmpl-view-preview-container4">
                    <div class="droppable" id="pfdata">
                    </div>
                </div>

                <div id="tmpl-view-legend-container4">
                    <h3>Power Forwards:</h3>
                    <div id="tmpl-view-legend-item-container4">
                        <ul>
                            <c:forEach var="pfPlayer4" items="${pf_data}">
                                <li id="${pfPlayer4.powerForwardID}" value="${pfPlayer4.firstName} ${pfPlayer4.lastName}">${pfPlayer4.firstName} ${pfPlayer4.lastName}</li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>

            <div id="tmpl-view-builder-container5">
                <h3 id="cUpdater">Chosen Center:</h3>
                <div id="tmpl-view-preview-container5">
                    <div class="droppable" id="cdata">
                    </div>
                </div>

                <div id="tmpl-view-legend-container5">
                    <h3>Centers:</h3>
                    <div id="tmpl-view-legend-item-container5">
                        <ul>
                            <c:forEach var="cPlayer5" items="${c_data}">
                                <li id="${cPlayer5.centerID}" value="${cPlayer5.firstName} ${cPlayer5.lastName}">${cPlayer5.firstName} ${cPlayer5.lastName}</li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    <div class="container-fluid">
        <div class="container-fluid" id="yourteam">
            <h2>Your Current Team:</h2>
            <div class="row">
                <div class="col-sm-4">
                    <h4>Point Guard:</h4>
                </div>
                <div class="col-sm-7">
                    <h4 id="currentPG"></h4>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <h4>Shooting Guard:</h4>
                </div>
                <div class="col-sm-7">
                    <h4 id="currentSG"></h4>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <h4>Small Forward:</h4>
                </div>
                <div class="col-sm-4">
                    <h4 id="currentSF"></h4>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <h4>Power Forward:</h4>
                </div>
                <div class="col-sm-7">
                    <h4 id="currentPF"></h4>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <h4>Center:</h4>
                </div>
                <div class="col-sm-7">
                    <h4 id="currentC"></h4>
                </div>
            </div>
        </div>
        <br/>
        <div><input type="button" value="Add My Team" id="submitteam"/></div>
    </div>

    <!-- /#page-content-wrapper -->
    <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle" style="float: right;margin:15px;">Toggle Menu</a>
</div>

<c:import url="content-jsp/javascript-createteam.jsp" />
</body>

</html>