<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<link type="text/css" rel="stylesheet" href="css/login-style.css"> 
<link type="text/css" rel="stylesheet" href="css/style.css">
<title>Login</title> 
</head>
<body>
<div id="wrapper"> <div id="header"> 
<h1>System Gestion of Todos</h1> </div> </div> 
<div id="container"> <h3> Login</h3>
<form action="UserControllerServlet" method = "post"> <table> <tbody> <tr>
<td><label>Username: </label> </td> <td><input type="text" name = "username" value= "${Cusername}" /></td>
</tr> <tr>
<td><label>Password: </label> </td> <td><input type="password" name = "password"/></td>
</tr>
<tr>
<td><label></label> </td> <td><input type="submit" value = "Login"/></td>
</tr> </tbody> </table>
</form>  
</div>
</body>
</html>
