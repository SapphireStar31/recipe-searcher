<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:import url="templates/head.jsp"/>
        <title>All Recipes</title>
    </head>

    <body>
        <header>
            <c:import url="templates/navigation.jsp"/>
            <c:import url="templates/searchBar.jsp"/>
            <h1>All Recipes</h1>
        </header>

        <table class="table table-striped table-hover">
            <tr>
                <th scope="col">Recipe Name</th>
            </tr>
            <c:forEach var="recipes" items="${recipes}">
                <tr>
                    <td><a href="recipe-information?recipeName=${recipes.recipeName}">${recipes.recipeName}</a></td>
                </tr>
            </c:forEach>
        </table>
        <c:import url="templates/footer.jsp"/>
    </body>
</html>