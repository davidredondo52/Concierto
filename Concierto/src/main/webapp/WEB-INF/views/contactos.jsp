<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
				<span class="lead">Listado of Contactos </span>
			</div>
			<div class="table-responsive">
				<table class="table table-hover">

					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Apellidos</th>
						<th>Mail</th>
						<th>Telefono</th>
						<th>Tipo</th>
						<th>&nbsp;</th>
						<sec:authorize access="hasRole('ADMIN')">
							<th></th>
						</sec:authorize>
					</tr>
					<c:forEach items="${contactos}" var="contacto">
						<tr>
							<td>${contacto.id}</td>
							<td>${contacto.nombre}</td>
							<td>${contacto.apellido1}${contacto.apellido2}</td>
							<td>${contacto.mail}</td>
							<td>${contacto.telefono}</td>
							<td>${contacto.tipoContacto}</td>
							<td><a
								href="<c:url value='/edit-${contacto.id}-contacto' />" class="btn btn-success custom-width">Editar</a></td>
							<sec:authorize access="hasRole('ADMIN')">
								<td><a
									href="<c:url value='/delete-${contacto.id}-contacto' />" class="btn btn-danger custom-width">Borrar</a></td>
							</sec:authorize>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	<sec:authorize access="hasRole('ADMIN')">
		<div class="well"><a
						href="<c:url value='/newContacto' />">Alta Nuevo Contacto</a>
					</div>
	</sec:authorize>
</div>
</body>
</html>