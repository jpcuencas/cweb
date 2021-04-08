<%--
  Created by IntelliJ IDEA.
  User: expertojava
  Date: 23/10/15
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="j_security_check" METHOD="POST">
  <table>
    <tr>
      <td>
        Login:<input type="text" name="j_username"/>
      </td>
    </tr>
    <tr>
      <td>
        Password:<input type="text" name="j_password"/>
      </td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="Enviar"/>
      </td>
    </tr>
  </table>
</form>
</body>t
</html>
