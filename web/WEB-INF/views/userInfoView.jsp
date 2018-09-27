<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 27.09.2018
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Hello: ${user.userName}</h3>

User Name: <b>${user.userName}</b>
<br />
Gender: ${user.gender } <br />

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>
