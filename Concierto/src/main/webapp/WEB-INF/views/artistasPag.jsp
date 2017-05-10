
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html lang="es">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>pagina</title>
<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />">
<link rel="stylesheet" href='<c:url value="/css/jquery-ui.css"/>'>
<script src="<c:url value='/js/jquery-3.1.1.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script src='<c:url value="/js/jquery-ui-1.12.1/jquery-ui.js"/>'
	type="text/javascript"></script>
<script src='<c:url value="/js/utils.js"/>' type="text/javascript"></script>
</head>


<body>
	<div class="container">

		<%@include file="menu.jsp"%>
		<div class="panel panel-default">

			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">Listado de Artistas </span>
			</div>
			<div class="table-responsive">
				<table class="table table-hover">

					<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>&nbsp;</th>
						<sec:authorize access="hasRole('ADMIN')">
							<th></th>
						</sec:authorize>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${pagina.page.content}" var="artista">
						<tr>
							<td>${artista.id}</td>
							<td>${artista.nombre}</td>
							<td><a href="<c:url value='/edit-${artista.id}-artista' />"
								class="btn btn-success custom-width">Editar</a></td>
							<sec:authorize access="hasRole('ADMIN')">
								<td><a
									href="<c:url value='/delete-${artista.id}-artista' />"
									class="btn btn-danger custom-width">Borrar</a></td>
							</sec:authorize>
						</tr>
					</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
		
		<%@include file="paginador.jsp"%>
		<sec:authorize access="hasRole('ADMIN')">
			<div class="well">
				<a href="<c:url value='/newArtista' />">Alta Nuevo Artista</a>
			</div>
		</sec:authorize>

	</div>
</body>
</html>