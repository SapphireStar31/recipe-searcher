<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link" href="index.jsp">Homepage</a>
                <a class="nav-link" href="all-recipes">All Recipes</a>
                <a class="nav-link" href="all-ingredients">All Ingredients</a>
                <c:choose>
                    <c:when test="${empty userInfo}">
                        <a class="nav-link" href="log-in">Log in/Sign Up</a>
                    </c:when>
                    <c:otherwise>
                        <a class="nav-link" href="addNewRecipe.jsp">Add a New Recipe</a>
                        <a class="nav-link" href="user-recipes">${userName} Recipes</a>
                        <a class="nav-link" href="log-out">Log out here</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</nav>
