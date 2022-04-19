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
<h1>Hello Admin!</h1>
You login as ${login}
</p>
About you:
</p>
name ${name}, age ${age}
</p>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list } " var="userList">
    <tr>
        <td>${userList.name() }   ${userList.age() } </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</p>
<a href="/index.jsp" class="btn btn-default" id="btn-reg">Back to sign in</a>
</body>
</html>
