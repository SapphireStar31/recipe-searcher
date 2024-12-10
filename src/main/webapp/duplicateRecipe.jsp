<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:import url="templates/head.jsp"/>
        <title>Duplicate Recipe</title>
    </head>

    <body>
        <header>
            <c:import url="templates/navigation.jsp"/>
            <c:import url="templates/searchBar.jsp"/>
            <h1>Duplicate Recipe</h1>
        </header>

        <h2>Looks like we already have this recipe in our database.</h2>
        <p>If you give a search through the database you can see what the other recipe looks like.</p>
        <p>In the future we plan on updating it so you can add ingredients to a recipe even if you didn't create it.</p>
        <c:import url="templates/footer.jsp"/>
    </body>
</html>

