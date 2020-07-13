<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding user page</title>
</head>
<body>
<div align="center">
<form method="post" action="${pageContext.request.contextPath}/add">
    <table style="with: 80%">
        <tr>
            <td>First Name</td>
            <td><input required type="text" name="firstName" placeholder="First Name"/></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input required type="text" name="lastName" placeholder="Last Name"/></td>
        </tr>
        <tr>
            <td>Login</td>
            <td><input required type="text" name="login" placeholder="Login"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input required type="password" name="password" placeholder="Password" /></td>
        </tr>
        <tr>
            <td>E-mail</td>
            <td><input required type="email" name="email" placeholder="E-mail" /></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" placeholder="Address" /></td>
        </tr>
        <tr>
            <td>Phone Number</td>
            <td><input type="text" name="phoneNumber" placeholder="Phone Number"/></td>
        </tr>
        <tr>
            <td>Role</td>
            <td><input list="<roles>">
                <datalist id="<roles>">
                    <option value="admin">
                    <option value="user">
                </datalist></td>
        </tr>
    </table>
    <input type="submit" value="Add">
</form>
<form action="${pageContext.request.contextPath}/admin" method="get">
    <input type="submit" value="Return to list">
</form>
</div>
</body>
</html>
