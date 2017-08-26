<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../tiles/layouts/taglibsAll.jsp"%>

	<h3>Detail vlajky</h3>

<div>
	<!-- obal detailu veci-->
	<div class="row">
		<div class="col-xs-6 col-sm-6 col-md-6 col-lg-8">
			<dl>
				<dt>Název vlajky:</dt>
				<dd>${flagDetails.name}</dd>
				<dt>Frakce:</dt>
				<dd>${flagDetails.fraction.name}</dd>
				<dt>Vlastněna:</dt>
				<dd>${flagDetails.player.nickname}</dd>
				<dt>Zabrána:</dt>
				<dd>
					<fmt:formatDate value="${flagDetails.flagWhen}"
						pattern="dd.MM.yyyy HH:mm:ss" />
				</dd>
				<dt>Patro:</dt>
				<dd>${flagDetails.floor}</dd>
				<dt>Celkem zabrána:</dt>
				<dd>${flagDetails.taken}x</dd>
				<dt>Popis:</dt>
				<dd>${flagDetails.description}</dd>
			</dl>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6 col-lg-4">

			<c:if test="${flagDetails.fraction.name == 'Red' }">
				<img
					src="<c:url value='${contextPath}/resources/images/Red_flag.png' />"
					class="img-responsive flags-image" alt="Red Flag" />
			</c:if>
			<c:if test="${flagDetails.fraction.name == 'Blue' }">
				<img
					src="<c:url value='${contextPath}/resources/images/Blue_flag.png' />"
					class="img-responsive flags-image" alt="Blue flag" />
			</c:if>
			<c:if test="${flagDetails.fraction.name != 'Red' and 'Blue' }">
				<img
					src="<c:url value='${contextPath}/resources/images/White_flag.png' />"
					class="img-responsive flags-image" alt="Neutral Flag" />
			</c:if>
		</div>
	</div>
</div>


