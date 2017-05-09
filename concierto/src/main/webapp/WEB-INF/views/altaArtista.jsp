<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />">
<link rel="stylesheet" href='<c:url value="/css/jquery-ui.css"/>'>
<script src="<c:url value='/js/jquery-3.1.1.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script src='<c:url value="/js/jquery-ui-1.12.1/jquery-ui.js"/>'
	type="text/javascript"></script>
<script src='<c:url value="/js/utils.js"/>' type="text/javascript"></script>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Alta Artista</title>
</head>

<body>

	<div class="container">

		<%@include file="menu.jsp"%>
		<div class="panel panel-default">

			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">Registro de Artistas </span>
			</div>
			<div class="table-responsive">
				<form:form method="post" modelAttribute="artista" id="formartista">

					<div class="form-group  input-group-sm input-group-md input-group-lg">
						<label for="nombre">Nombre: </label>
						<form:input path="nombre" id="nombre" cssClass="form-control"/>
						<form:errors path="nombre" cssClass="error" />
					</div>
					<div class="btn-group">
						<a href="<c:url value='/listArtistas' />"
							class="btn btn-primary custom-width">Volver</a>
						<c:choose>
							<c:when test="${edit}">
								<input type="submit" id="enviar" value="Modificación"
									class="btn btn-primary" />
							</c:when>
							<c:otherwise>
								<input type="submit" id="enviar" value="Nuevo"
									class="btn btn-primary" />
							</c:otherwise>
						</c:choose>

					</div>

				</form:form>
				<br /> <br />
			</div>
		</div>
	</div>
</body>


</html>