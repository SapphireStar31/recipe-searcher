<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:import url="templates/head.jsp"/>
        <link rel="stylesheet" href="css/index.css">
        <title>Home - Recipe Searcher</title>
    </head>

    <body>
        <header>
            <c:import url="templates/navigation.jsp"/>
            <img src="images/updated.png" alt="Welcome" class="img-fluid">
        </header>

        <main>
            <br>
            <p class="centerText">What is the Recipe Searcher?</p>
            <p class="centerText">The Recipe Searcher is a site where you can search for recipes by their name or ingredients and get information about what common ingredients are within that recipe. When looking at a recipe page you also get three similar recipes provided by <a href="https://spoonacular.com/food-api">Spoonacular API</a> from their database. This way you can get new ideas for what you might want to look up and make that aren't on this website. The similar recipes are random so you get a different one everytime you enter the recipe page. If there are no similar recipes or less than three then you won't get randomized results.</p>
            <p class="centerText">You can also sign up which only requires a full name, username, and a password. Once you sign up and log in you can add your own recipes, as well as edit the recipes you have added and delete them. Feel free to give it a try and I hope you enjoy using the Recipe Searcher!</p>
            <br>
            <hr>
            <h2 class="centerText">Get Started Here!</h2>
            <p>Start by searching for recipes depending on what you are looking for or just take a look at everything that has been added so far.</p>
            <p>If you scroll a little further down you can search by ingredients.</p>
            <br>
            <h3>Search for recipes by recipe name here:</h3>
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
            <h3>Search for recipes by ingredient here:</h3>
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
        <c:import url="templates/footer.jsp"/>
    </body>
</html>