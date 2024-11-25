<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:import url="head.jsp"/>

    <body>
        <header>
            <c:import url="navigation.jsp"/>
            <c:import url="searchBar.jsp"/>
            <h1>All Ingredients</h1>
        </header>

        <table>
            <tr>
                <th>Ingredient Name</th>
            </tr>
            <c:forEach var="ingredients" items="${ingredients}">
                <tr>
                    <td>${ingredients.ingredientName}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>