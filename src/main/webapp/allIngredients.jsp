<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:import url="head.jsp"/>
        <title>All Ingredients</title>
    </head>

    <body>
        <header>
            <c:import url="navigation.jsp"/>
            <c:import url="searchBar.jsp"/>
            <h1>All Ingredients</h1>
        </header>

        <table class="table table-striped table-hover">
            <tr>
                <th scope="col">Ingredient Name</th>
            </tr>
            <c:forEach var="ingredients" items="${ingredients}">
                <tr>
                    <td>${ingredients.ingredientName}</td>
                </tr>
            </c:forEach>
        </table>
        <c:import url="footer.jsp"/>
    </body>
</html>