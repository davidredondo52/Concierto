<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />">
<script src="<c:url value='/js/jquery-3.1.1.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
<title>Alta</title>
</head>
<body>
	<div class="container">
		<%@include file="menu.jsp"%>
		<div class="panel panel-default">

			<div class="alert alert-success lead">${success}</div>
		</div>


		<div class="well">
			 <a href="<c:url value='/listConciertos' />">Inicio</a>
		</div>
	</div>
</body>

</html>