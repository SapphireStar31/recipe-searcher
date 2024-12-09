<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:import url="head.jsp"/>
        <title>Error</title>
    </head>

    <body>
        <header>
            <c:import url="navigation.jsp"/>
            <c:import url="searchBar.jsp"/>
            <h1>Error</h1>
        </header>

        <h2>Whoops!</h2>
        <p>Looks like we hit an error. Try again later.</p>
        <c:import url="footer.jsp"/>
    </body>
</html>
