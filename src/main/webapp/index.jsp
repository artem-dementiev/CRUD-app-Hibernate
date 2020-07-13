<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
</head>
<body>
<div align="center">
    <h1>Login Form</h1>
    <form action="<%=request.getContextPath()%>/index" method="post">
        <table style="with: 100%">
            <tr>
                <td>Login</td>
                <td><input type="text" name="login" required placeholder="Login"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" required placeholder="Password"/></td>
            </tr>

        </table>
        <input type="submit" value="Submit" />
    </form>
    <br>
    <a href="${pageContext.request.contextPath}registration.jsp">New here?</a>
</div>
</body>
</html>
