<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:import url="head.jsp"/>

    <body>
        <header>
            <c:import url="navigation.jsp"/>
            <c:import url="searchBar.jsp"/>
            <h1>All Recipes</h1>
        </header>

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