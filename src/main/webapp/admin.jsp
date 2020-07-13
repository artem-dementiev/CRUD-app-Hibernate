<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/redirect">Add New User</a>

<div align="center">
    <table border="2">
        <tr>
            <td>ID</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Login</td>
            <td>Password</td>
            <td>E-mail</td>
            <td>Address</td>
            <td>Phone Number</td>
            <td>Role</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getFirstName()}</td>
                <td>${user.getLastName()}</td>
                <td>${user.getLogin()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getAddress()}</td>
                <td>${user.getPhoneNumber()}</td>
                <td>${user.getRole().getRoleName()}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/edit.jsp"
                          method="post">
                        <input type="hidden" name="id" value="${user.getId()}">
                        <input type="hidden" name="firstName"
                               value="${user.getFirstName()}">
                        <input type="hidden" name="lastName"
                               value="${user.getLastName()}">
                        <input type="hidden" name="login"
                               value="${user.getLogin()}">
                        <input type="hidden" name="password"
                               value="${user.getPassword()}">
                        <input type="hidden" name="email"
                               value="${user.getEmail()}">
                        <input type="hidden" name="address"
                               value="${user.getAddress()}">
                        <input type="hidden" name="phoneNumber"
                               value="${user.getPhoneNumber()}">
                        <input type="hidden" name="role"
                               value="${user.getRole().getRoleName()}">
                        <input type="submit" value="Edit"
                               style="float:left">
                    </form>
                    <form action="${pageContext.request.contextPath}/delete"
                          method="post">
                        <input type="hidden" name="id" value="${user.getId()}">
                        <input type="submit" value="Delete" style="float:left">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>