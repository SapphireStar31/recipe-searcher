<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Karissa
  Date: 11/12/2024
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>All Ingredients - Recipe Searcher</title>
    </head>
    <body>
        <h1>All Ingredients</h1>
        <table>
            <tr>
                <th>Ingredient Name</th>
            </tr>
            <c:forEach var="ingredients" items="${ingredients}">
                <tr>
                    <td>${ingredients.ingredientName}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>