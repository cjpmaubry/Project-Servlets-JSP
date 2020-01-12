<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/add-todos-style.css">
<link type="text/css" rel="stylesheet" href="css/style.css">
<title>Deconnexion</title>
</head>
<body>
<div id="wrapper">
<div id="header">
<h2>You are disconnected</h2>
</div>
</div>
<div id="container">
<div style="clear:both;"></div>
<form action="UserControllerServlet" method="get">
<input type="submit" value="Reconnect"/>
</form>
</div>
</body>
</html>