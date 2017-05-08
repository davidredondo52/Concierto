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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
					<table class="table table-hover">
						<tr>
							<td colspan="3">&nbsp;</td>
						</tr>
						<tr>
							<th style="width: 15%; text-align: right;"><label
								for="descripcion">Nombre: </label></th>
							<th><form:input path="nombre" id="nombre" /></th>
							<th><form:errors path="nombre" cssClass="error" /></th>
						</tr>

						<tr>
							<td colspan="3">&nbsp;</td>
						</tr>

						<tr>
							<td  colspan="3" style="text-align: center;"><a
								href="<c:url value='/listArtistas' />"
								class="btn btn-primary custom-width">Volver</a><c:choose>
									<c:when test="${edit}">
										<input type="submit" id="enviar" value="Modificaci�n" class="btn btn-primary"/>
									</c:when>
									<c:otherwise>
										<input type="submit" id="enviar" value="Nuevo" class="btn btn-primary"/>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</table>

				</form:form>
				<br /> <br />
			</div>
		</div>
	</div>
</body>


</html>