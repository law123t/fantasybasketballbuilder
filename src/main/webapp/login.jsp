<%--
  Created by IntelliJ IDEA.
  User: Ren
  Date: 10/10/2017
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>

        form    {

            width: 800px;
            padding: 1em;
            border-radius: 10px;

        }
    </style>
</head>
<body>
    <FORM ACTION="j_security_check" METHOD="POST">
        <TABLE>
            <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
            <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
            <TR><TH><INPUT TYPE="SUBMIT" VALUE="logIn">
        </TABLE>
    </FORM>
</body>
</html>
