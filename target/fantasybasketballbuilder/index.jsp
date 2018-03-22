<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<c:set var="pageTitle" value="Fantasy Basketball Builder" scope="session" />
<c:import url="/content-jsp/head.jsp" />

<body>
<div id="wrapper">
    <c:import url="/content-jsp/nav.jsp" />
    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <h1>Fantasy Basketball Builder</h1>
            <p>dummy text for index</p>
            <p>this application allows the lineups of your dreams! <code>#page-content-wrapper</code>.</p>
            <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
        </div>
    </div>
    <!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->
<c:import url="/content-jsp/javascript.jsp" />
</body>

</html>