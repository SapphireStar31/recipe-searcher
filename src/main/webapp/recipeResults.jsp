<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Karissa
  Date: 10/27/2024
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
    <head>
        <title>Recipe Results - Recipe Searcher</title>
    </head>
    <body>
        <h1>Search Results</h1>
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