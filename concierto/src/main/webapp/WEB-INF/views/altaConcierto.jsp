<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html lang="es">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Alta Concierto</title>

<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />">
<link rel="stylesheet" href='<c:url value="/css/jquery-ui.css"/>'>
<script src="<c:url value='/js/jquery-3.1.1.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script src='<c:url value="/js/jquery-ui-1.12.1/jquery-ui.js"/>'	type="text/javascript"></script>
<script src='<c:url value="/js/utils.js"/>' type="text/javascript"></script>

</head>


<script>
	//Traducción al español
	$(function($) {
		$("#fecha").datepicker();
		$.datepicker.regional['es'] = {
			closeText : 'Cerrar',
			prevText : '<Ant',
        nextText: 'Sig>',
			currentText : 'Hoy',
			monthNames : [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo',
					'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre',
					'Noviembre', 'Diciembre' ],
			monthNamesShort : [ 'Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
					'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic' ],
			dayNames : [ 'Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves',
					'Viernes', 'Sábado' ],
			dayNamesShort : [ 'Dom', 'Lun', 'Mar', 'Mié', 'Juv', 'Vie', 'Sáb' ],
			dayNamesMin : [ 'Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sá' ],
			weekHeader : 'Sm',
			dateFormat : 'dd/mm/yy',
			firstDay : 1,
			isRTL : false,
			showMonthAfterYear : false,
			yearSuffix : ''
		};
		$.datepicker.setDefaults($.datepicker.regional['es']);

	});
</script>


</head>

<body>

	<div class="container">

		<%@include file="menu.jsp"%>
		<div class="panel panel-default">

			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">Registro de Conciertos </span>
			</div>
			<div class="table-responsive">
				<form:form method="POST" modelAttribute="concierto" enctype="multipart/form-data" >
			
					<table class="table">
						<tr>
							<th style="width: 15%; text-align: right;"><label
								for="descripcion"> <spring:message
										code="concierto.nombre" />:
							</label></th>
							<td><form:input path="descripcion" id="descripcion" /></td>
							<td><form:errors path="descripcion" cssClass="error" /></td>
						</tr>
						<tr>
							<th style="width: 15%; text-align: right;"><label
								for="nombre_sala"><spring:message code="concierto.sala" />:
							</label></th>
							<td><form:hidden path="sala.id" id="id_sala" /> <form:input
									path="sala.nombre" id="nombre_sala" /></td>
							<td><form:errors path="sala.nombre" cssClass="error" /></td>
						</tr>

						<tr>
							<th style="width: 15%; text-align: right;"><label
								for="nombre_promotor"><spring:message
										code="concierto.promotor" />: </label></th>
							<td><form:hidden path="promotor.id" id="id_promotor" /> <form:input
									path="promotor.nombre" id="nombre_promotor" /></td>
							<td><form:errors path="promotor.nombre" cssClass="error" /></td>
						</tr>

						<tr id="artistas">
							<th style="width: 15%; text-align: right;"><label
								for="nombre_artista"><spring:message
										code="concierto.artista" />: <input type="hidden"
									value="concierto.nombreartista" /> <input type="hidden" id="idartista" />

							</label></th>
							<td><input type="hidden" name="artistas.id"
								id="id_artista_0" /> <input type="text" name="artistas.nombre"
								id="nombre_artista_0" />
								<button id="nuevoartista" value="Nuevo Artista" type="button">+</button></td>
							<td><form:select path="artistas"	items="${concierto.artistas}" cssStyle="width:200px"
									id="selectartistas" multiple="true" itemValue="id"
									itemLabel="nombre" /></td>
							<td><form:errors path="artistas" /></td>
						</tr>
						<tr>
							<th style="width: 15%; text-align: right;"><label
								for="fecha"><spring:message code="concierto.fecha" />: </label></th>
							<td><form:input path="fecha" id="fecha" size="10" /></td>
							<td><form:errors path="fecha" cssClass="error" /></td>
						</tr>
						<tr>
							<th style="width: 15%; text-align: right;"><label
								for="fecha"><spring:message code="concierto.contrato" />:
							</label></th>
							<td><form:input type="file" path="fichero" id="fichero" /></td>
							<td><form:errors path="fichero" cssClass="error" /></td>
						</tr>
						<tr>
							<td colspan="3">&nbsp;</td>
						</tr>

						<tr>
							<td colspan="3" style="text-align: center;"><a
								href="<c:url value='/listConciertos' />"
								class="btn btn-primary custom-width"><spring:message
										code="boton.volver" /></a> <c:choose>
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
	jQuery(document)
			.ready(
					function() {

						campoAutoCompletado("nombre_sala", "id_sala", "sala",
								"${pageContext.request.contextPath}/getTags");
						campoAutoCompletado("nombre_promotor", "id_promotor",
								"promotor",
								"${pageContext.request.contextPath}/getTags");
						campoAutoCompletado("nombre_artista_0", "id_artista_0",
								"artista",
								"${pageContext.request.contextPath}/getTags");

						var add_button = $("#nuevoartista"); //Add button ID

						jQuery(add_button)
								.click(
										function(e) {
											//Primero elimino el elemento para evitar duplicados
											$("#selectartistas")
													.find(
															"option[value="
																	+ jQuery(
																			'#id_artista_0')
																			.val()
																	+ "]")
													.remove();
										
											jQuery('#selectartistas')
												.append(
															'<option value="'
																	+ jQuery(
																			"#id_artista_0")
																			.val()
																	+ '" selected="selected">'
																	+ jQuery(
																			"#nombre_artista_0")
																			.val()
																	+ '</option>');
											jQuery('#id_artista_0').val("");
											jQuery("#nombre_artista_0").val("");
										});

					});
</script>

</html>