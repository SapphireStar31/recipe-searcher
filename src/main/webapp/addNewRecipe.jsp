<%--
  Created by IntelliJ IDEA.
  User: Karissa
  Date: 11/12/2024
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add Recipe - Recipe Searcher</title>
    </head>

    <body>
        <form id="addRecipeForm" method="get" action="add-recipe">
            <label for="recipeName">Recipe Name</label>
            <input type="text" id="recipeName" name="recipeName">

            <fieldset>
                <legend>Ingredients in Recipe</legend>

                <div id="ingredientInputField">
                    <label for="ingredient1">Ingredient Name</label>
                    <input type="text" id="ingredient1" name="ingredient1">
                </div>
            </fieldset>
            <br>
            <input type="submit">
        </form>
        <br>
        <button onclick="addInputField()">Add Input Field</button>



        <script>
            function addInputField() {
                const myForm = document.getElementById("addRecipeForm");
                const formLength = myForm.length - 2;
                const ingredientNumberName = "ingredient" + formLength;

                const inputField = document.getElementById("ingredientInputField");

                const newLabelField = document.createElement("label");
                newLabelField.setAttribute("for", ingredientNumberName);
                newLabelField.textContent = "Ingredient " + formLength;

                const newInputField = document.createElement("input");
                newInputField.setAttribute("type", "text");
                newInputField.setAttribute("id", ingredientNumberName);
                newInputField.setAttribute("name", ingredientNumberName);

                inputField.appendChild(newLabelField);
                inputField.appendChild(newInputField);
            }
        </script>
    </body>
</html>