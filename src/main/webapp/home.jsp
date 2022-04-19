<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: tosya
  Date: 16.04.2022
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Home page</title>
</head>
<p>
<h1>Hello ${name}!</h1>
You login as ${login}
</p>
About you:
</p>
Sign in system with role ${role}.
</p>
Your name - ${name}, age ${age}.
</p>
<c:if test="${role eq 'ADMIN'}">
    <table>
        <thead>
        <tr>
            <th>Login</th>
            <th>Name</th>
            <th>Age</th>
            <th>Role</th>
            <th>Password</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.age}"/></td>
                <td><c:out value="${user.role}"/></td>
                <td><c:out value="${user.password}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</p>
<a href="/index.jsp" class="btn btn-default" id="btn-reg">Back to sign in</a>
</body>
</html>
