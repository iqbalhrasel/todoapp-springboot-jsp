<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home | TO DO App</title>
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="webjars/bootstrap/5.3.2/css/bootstrap.min.css">
</head>
<body>
	<div> <%@ include file="/common/navbar.jspf" %> </div>

	<div class="container">

		<div class="d-flex justify-content-between align-items-center">
		 	<h4 class="mt-2">Your TODOs</h4>
		  	<a href="add-todo" class="btn btn-success mt-2 mb-1">Add new todo</a>
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Username</th>
					<th>Title</th>
					<th>Description</th>
					<th>Create date</th>
					<th>Target date</th>
					<th>Status</th>
					<th>last Updated</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.username}</td>
						<td>${todo.title}</td>
						<td>${todo.description}</td>
						<td>${todo.createdAt}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.status}</td>
						<td>${todo.lastUpdated}</td>
						<td>
							<a href="edit-todo?id=${todo.id}" class="btn btn-primary">Edit</a>
							<a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a>
						
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script type="text/javascript" src="webjars/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="webjars/jquery/3.7.1/jquery.min.js"></script>
</body>
</html>