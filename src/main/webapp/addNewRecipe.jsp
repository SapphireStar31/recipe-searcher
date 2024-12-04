<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:import url="head.jsp"/>

    <%
        String userName = (String)session.getAttribute("userName");
        if (userName == null) {
            response.sendRedirect("error.jsp");
        }
    %>

    <body>
        <header>
            <c:import url="navigation.jsp"/>
            <c:import url="searchBar.jsp"/>
            <h1>Add a New Recipe</h1>
        </header>

        <form id="addRecipeForm" method="post" action="add-recipe">
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
        <button onclick="removeInputField()">Remove Input Field</button>



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
        <script>
            function removeInputField() {
                const formInputField = document.getElementById("ingredientInputField");
                if (formInputField.children.length > 2) {
                    formInputField.removeChild(formInputField.lastChild);
                    formInputField.removeChild(formInputField.lastChild);
                }
            }
        </script>
        <c:import url="footer.jsp"/>
    </body>
</html>