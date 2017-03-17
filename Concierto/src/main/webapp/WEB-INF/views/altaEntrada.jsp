<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Entrada</title>

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
				<span class="lead">Registro de Entradas </span>
			</div>
			<div class="table-responsive">
				<form:form method="post" modelAttribute="entrada" id="formconcierto">
					<table class="table table-hover">
						<tr>
							<th style="width: 15%; text-align: right;"><label
								for="descripcion">Concierto: </label></th>
							<td><form:input path="concierto.descripcion"
									id="concierto_desc" /> <form:hidden path="concierto.id"
									id="id_concierto" /></td>
							<td><form:errors path="concierto.descripcion"
									cssClass="error" /></td>
						</tr>
						<tr>
							<th style="width: 15%; text-align: right;"><label
								for="PRECIO">Precio Neto: </label></th>
							<td><form:hidden path="id" id="id_entrada" /> <form:input
									path="precio_neto" id="precio_neto" /></td>
							<td><form:errors path="precio_neto" cssClass="error" /></td>
						</tr>

						<tr>
							<th style="width: 15%; text-align: right;"><label for="IVA">IVA:
							</label></th>
							<td> <form:input
									path="iva" id="iva" /></td>
							<td><form:errors path="iva" cssClass="error" /></td>
						</tr>

						<tr id="artistas">
							<th style="width: 15%; text-align: right;"><label for="SGAE">SGAE:

							</label></th>
							<td><form:input path="sgae" id="sgae" /></td>
							<td><form:errors path="sgae" cssClass="error" /></td>
						</tr>

						<tr>
							<td colspan="3">&nbsp;</td>
						</tr>

						<tr>
							<td colspan="3" style="text-align: center;"><a
								href="<c:url value='/listEntradas' />"
								class="btn btn-primary custom-width">Volver</a> <c:choose>
									<c:when test="${edit}">
										<input type="submit" id="enviar" value="Modificación"
											class="btn btn-primary" />
									</c:when>
									<c:otherwise>
										<input type="submit" id="enviar" value="Nuevo"
											class="btn btn-primary" />
									</c:otherwise>
								</c:choose></td>
						</tr>
					</table>

				</form:form>
			</div>
		</div>
	</div>
</body>
<script>
	jQuery(document).ready(
			function() {

				campoAutoCompletado("concierto_desc", "id_concierto",
						"concierto",
						"${pageContext.request.contextPath}/getTags");

			});
</script>

</html>