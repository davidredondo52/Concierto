<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Artistas</title>

<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />">
<script src="<c:url value='/js/jquery-3.1.1.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
</head>


<body>
	<div class="container">

		<%@include file="menu.jsp"%>
		<div class="panel panel-default">

			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">Listado de Salas </span>
			</div>
			<div class="table-responsive">
				<table class="table table-hover">


					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${salas}" var="sala">
						<tr>
							<td>${sala.id}</td>
							<td>${sala.nombre}</td>

							<td><a href="<c:url value='/edit-${sala.id}-sala' />"
								class="btn btn-success custom-width">Editar</a></td>
							<td><a href="<c:url value='/delete-${sala.id}-sala' />"
								class="btn btn-danger custom-width">Borrar</a></td>
						</tr>
					</c:forEach>
				</table>


			</div>
		</div>



		<sec:authorize access="hasRole('ADMIN')">
			<div class="well">
				<a href="<c:url value='/newSala' />">Alta Nueva Sala</a>
			</div>
		</sec:authorize>
	</div>
</body>
</html>