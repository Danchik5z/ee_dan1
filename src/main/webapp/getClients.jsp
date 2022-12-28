<%@ page import="entity.Client" %>
<%@ page import="java.util.List" %><%--
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
  <% List<Client> clients = (List<Client>) request.getAttribute("client"); %>
  <% for (Client client : clients) {%>
  <tr>
    <td><%= client.getID() %></td>
    <td><%= client.getFullName() %></td>
    <td><%= client.getEmail()%></td>
    <td>
      <a href='/client/update?id=<%= client.getID() %>'>Update</a> |
      <form method="get" action='/client/delete' style="display:inline;">
        <input type="hidden" name="id" value="<%= client.getID()%>">
        <input type="submit" value="Delete">
      </form>
    </td>
  </tr>
  <% } %>
  </tbody>
</table>

</body>
</html>
