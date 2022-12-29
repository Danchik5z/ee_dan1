<%@ page import="java.util.List" %>
<%@ page import="entity.Client" %><%--

  Created by IntelliJ IDEA.
  User: avast
  Date: 26.12.2022
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>index</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/clientclient">
    <input type="submit" value="client" />
</form>

<form action="${pageContext.request.contextPath}/exhibit">
    <input type="submit" value="exhibit" />
</form>

<form action="${pageContext.request.contextPath}/exhibition">
    <input type="submit" value="exhibition" />
</form>

<form action="${pageContext.request.contextPath}/hall">
    <input type="submit" value="hall" />
</form>

<form action="${pageContext.request.contextPath}/ticket">
    <input type="submit" value="ticket" />
</form>

</body>
</html>