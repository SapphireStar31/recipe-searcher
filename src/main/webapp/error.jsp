<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:import url="templates/head.jsp"/>
        <title>Error</title>
    </head>

    <body>
        <header>
            <c:import url="templates/navigation.jsp"/>
            <c:import url="templates/searchBar.jsp"/>
            <h1>Error</h1>
        </header>

        <h2>Whoops!</h2>
        <p>Looks like we hit an error. Try again later.</p>
        <c:import url="templates/footer.jsp"/>
    </body>
</html>
