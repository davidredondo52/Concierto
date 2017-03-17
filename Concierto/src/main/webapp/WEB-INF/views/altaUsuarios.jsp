<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Form</title>
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
				<span class="lead">Registro de Usuarios </span>
			</div>
			<div class="table-responsive">
				<form:form method="POST" modelAttribute="user"
					class="form-horizontal">
					<form:input type="hidden" path="id" id="id" />

					<table class="table table-hover">
						<tr class="row">
							<th>Primer Nombre</th>
							<td><form:input type="text" path="firstName" id="firstName"
									class="form-control input-sm" /></td>
							<td>
								<div class="has-error">
									<form:errors path="firstName" class="help-inline" />
								</div>
							</td>
						</tr>


						<tr class="row">
							<th>Apellido</th>
							<td><form:input type="text" path="lastName" id="lastName"
									class="form-control input-sm" /></td>
							<td>
								<div class="has-error">
									<form:errors path="lastName" class="help-inline" />
								</div>
							</td>
						</tr>
						<tr class="row">
							<th>Usuario</th>
							<td><c:choose>
									<c:when test="${edit}">
										<form:input type="text" path="ssoId" id="ssoId"
											class="form-control input-sm" disabled="true" />
									</c:when>
									<c:otherwise>
										<form:input type="text" path="ssoId" id="ssoId"
											class="form-control input-sm" />

									</c:otherwise>
								</c:choose></td>
							<td>
								<div class="has-error">
									<form:errors path="ssoId" class="help-inline" />
								</div>
							</td>
						</tr>
						<tr class="row">
							<th>Password</th>
							<td><form:input type="password" path="password"
									id="password" class="form-control input-sm" /></td>
							<td>
								<div class="has-error">
									<form:errors path="password" class="help-inline" />
								</div>
							</td>
						</tr>

						<tr class="row">
							<th>Email</th>
							<td><form:input type="text" path="email" id="email"
									class="form-control input-sm" /></td>
							<td>
								<div class="has-error">
									<form:errors path="email" class="help-inline" />
								</div>
							</td>
						</tr>

						<tr class="row">
							<td>Roles</td>
							<td><form:select path="userProfiles" items="${roles}"
									multiple="true" itemValue="id" itemLabel="type"
									class="form-control input-sm" /></td>
							<td>
								<div class="has-error">
									<form:errors path="userProfiles" class="help-inline" />
								</div>
							</td>
						</tr>
						<tr class="row">
							<td colspan="3"><c:choose>
									<c:when test="${edit}">
										<input type="submit" value="Update"
											class="btn btn-primary btn-sm" /> or <a
											href="<c:url value='/listUsuarios'/>"
											class="btn btn-primary btn-sm">Cancel</a>
									</c:when>
									<c:otherwise>
										<input type="submit" value="Register"
											class="btn btn-primary btn-sm" /> or <a
											href="<c:url value='/listUsuarios' />"
											class="btn btn-primary btn-sm">Cancel</a>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>