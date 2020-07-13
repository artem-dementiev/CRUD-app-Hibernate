<html>
<head>
    <title>Updating user</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/edit">
    <input type="hidden" name="id" value="${param.id}">
    <label>
        First Name:
        <input type="text" name="firstName" value="${param.firstName}">
    </label>
    <br>
    <br>
    <label>
        Last Name:
        <input type="text" name="lastName" value="${param.lastName}">
    </label>
    <br>
    <br>
    <label>
        Login:
        <input type="text" name="login" value="${param.login}">
    </label>
    <label>
        Password:
        <input type="text" name="password" value="${param.password}">
    </label>
    <br>
    <br>
    <label>
        E-mail:
        <input type="email" name="email" value="${param.email}">
    </label>
    <br>
    <br>
    <label>
        Address:
        <input type="text" name="address" value="${param.address}">
    </label>
    <br>
    <br>
    <label>
        Phone Number:
        <input type="text" name="phoneNumber" value="${param.phoneNumber}">
    </label>
    <br>
    <br>
    <label>
        Role:
        <input type="text" name="role" value="${param.role}">
    </label>
    <br>
    <br>
    <input type="submit" value="Update">
</form>
<br>

<form action="${pageContext.request.contextPath}/admin">
    <input type="submit" value="Return to list">
</form>
</body>
</html>
