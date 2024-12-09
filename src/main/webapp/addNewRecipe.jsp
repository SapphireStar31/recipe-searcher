<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:if test="${empty userInfo}">
        <c:redirect url="error.jsp"/>
    </c:if>

    <head>
        <c:import url="templates/head.jsp"/>
        <link rel="stylesheet" href="css/recipeForms.css">
        <title>Add New Recipe</title>
    </head>

    <body>
        <header>
            <c:import url="templates/navigation.jsp"/>
            <c:import url="templates/searchBar.jsp"/>
            <h1>Add a New Recipe</h1>
        </header>

        <form id="recipeForm" method="post" action="add-recipe">
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



        <script src="javascript/addRemoveInputFormFields.js"></script>
        <c:import url="templates/footer.jsp"/>
    </body>
</html>