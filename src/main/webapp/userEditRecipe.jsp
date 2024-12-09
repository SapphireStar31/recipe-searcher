<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:if test="${empty userInfo}">
        <c:redirect url="error.jsp"/>
    </c:if>

    <head>
        <c:import url="templates/head.jsp"/>
        <title>Edit Recipe</title>
    </head>

    <body>
        <header>
            <c:import url="templates/navigation.jsp"/>
            <c:import url="templates/searchBar.jsp"/>
            <h1>Edit Recipe</h1>
        </header>

        <form id="editRecipeForm" method="get" action="update-recipe">
            <label for="recipeName">Recipe Name</label>
            <input type="text" id="recipeName" name="recipeName" value="${recipeInfo.recipeName}" required>

            <fieldset>
                <legend>Ingredients in Recipe</legend>

                <div id="ingredientInputField">
                    <c:set var="loopCount" value="1"/>
                    <c:forEach var="ingredients" items="${recipeInfo.ingredients}">
                        <label for="ingredient${loopCount}">Ingredient ${loopCount}</label>
                        <input type="text" id="ingredient${loopCount}" name="ingredient${loopCount}" value="${ingredients.ingredientName}" required>
                        <c:set var="loopCount" value="${loopCount + 1}"/>
                    </c:forEach>
                </div>
            </fieldset>
            <br>
            <input type="submit">
        </form>
        <br>
        <button onclick="addInputField()">Add Another Ingredient</button>
        <button onclick="removeInputField()">Remove Last Ingredient</button>



        <script>
            function addInputField() {
                const myForm = document.getElementById("editRecipeForm");
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
        <script>
            function removeInputField() {
                const formInputField = document.getElementById("ingredientInputField");
                if (formInputField.children.length > 2) {
                    formInputField.removeChild(formInputField.lastChild);
                    formInputField.removeChild(formInputField.lastChild);
                }
            }
        </script>
        <c:import url="templates/footer.jsp"/>
    </body>
</html>