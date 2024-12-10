function addInputField() {
    const myForm = document.getElementById("recipeForm");
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
    newInputField.setAttribute("required", true);

    const addLineBreak = document.createElement("br");

    inputField.appendChild(newLabelField);
    inputField.appendChild(newInputField);
    inputField.appendChild(addLineBreak);
}

function removeInputField() {
    const formInputField = document.getElementById("ingredientInputField");
    if (formInputField.children.length > 3) {
        formInputField.removeChild(formInputField.lastChild);
        formInputField.removeChild(formInputField.lastChild);
        formInputField.removeChild(formInputField.lastChild);
    }
}