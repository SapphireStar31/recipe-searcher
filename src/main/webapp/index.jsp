<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:import url="head.jsp"/>
        <title>Home - Recipe Searcher</title>
    </head>

    <body>
        <header>
            <c:import url="navigation.jsp"/>
            <c:choose>
                <c:when test="${empty userName}">
                    <h1>Welcome!</h1>
                </c:when>
                <c:otherwise>
                    <h1>Welcome ${userName}!</h1>
                </c:otherwise>
            </c:choose>
        </header>

        <main>
            <hr>
            <br>
            <p>Search for recipes by recipe name here:</p>
            <form method="get" action="recipe-search">
                <fieldset>
                    <legend>Would you like exact matches or partial matches?</legend>
                    <input type="radio" id="recipeExactMatch" name="recipeMatching" value="exactMatch" checked>
                    <label for="recipeExactMatch">Exact Matches</label>

                    <input type="radio" id="recipePartialMatch" name="recipeMatching" value="partialMatch">
                    <label for="recipePartialMatch">Partial Matches</label>
                </fieldset>

                <label for="recipeSearchBox">Search Term</label>
                <input type="text" id="recipeSearchBox" name="recipeSearchTerm">

                <input type="submit">
            </form>
            <br><br>
            <p>Want to browse all recipes then you can look here: <a href="all-recipes">All Recipes</a></p>
            <br><br>
            <hr>
            <br><br>
            <p>Search for recipes by ingredient here:</p>
            <form method="get" action="ingredient-search">
                <fieldset>
                    <legend>Would you like exact matches or partial matches?</legend>
                    <input type="radio" id="ingredientExactMatch" name="ingredientMatching" value="exactMatch" checked>
                    <label for="ingredientExactMatch">Exact Matches</label>

                    <input type="radio" id="ingredientPartialMatch" name="ingredientMatching" value="partialMatch">
                    <label for="ingredientPartialMatch">Partial Matches</label>
                </fieldset>

                <label for="ingredientSearchBox">Search Term</label>
                <input type="text" id="ingredientSearchBox" name="ingredientSearchTerm">

                <input type="submit">
            </form>
            <br><br>
            <p>Want to browse all ingredients then you can look here: <a href="all-ingredients">All Ingredients</a></p>
            <br><br>
        </main>
        <c:import url="footer.jsp"/>
    </body>
</html>