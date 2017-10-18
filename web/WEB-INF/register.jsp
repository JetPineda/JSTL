<%-- 
    Document   : register
    Created on : Oct 11, 2017, 1:43:23 PM
    Author     : 686623
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="post">
            Username:<input type="text" name="username"><input type="submit" name="action" value="register"><br>
            ${message}
        </form>
    </body>
</html>
