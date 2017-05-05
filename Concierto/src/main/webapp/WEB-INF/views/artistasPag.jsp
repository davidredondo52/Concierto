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
				<span class="lead">Listado of Artistas </span>
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
					<c:forEach items="${artistas.page.content}" var="artista">
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
							<li class="disabled"><span>First</span></li>
						</c:when>
						<c:otherwise>
							<li><a href="${page.url}(page.page=1,page.size=${page.size}">&larr;
									First</a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${not page.hasPreviousPage}">
							<li class="disabled"><span>&laquo;</span></li>
						</c:when>
					</c:choose>

					<c:choose>
						<c:when test="${not page.hasPreviousPage}">

						</c:when>
						<c:otherwise>
							<li><a
								href="${page.url}(page.page=${page.number-1},page.size=${page.size})}"
								title="Go to previous page">&laquo;</a></li>
						</c:otherwise>

					</c:choose>

					<c:forEach items="${page.items}" var="item">
						<c:choose>
							<c:when test="${item.current}">
								<li><span class="active">${item.number}</span></li>
							</c:when>
							<c:otherwise>
								<li><span> <a
										href="@{${page.url}(page.page=${item.number},page.size=${page.size})}">
											${item.number}">1</a>${item.number}</span></li>
							</c:otherwise>
						</c:choose>

					</c:forEach>
					<c:choose>
						<c:when test="${page.hasNextPage}">
							<li><a if="${page.hasNextPage}"
								href="@{${page.url}(page.page=${page.number+1},page.size=${page.size})}"
								title="Go to next page">&raquo;</a></li>
						</c:when>
						<c:otherwise>
							<li class="disabled"></li>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${page.lastPage}">
							<li class="disabled">Last</li>
						</c:when>
						<c:otherwise>
							<li><a
								href="@{${page.url}(page.page=${page.totalPages},page.size=${page.size})}">Last
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