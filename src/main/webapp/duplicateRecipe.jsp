<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:import url="head.jsp"/>

    <body>
        <header>
            <c:import url="navigation.jsp"/>
            <c:import url="searchBar.jsp"/>
            <h1>Duplicate Recipe</h1>
        </header>

        <h2>Looks like we already have this recipe in our database.</h2>
        <p>If you give a search through the database you can see what the other recipe looks like. If you find something you want to add to that recipe you can edit it as long as you are logged in.</p>
        <c:import url="footer.jsp"/>
    </body>
</html>

