<%@ page import="entity.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Exhibition" %><%--
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
<form action="${pageContext.request.contextPath}/exhibition_crud" method = "post">
  <input type="hidden" name="action" value="create"/>
  <label for="start">start Date:</label><br>
  <input type = "date" name="start" id = "start">
  <label for="end">end Date:</label><br>
  <input type = "date" name="end" id = "end">
  <label for="country">country:</label><br>
  <input type = "text" name="country" id = "country">
  <label for="city">city:</label><br>
  <input type = "text" name="city" id = "city">
  <label for="name">name:</label><br>
  <input type = "text" name="name" id = "name">

  <button type="submit">add</button>
</form>

<h>add exhibits</h>

<form action="${pageContext.request.contextPath}/exhibition_crud" method = "post">
  <input type="hidden" name="action" value="add"/>
  <label for="exh_id">id:</label><br>
  <input type = "number" name="exh_id" id = "exh_id">
  <label for="add_id">id of exhibit to add:</label><br>
  <input type = "number" name="add_id" id = "add_id">
  <button type="submit">find</button>
</form>

<h>remove exhibits</h>

<form action="${pageContext.request.contextPath}/exhibition_crud" method = "post">
  <input type="hidden" name="action" value="delete_exh"/>
  <label for="exhibition_id">id:</label><br>
  <input type = "number" name="exhibition_id" id = "exhibition_id">
  <label for="remove_id">id of exhibit to add:</label><br>
  <input type = "number" name="remove_id" id = "remove_id">
  <button type="submit">find</button>
</form>
<h>Update</h>
<form action="${pageContext.request.contextPath}/exhibition_crud" method = "post">
  <input type="hidden" name="action" value="update"/>
  <label for = "update_id">id:</label>
  <input type="number" name = "update_id" id = "update_id">
  <label for="u_name">name:</label><br>
  <input type = "text" name="name" id = "u_name">
  <label for="u_email">email:</label><br>
  <input type = "text" name="email" id = "u_email">

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
<form action="${pageContext.request.contextPath}/exhibition_crud" method = "post">
  <input type="hidden" name="action" value="delete"/>
  <label for="delete_id">id:</label><br>
  <input type = "number" name="delete_id" id = "delete_id">
  <button type="submit">delete</button>
</form>
<table>
  <thead>
  <tr>
    <td>id</td>
    <td>hallNumber</td>
    <td>endDate</td>
    <td>name</td>
    <td>country</td>
    <td>city</td>
    <td>venue</td>
    <td>exhibits</td>
  </tr>
  </thead>
  <tbody>
  <% List<Exhibition> exhibitions = (List<Exhibition>) request.getAttribute("exhibitions"); %>
  <% int i = 1 ;%>
  <% for (Exhibition exhibition : exhibitions) {%>
  <tr>
    <td><%= exhibition.getId() %></td>
    <td><%= i %></td>
    <td><%= exhibition.getEndDate()%></td>
    <td><%= exhibition.getName()%></td>
    <td><%= exhibition.getCountry()%></td>
    <td><%= exhibition.getCity()%></td>
    <td><%= exhibition.getVenue()%></td>
    <td><%= exhibition.getExhibitList().toString()%></td>
  </tr>
  <% i++;} %>
  </tbody>
</table>

</body>
</html>
