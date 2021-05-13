<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
    <%@ page isErrorPage="true" %>
    <%--  String name = (String)pageContext.getAttribute("user",PageContext.SESSION_SCOPE); --%>
    <%
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        if (name == "" || name == null){%>
    <h1>Field for name is empty!</h1>
    <a href="userLogin.jsp">login again</a>
    <%} else if(password == "" || password != "user123"){%>
    <h1>Field for password is empty or wrong!</h1>
    <a href="userLogin.jsp">login again</a>
    <%}%>
    <a href="adminLogin.jsp">if you admin</a>
</body>
</html>
