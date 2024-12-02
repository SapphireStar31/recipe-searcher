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

        <table class="table table-striped table-hover">
            <tr>
                <th scope="col">Recipe Name</th>
                <th scope="col">Ingredients</th>
            </tr>
            <c:forEach var="recipes" items="${recipes}">
                <tr>
                    <td>${recipes.recipeName}</td>
                    <td>
                        <ul>
                            <c:forEach var="ingredients" items="${recipes.ingredients}">
                                <li>${ingredients.ingredientName}</li>
                            </c:forEach>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:import url="footer.jsp"/>
    </body>
</html>
