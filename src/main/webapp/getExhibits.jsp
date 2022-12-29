<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 29.12.2022
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page import="entity.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Exhibit" %>
<%--
  Created by IntelliJ IDEA.
  User: Даня
  Date: 27.12.2022
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h>Create</h>
<form action="${pageContext.request.contextPath}/exhibit_crud" method = "post">
    <input type="hidden" name="action" value="create"/>
    <label for="hallnumber">hallnumber:</label><br>
    <input type = "number" name="hallnumber" id = "hallnumber">
    <label for="name">name:</label><br>
    <input type = "text" name="name" id = "name">

    <label for="year">name:</label><br>
    <input type = "number" name="year" id = "year">

    <label for="description">descripotion:</label><br>
    <input type = "text" name="description" id = "description">
    <label for="author">author:</label><br>
    <input type = "text" name="author" id = "author">

    <button type="submit">add</button>
</form>

<h>Update</h>
<form action="${pageContext.request.contextPath}/exhibit_crud" method = "post">
    <input type="hidden" name="action" value="create"/>
    <label for="update_id">id:</label><br>
    <input type = "number" name="update_id" id = "update_id">
    <label for="u_hallnumber">hallnumber:</label><br>
    <input type = "number" name="u_hallnumber" id = "u_hallnumber">
    <label for="u_name">name:</label><br>
    <input type = "text" name="u_name" id = "u_name">

    <label for="u_year">name:</label><br>
    <input type = "number" name="u_year" id = "u_year">

    <label for="u_description">descripotion:</label><br>
    <input type = "text" name="u_description" id = "u_description">
    <label for="u_author">author:</label><br>
    <input type = "text" name="u_author" id = "u_author">

    <button type="submit">add</button>

    <button type="submit">add</button>
</form>
<h>find</h>

<form action="${pageContext.request.contextPath}/exhibit" method = "post">
    <input type="hidden" name="action" value="find"/>
    <label for="find_id">id:</label><br>
    <input type = "number" name="find_id" id = "find_id">
    <button type="submit">find</button>
</form>
<h1 >delete</h1>
<form action="${pageContext.request.contextPath}/exhibit_crud" method = "post">
    <input type="hidden" name="action" value="delete"/>
    <label for="delete_id">id:</label><br>
    <input type = "number" name="delete_id" id = "delete_id">
    <button type="submit">delete</button>
</form>
<table>
    <thead>
    <tr>
        <td>id</td>
        <td>fio</td>
        <td>email</td>
        <td>group_id</td>
    </tr>
    </thead>
    <tbody>
    <% List<Exhibit> exhibits = (List<Exhibit>) request.getAttribute("exhibits"); %>
    <% for (Exhibit client : exhibits) {%>
    <tr>
        <td><%= client.getID() %></td>
        <td><%= client.getFullName() %></td>
        <td><%= client.getEmail()%></td>
    </tr>
    <% } %>
    </tbody>
</table>

</body>
</html>

</body>
</html>
