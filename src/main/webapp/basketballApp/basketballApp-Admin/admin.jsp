<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ren
  Date: 5/6/2018
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="pageTitle" value="Welcome Admin" scope="session" />
<c:import url="content-jsp/head.jsp" />

<body>
    <div class="wrapper">
        <div class="page-content-wrapper">
            <div class="container-fluid">
                <div class="container-fluid">
                    <div><h1>Welcome to Admin Tools</h1></div>
                    <div id="messageadmin" class="container-fluid">
                        <div class="row">
                            <div class="col-lg-12">
                                <h2>${message_admin}</h2>
                            </div>
                        </div>
                    </div>
                    <div id="admintools">
                        <ul style="font-size:2em;">
                            <li><a href="deleteuser">Delete A User</a></li>
                            <li><a href="#">Next Patch</a></li>
                            <li><a href="#">Next Patch</a></li>
                            <li><a href="#">Next Patch</a></li>
                        </ul>
                    </div>
                    <div class="back"><a href="appIndex.jsp" style="font-size:2em;text-align:center;">Back to Index</a></div>
                </div>
            </div>
        </div>
    </div>
    <c:import url="content-jsp/javascript.jsp" />
</body>
</html>
