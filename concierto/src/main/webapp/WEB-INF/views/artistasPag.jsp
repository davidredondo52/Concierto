
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
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
				<span class="lead">Listado de pagina </span>
			</div>
			<div class="table-responsive">
				<table class="table table-hover">

					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>&nbsp;</th>
						<sec:authorize access="hasRole('ADMIN')">
							<th></th>
						</sec:authorize>
					</tr>
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
				</table>

			</div>
		</div>
		<!-- Pagination Bar -->
		<div class="container">
			<div class="pagination pagination-centered">
				<ul class="pagination">
					<c:choose>
						<c:when test="${page.firstPage}">
							<li class="disabled"><span>&larr; Primero</span></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="<c:url value ='${pagina.url}/0'/>">&larr; Primero</a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${not pageWrapper.previousPage}">
							<li class="disabled"><span>${pagina.isPreviousPage}&laquo;</span></li>
						</c:when>
						<c:otherwise>
							<li><a href="<c:url value ='${pagina.url}/0'/>">&laquo;</a></li>
						</c:otherwise>
					</c:choose>

					<c:forEach items="${pagina.items}" var="item">
						<c:choose>
							<c:when test="${item.current}">
								<li><span class="active">${item.number}</span></li>
							</c:when>
							<c:otherwise>
								<li><span> <a
										href="<c:url value ='${pagina.url}/${item.number-1}'/>">
											${item.number}</a></span></li>
							</c:otherwise>
						</c:choose>

					</c:forEach>


					<c:choose>
						<c:when test="${pageWrapper.nextPage}">
							<li><a
								href="<c:url value = '${pagina.url}/${item.number+1}'/>"
								title="Go to next page">&raquo;</a></li>
						</c:when>
						<c:otherwise>
							<li class="disabled"><a href="#" title="Go to next page">&raquo;</a></li>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${page.lastPage}">
							<li class="disabled">Last</li>
						</c:when>
						<c:otherwise>
							<li><a
								href="<c:url value = '${pagina.url}/${pagina.totalPages-1}'/>">Último
									&rarr;</a></li>
						</c:otherwise>
					</c:choose>


				</ul>
			</div>
		</div>

		<sec:authorize access="hasRole('ADMIN')">
			<div class="well">
				<a href="<c:url value='/newArtista' />">Alta Nuevo Artista</a>
			</div>
		</sec:authorize>

	</div>
</body>
</html>