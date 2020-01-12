<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Web Student Tracker</title>
		<link type="text/css" rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<!-- ${TODO_LIST}-->
		<div id="wrapper">
			<div id="header">
				<h2>To Do List</h2>
			</div>
			</div>
			<div id="wrapper">
			<div id="header">
			<h2>Welcome ${User}</h2>
			</div>
		</div>
		<br>
		<div id="container">
			<div id="content">
				<form action="AddTodoServlet" method="get">
					<input type="submit" value="Add Todo"/>
				</form>
				<table>
					<tr>
						<th>Id</th>
						<th>To Do</th>
					</tr>
					<c:forEach var="temptodos" items="${TODO_LIST }">
						<c:url var="EditLink" value= "EditTodoServlet">
							<c:param name="todoId" value="${temptodos.id}"/>
						</c:url>
						<c:url var="DeleteLink" value= "DeleteTodoServlet">
							<c:param name="todoId" value="${temptodos.id}"/>
						</c:url>
						<tr>
							<td> ${temptodos.id}</td>
							<td> ${temptodos.description}</td>
							<td> <a href="${EditLink }"> Edit</a>|<a href="${DeleteLink }">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
				<br>
				<form action="Deconnexion" method="get">
					<input type="submit" value="Disconnect"/>
				</form>
			</div>
		</div>
	</body>
</html>