<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Todo | TO DO App</title>
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="webjars/bootstrap/5.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css">
</head>
<body>
	<div> <%@ include file="/common/navbar.jspf" %> </div>
	
	<div class="container">
		<h3 class="mt-2">To Do Details</h3>
		<hr>
		<form:form method="post" modelAttribute="todo">
			<form:input path="id" type="hidden"/>
			<form:input path="username" type="hidden"/>
			
			<p>Title</p>
			<form:input path="title" htmlEscape="true" required="required"/>
			<c:if test="${not empty titleAlert}">
				<div class="alert alert-warning" role="alert">
					<form:errors path="title"/>
				</div>
			</c:if>
			
			
			<p>Description</p>
			<form:input path="description" htmlEscape="true" required="required"/>
			<c:if test="${not empty descriptionAlert}">
				<div class="alert alert-warning" role="alert">
					<form:errors path="description"/>
				</div>
			</c:if>
			
			
			<p>Target date</p>
			<form:input path="targetDate" cssClass="datepick"/>
			<form:input path="createdAt" type="hidden"/>
			<br><br>
			<p>Completed 
			<form:checkbox path="status"/> </p>
			<form:input path="lastUpdated" type="hidden"/>
			
			<br>
			<input type="submit" value="Save" class="btn btn-success mt-2">
		</form:form>
	</div>
	
	<script type="text/javascript" src="webjars/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="webjars/jquery/3.7.1/jquery.min.js"></script>
	<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript">
	    $('.datepick').datepicker({
	        format: 'dd/mm/yyyy'
	    });
    </script>
</body>
</html>