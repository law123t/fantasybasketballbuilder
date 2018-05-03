<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<c:set var="pageTitle" value="Fantasy Basketball Builder - Logged in" scope="session" />
<c:import url="content-jsp/head.jsp" />

<body>
<div id="wrapper">
    <c:import url="content-jsp/nav.jsp"/>
    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="hero-section">
                <div class="hero-section-text">
                    <h1>Welcome back </h1>
                    <h5>Get started on new teams or view previous teams</h5>
                </div>
            </div>
            <p>this application allows the lineups of your dreams! ${playlistID}<code>#page-content-wrapper</code>.</p>
        </div>
    </div>
    <div id="message" class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h2>${message}</h2>
            </div>
        </div>
    </div>
    <div class="flex-lg-wrap"style="float:right;margin:auto;">
        <div>
            <h2>Highlights around the League!</h2>
        </div>
        <div class="container"><div id="player"></div></div>
    </div>
    <a href="/#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
</div>
<c:import url="content-jsp/javascript.jsp" />
</body>

</html>