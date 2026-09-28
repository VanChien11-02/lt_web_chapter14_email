<%-- 
    Document   : index
    Created on : Sep 23, 2026, 9:33:01 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css?v=2" type="text/css"/>
</head>
<body>
    <h1>Join our email list</h1>
    <p>To join our email list, enter your name and email address below.</p>
    <p><i>${message}</i></p>
    <form action="emailList" method="post">
        <label class="pad_top">Email:</label>
        <input type="email" name="email" value="${user.email}" 
               required><br>
        
        <label class="pad_top">First Name:</label>
        <input type="text" name="firstName" value="${user.firstName}" 
               required><br>

        <label class="pad_top">Last Name:</label>
        <input type="text" name="lastName" value="${user.lastName}"  
               required><br>        

        <label>&nbsp;</label>
        <button type="submit" name="action" value="add" class="margin_left"> Join now</button>
        
        <button type="submit" name="action" value="search" formnovalidate>Search</button>
        
        <button type="submit" name="action" value="update">Update</button>
        
        <button type="submit" name="action" value="delete" formnovalidate>Delete</button>
        
    </form>
</body>
</html>
