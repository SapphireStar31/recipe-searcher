<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:if test="${empty userInfo}">
        <c:redirect url="error.jsp"/>
    </c:if>

    <head>
        <c:import url="templates/head.jsp"/>
        <link rel="stylesheet" href="css/recipeForms.css">
        <title>Edit Recipe</title>
    </head>

    <body>
        <header>
            <c:import url="templates/navigation.jsp"/>
            <c:import url="templates/searchBar.jsp"/>
            <h1>Edit Recipe</h1>
        </header>

        <div class="fullForm">
            <form id="recipeForm" method="get" action="update-recipe">
                <label for="recipeName" class="sameWidth">Recipe Name</label>
                <input type="text" id="recipeName" name="recipeName" value="${recipeInfo.recipeName}" required>

                <fieldset>
                    <legend>Ingredients in Recipe</legend>

                    <div id="ingredientInputField">
                        <c:set var="loopCount" value="1"/>
                        <c:forEach var="ingredients" items="${recipeInfo.ingredients}">
                            <label for="ingredient${loopCount}" class="sameWidth">Ingredient ${loopCount}</label>
                            <input type="text" id="ingredient${loopCount}" name="ingredient${loopCount}" value="${ingredients.ingredientName}" required>
                            <br>
                            <c:set var="loopCount" value="${loopCount + 1}"/>
                        </c:forEach>
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
        </div>



        <script src="javascript/addRemoveInputFormFields.js"></script>
        <c:import url="templates/footer.jsp"/>
    </body>
</html>