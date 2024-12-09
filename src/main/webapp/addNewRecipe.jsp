<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:if test="${empty userInfo}">
        <c:redirect url="error.jsp"/>
    </c:if>

    <head>
        <c:import url="templates/head.jsp"/>
        <link rel="stylesheet" href="css/addNewRecipe.css">
        <title>Add New Recipe</title>
    </head>

    <body>
        <header>
            <c:import url="templates/navigation.jsp"/>
            <c:import url="templates/searchBar.jsp"/>
            <h1>Add a New Recipe</h1>
        </header>

        <form id="addRecipeForm" method="post" action="add-recipe">
            <label for="recipeName" class="sameWidth">Recipe Name</label>
            <input type="text" id="recipeName" name="recipeName" required>

            <fieldset>
                <legend>Ingredients in Recipe</legend>

                <div id="ingredientInputField">
                    <label for="ingredient1" class="sameWidth">Ingredient Name</label>
                    <input type="text" id="ingredient1" name="ingredient1" required>
                    <br>
                </div>
            </fieldset>
            <br>
            <div class="buttonCenter">
                <input class="btn btn-success btn-large" type="submit">
            </div>
        </form>
        <br>
        <div class="buttonCenter">
            <button onclick="addInputField()" class="btn btn-primary javaBtn">Add Another Ingredient</button>
            <button onclick="removeInputField()" class="btn btn-danger javaBtn">Remove Last Ingredient</button>
        </div>



        <script>
            function addInputField() {
                const myForm = document.getElementById("addRecipeForm");
                const formLength = myForm.length - 2;
                const ingredientNumberName = "ingredient" + formLength;

                const inputField = document.getElementById("ingredientInputField");

                const newLabelField = document.createElement("label");
                newLabelField.setAttribute("for", ingredientNumberName);
                newLabelField.setAttribute("class", "sameWidth")
                newLabelField.textContent = "Ingredient " + formLength;

                const newInputField = document.createElement("input");
                newInputField.setAttribute("type", "text");
                newInputField.setAttribute("id", ingredientNumberName);
                newInputField.setAttribute("name", ingredientNumberName);

                const addLineBreak = document.createElement("br");

                inputField.appendChild(newLabelField);
                inputField.appendChild(newInputField);
                inputField.appendChild(addLineBreak);
            }
        </script>
        <script>
            function removeInputField() {
                const formInputField = document.getElementById("ingredientInputField");
                if (formInputField.children.length > 3) {
                    formInputField.removeChild(formInputField.lastChild);
                    formInputField.removeChild(formInputField.lastChild);
                    formInputField.removeChild(formInputField.lastChild);
                }
            }
        </script>
        <c:import url="templates/footer.jsp"/>
    </body>
</html>