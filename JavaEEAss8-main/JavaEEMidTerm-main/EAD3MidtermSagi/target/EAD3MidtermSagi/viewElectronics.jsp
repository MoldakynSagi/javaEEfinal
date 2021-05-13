<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Title </title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <link href="css/c.css" rel='stylesheet' type='text/css'/>

</head>
<body>
<%!
    String name = "";
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="adminDashboard.jsp">iStore</a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="ViewElectronicsServlet">View Electronics</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="addElectronic.jsp">ADD</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="deleteElectronic.jsp">Delete</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="OrdersServlet">Orders</a>
                </li>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link">--%>
<%--                            <%= name = request.getParameter("name") %>--%>
<%--                </li>--%>
                <li class="nav-item">
                    <a class="nav-link" href="UserLogoutServlet"> Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<table class="table table-striped">
    <thead>
    <tr>
        <th>electronic Id</th>
        <th>electronic title</th>
        <th>electronic description</th>
        <th>electronic price</th>
        <th>Update</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="electronic" items="${Electronics}">
        <tr>
            <td><c:out value="${electronic.id}"/></td>
            <td><c:out value="${electronic.name}"/></td>
            <td><c:out value="${electronic.description}"/></td>
            <td><c:out value="${electronic.price}"/></td>
            <td><a href="Update?id=<c:out value='${electronic.id}' />">Edit</a>
        </tr>

    </c:forEach>
    </tbody>
</table>
<br>
<br>
<br>
<br>
<br>
<br>
<jsp:include page="footer.jsp" />







<!-- Footer -->


</body>


</html>
