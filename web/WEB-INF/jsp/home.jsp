<%-- 
    Document   : home
    Created on : Nov 27, 2018, 10:14:09 AM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <jsp:include page="partials/head.jsp" flush="true" />
    <body>
        <jsp:include page="partials/nav.jsp" flush="true" />

    <main role="main" class="container">
        <!-- Main jumbotron for a primary marketing message or call to action -->
        <div class="jumbotron top">
            <h1>Navbar example</h1>
            <p class="lead">This example is a quick exercise to illustrate how the top-aligned navbar works. As you scroll, this navbar remains in its original position and moves with the rest of the page.</p>
            <a class="btn btn-lg btn-primary" href="#" role="button">View navbar docs »</a>
        </div>

    </main>

    <jsp:include page="partials/footer.jsp" flush="true" />
</body>
</html>

