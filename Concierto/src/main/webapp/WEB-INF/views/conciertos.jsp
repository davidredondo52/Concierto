<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Conciertos</title>

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
				<span class="lead">Listado of Conciertos </span>
			</div>
			<div class="table-responsive">
				<table class="table table-hover">

					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Fecha</th>
						<th>Sala</th>
						<th>Promotor</th>
						<th></th>
						<sec:authorize access="hasRole('ADMIN')">
							<th></th>
						</sec:authorize>
					</tr>
					<c:forEach items="${conciertos}" var="concierto">
						<tr>
							<td>${concierto.id}</td>
							<td>${concierto.descripcion}</td>
							<td><fmt:formatDate type="date" value="${concierto.fecha}" /></td>
							<td>${concierto.sala.nombre}</td>
							<td>${concierto.promotor.nombre}</td>
							<td><a
								href="<c:url value='/edit-${concierto.id}-concierto' />"
								class="btn btn-success custom-width">Editar</a></td>
							<sec:authorize access="hasRole('ADMIN')">
								<td><a
									href="<c:url value='/delete-${concierto.id}-concierto' />"
									class="btn btn-danger custom-width">Borrar</a></td>
							</sec:authorize>
						</tr>
					</c:forEach>
				</table>
				<br />



			</div>
		</div>
	
	<sec:authorize access="hasRole('ADMIN')">
		<div class="well">
			<a href="<c:url value='/newConcierto' />">Añadir Nuevo Concierto</a>
		</div>
	</sec:authorize>
</div>
</body>
</html>