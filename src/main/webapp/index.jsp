<!DOCTYPE html>
<html>
    <head>
        <title>Home - Recipe Searcher</title>
    </head>

    <body>
        <header>
            <h1>Welcome!</h1>
        </header>

        <main>
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
        </main>
    </body>

    <footer>

    </footer>
</html>