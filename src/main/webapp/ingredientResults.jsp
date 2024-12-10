<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:import url="templates/head.jsp"/>
        <title>Search Ingredients</title>
    </head>

    <body>
        <header>
            <c:import url="templates/navigation.jsp"/>
            <c:import url="templates/searchBar.jsp"/>
            <h1>Search Results</h1>
        </header>

        <table class="table table-striped table-hover">
            <tr>
                <th scope="col">Ingredient Name</th>
                <th scope="col">Recipe Name</th>
            </tr>
            <c:forEach var="ingredients" items="${ingredients}">
                <tr>
                    <td>${ingredients.ingredientName}</td>
                    <td>
                        <ul>
                            <c:forEach var="recipes" items="${ingredients.recipes}">
                                <li><a href="recipe-information?recipeName=${recipes.recipeName}">${recipes.recipeName}</a></li>
                            </c:forEach>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:import url="templates/footer.jsp"/>
    </body>
</html>
