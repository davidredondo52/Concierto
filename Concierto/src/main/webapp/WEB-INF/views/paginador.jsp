<!-- Pagination Bar -->
		<div class="container ">
			<div class="pagination pagination-centered">
				<ul class="pagination">
					<c:choose>
						<c:when test="${pagina.firstPage}">
							<li class="disabled"><span>&larr; Primero</span></li>
						</c:when>
						<c:otherwise>
							<li><a href="<c:url value ='${pagina.url}/0'/>">&larr;
									Primero</a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${not pagina.previousPage}">
							<li class="disabled"><span>&laquo;</span></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="<c:url value ='${pagina.url}/${pagina.currentNumber-2}'/>">&laquo;</a></li>
						</c:otherwise>
					</c:choose>

					<c:forEach items="${pagina.items}" var="item">
						<c:choose>
							<c:when test="${item.current}">
								<li class="active"><a href="#">${item.number}</a></li>
							</c:when>
							<c:otherwise>
								<li> <a
										href="<c:url value ='${pagina.url}/${item.number-1}'/>">
											${item.number}</a></li>
							</c:otherwise>
						</c:choose>

					</c:forEach>


					<c:choose>
						<c:when test="${pagina.nextPage}">
							<li><span><a
								href="<c:url value = '${pagina.url}/${pagina.currentNumber}'/>"
								title="Go to next page">&raquo;</a></span></li>
						</c:when>
						<c:otherwise>
							<li class="disabled"><span><a href="#" title="Go to next page">&raquo;</a></span></li>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${pagina.lastPage}">
							<li class="disabled"><span>Último &rarr;</span></li>
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
