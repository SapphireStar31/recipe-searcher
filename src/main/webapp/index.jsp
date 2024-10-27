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
                    <label for="recipeExactMatch">Exact Matches</label>
                    <input type="radio" id="recipeExactMatch" name="recipeMatching" value="exactMatch" checked>

                    <label for="recipePartialMatch">Partial Matches</label>
                    <input type="radio" id="recipePartialMatch" name="recipeMatching" value="partialMatch">
                </fieldset>

                <label for="recipeSearchBox">Search Term</label>
                <input type="text" id="recipeSearchBox" name="recipeSearchTerm">

                <input type="submit">
            </form>

            <p>Search for recipes by ingredient here:</p>
            <form>
                <p>blah</p>
            </form>
        </main>
    </body>

    <footer>

    </footer>
</html>