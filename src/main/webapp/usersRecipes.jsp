<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:import url="head.jsp"/>

    <c:if test="${empty userInfo}">
        <c:redirect url="error.jsp"/>
    </c:if>

    <body>
        <header>
            <c:import url="navigation.jsp"/>
            <c:import url="searchBar.jsp"/>
            <h1>${userName} Recipes</h1>
        </header>

        <table class="table table-striped table-hover">
            <tr>
                <th scope="col">Recipe Name</th>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
            </tr>
            <c:forEach var="recipes" items="${userRecipes}">
                <tr>
                    <td>${recipes.recipeName}</td>
                    <td><a href="edit-recipe-info?recipeToEditID=${recipes.recipeNameID}">Edit</a></td>
                    <td><a href="delete-recipe?recipeToDeleteID=${recipes.recipeNameID}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <c:import url="footer.jsp"/>
    </body>
</html>