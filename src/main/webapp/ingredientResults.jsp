<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:import url="head.jsp"/>

    <body>
        <header>
            <c:import url="navigation.jsp"/>
            <c:import url="searchBar.jsp"/>
            <h1>Search Results</h1>
        </header>

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

    <c:import url="footer.jsp"/>
</html>
