<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<c:set var="pageTitle" value="Fantasy Basketball Builder" scope="session" />
<c:set var="img" value="content-jsp/img/kobejumper.jpg" scope="session" />
<c:import url="content-jsp/head-launch.jsp" />
<body>
<div id="wrapper">
    <c:import url="content-jsp/nav-launch.jsp" />
    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="hero-section">
                <div class="hero-section-text">
                    <h1>Welcome to Fantasy Basketball Builder!</h1>
                    <h5>Our site provides the sandbox team builder of your dreams!</h5>
                </div>
            </div>
            <div id="errormessage" class="container-fluid" style="margin:40px;color:red;"><h1>${errormessage}</h1></div>

            <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
        </div>
    </div>
</div>
<c:import url="content-jsp/javascript.jsp" />
</body>
</html>