<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:import url="templates/head.jsp"/>
        <title>Recipe Added</title>
    </head>

    <body>
        <header>
            <c:import url="templates/navigation.jsp"/>
            <c:import url="templates/searchBar.jsp"/>
            <h1>Success</h1>
        </header>

        <h2>Your recipe has been added.</h2>
        <p>Thank you for adding a recipe! Take a look at the all recipes page to check out your recipe or you can add another recipe.</p>
        <c:import url="templates/footer.jsp"/>
    </body>
</html>
