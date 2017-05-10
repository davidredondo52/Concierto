

<nav role="navigation" class="navbar navbar-default topnav">

	<!-- Collection of nav links and other content for toggling -->
	<div id="navbarCollapse" class="collapse navbar-collapse">
		<ul class="nav navbar-nav">

			<li class="current_page_item"><a
				href="<c:url value='/listConciertos' />">Conciertos</a></li>
			<li><a href="<c:url value='/listEntradas' />">Entradas</a></li>
			<li><a href="<c:url value='/listArtistasPag/0' />">Artistas </a></li>
			<li><a href="<c:url value='/listSalas' />">Salas </a></li>
			<li><a href="<c:url value='/listPromotores' />">Promotores</a></li>
			<li><a href="<c:url value='/listContactos' />">Contactos </a></li>
			<li><a href="<c:url value='/listUsuarios' />">Usuarios </a></li>

		</ul>
		<ul class="nav navbar-nav navbar-right">
			<!-- li>${loggedinuser}</li-->
			<li><a href="<c:url value="/logout" />">Logout</a></li>
		</ul>
	</div>
</nav>


