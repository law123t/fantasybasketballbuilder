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
<c:set var="pageTitle" value="Delete a User" scope="session" />
<c:import url="content-jsp/head.jsp" />
<body>
<div id="wrapper">
    <div id="page-content-wrapper">
        <div class="container-fluid">
                    <form method="POST" action="deleteAdmin">
                        <div class="form-group">
                            <label>Admin To Delete</label>
                            <select name="passadmin" id="passadmin">
                                <option value="${adminvalue.getUserId()}">${adminvalue.getUserName()}</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Please Enter Admin's Password</label>
                            <input type="text" name="checkpass" id="checkpass" />
                        </div>
                        <div class="form-group">
                            <input type="submit" value="Delete User">
                        </div>
                    </form>

        </div>
    </div>
</div>
<c:import url="content-jsp/javascript.jsp" />
</body>
</html>
