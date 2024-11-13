<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Karissa
  Date: 11/12/2024
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
    <head>
        <title>All Recipes - Recipe Searcher</title>
    </head>

    <body>
        <h1>All Recipes</h1>
        <table>
            <tr>
                <th>Recipe Name</th>
            </tr>
            <c:forEach var="recipes" items="${recipes}">
                <tr>
                    <td>${recipes.recipeName}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>