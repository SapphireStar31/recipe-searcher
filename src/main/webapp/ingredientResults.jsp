<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Karissa
  Date: 10/27/2024
  Time: 5:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Ingredient Results - Recipe Searcher</title>
    </head>
    <body>
        <h1>Search Results</h1>
        <table>
            <tr>
                <th>Ingredient Name</th>
                <th>Recipe Name</th>
            </tr>
            <c:forEach var="ingredients" items="${ingredients}">
                <tr>
                    <td>${ingredients.ingredientName}</td>
                    <td>
                        <ul>
                            <c:forEach var="recipes" items="${ingredients.recipes}">
                                <li>${recipes.recipeName}</li>
                            </c:forEach>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
