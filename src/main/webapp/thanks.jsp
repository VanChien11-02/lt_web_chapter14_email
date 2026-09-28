<%-- 
    Document   : thanks
    Created on : Sep 23, 2026, 11:07:46 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css?v=2" type="text/css"/>
</head>
    <body>
        <h1>Thank for your information</h1>
        <p>Have a good day</p>
        <p>Your info: <br>
            email: ${user.email} <br>
            first name: ${user.firstName} <br>
            last name: ${user.lastName}</p>

        <p style="color: red;">${errorMessage}</p>
    </body>
</html>
