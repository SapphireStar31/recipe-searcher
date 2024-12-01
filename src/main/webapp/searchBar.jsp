<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="row row-col-2">
                <div class="col-12">
                    <p>Search for recipes by name here:</p>
                </div>
                <form method="get" action="recipe-search">
                    <div class="col-12">
                        <input type="radio" id="recipeExactMatch" name="recipeMatching" value="exactMatch" checked>
                        <label for="recipeExactMatch">Exact Matches</label>
                        <input type="radio" id="recipePartialMatch" name="recipeMatching" value="partialMatch">
                        <label for="recipePartialMatch">Partial Matches</label>
                    </div>

                    <div class="col-12">
                        <label for="recipeSearchBox">Search Term</label>
                        <input type="text" id="recipeSearchBox" name="recipeSearchTerm">

                        <input type="submit">
                    </div>
                </form>
            </div>
        </div>
        <div class="col">
            <div class="row row-col-2">
                <div class="col-12">
                    <p>Search recipes by ingredient here:</p>
                </div>
                <form method="get" action="ingredient-search">
                    <div class="col-12">
                        <input type="radio" id="ingredientExactMatch" name="ingredientMatching" value="exactMatch" checked>
                        <label for="ingredientExactMatch">Exact Matches</label>
                        <input type="radio" id="ingredientPartialMatch" name="ingredientMatching" value="partialMatch">
                        <label for="ingredientPartialMatch">Partial Matches</label>
                    </div>

                    <div class="col-12">
                        <label for="ingredientSearchBox">Search Term</label>
                        <input type="text" id="ingredientSearchBox" name="ingredientSearchTerm">

                        <input type="submit">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<br>
