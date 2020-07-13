<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration</title>
</head>
<body>
<div align="center">
    <h1>User Register Form</h1>
    <form action="<%=request.getContextPath()%>/registration" method="post">
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
        </table>
        <input type="submit" value="Submit" />
    </form>
</div>
</body>
</html>