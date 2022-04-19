<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 17.04.2022
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up page</title>
</head>
<body>
<form action="/register" method="POST">
    <p class="container">
    <h1>Welcome, Please sign up!</h1>
    <h2>Enter your:</h2>
    <label><b>name:</b></label>
    <input type="text" placeholder="name" name="name">
    </p>
    <label><b>Age:</b></label>
    <input type="number" name="age">
    </p>
    <label><b>login:</b></label>
    <input type="text" placeholder="login" name="login">
    </p>
    <label><b>password:</b></label>
    <input type="password" placeholder="password" name="password">
    </p>
    <button type="submit" name="signUp">Sign up</button>
    <label><b>${warring}</b></label>
    </p>
    <a href="/index.jsp" class="btn btn-default" id="btn-reg">Back to sign in</a>
    </div>
</form>
</body>
</html>