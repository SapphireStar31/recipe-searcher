<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:import url="head.jsp"/>

    <body>
        <header>
            <c:import url="navigation.jsp"/>
            <c:import url="searchBar.jsp"/>
            <h1>Recipe Information</h1>
        </header>

        <main>
            <h2>${recipeInfo.recipeName}</h2>

            <h3>Ingredients</h3>
            <ul>
                <c:forEach var="ingredients" items="${recipeInfo.ingredients}">
                    <li>${ingredients.ingredientName}</li>
                </c:forEach>
            </ul>

            <br><br>

            <h3>Some similar recipes:</h3>
            <ul>
                <c:forEach var="apiSearchInfo" items="${apiSearchInfo}">
                    <li>${apiSearchInfo.title}</li>
                </c:forEach>
            </ul>
        </main>
        <c:import url="footer.jsp"/>
    </body>
</html>