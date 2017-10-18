<%-- 
    Document   : shoppingList
    Created on : Oct 11, 2017, 1:43:44 PM
    Author     : 686623
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="post">
            Hello, ${username} <a href="ShoppingList?action=logout">Logout</a>
            <h2>List</h2>
            Add item: <input type="text" name="item"> <input type="submit" name="action" value="add"><br>
            <c:forEach var="item" items="${list}" varStatus="status">
                <input type="radio" name="toDelete" value=${status.index}> ${item}<br>
            </c:forEach>
            <c:if test="${list.size() > 0}">
            <input type="submit" name="action" value="delete">
            </c:if>
            ${message}
        </form>
    </body>
</html>
