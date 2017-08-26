<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../tiles/layouts/taglibsAll.jsp"%>


<h3>Přehled vlajek</h3>

<c:if test="${!empty listOfFlags}">


	<div class="row">
		<c:forEach items="${listOfFlags}" var="flag">

			<div class="col-xs-3 thumbnail flags">
				<a href="${pageContext.request.contextPath}/flags/${flag.id}"> <c:if
						test="${flag.fraction.name == 'Red' }">
						<img
							src="<c:url value='${contextPath}/resources/images/Red_flag.png' />"
							class="img-responsive flags-image" alt="Red Flag" />
					</c:if> <c:if test="${flag.fraction.name == 'Blue' }">
						<img
							src="<c:url value='${contextPath}/resources/images/Blue_flag.png' />"
							class="img-responsive flags-image" alt="Blue Flag" />
					</c:if> <c:if test="${flag.fraction.name != 'Red' and 'Blue' }">
						<img
							src="<c:url value='${contextPath}/resources/images/White_flag.png' />"
							class="img-responsive flags-image" alt="Neutral Flag" />
					</c:if>

					<table class="flags-info">
						<tr>
							<th class="center flags-info-td" colspan="2">${flag.name}</th>
						</tr>
						<tr>
							<td class="left flags-info-td">${flag.player.nickname}</td>
							<td class="right flags-info-td">${flag.floor}</td>
						</tr>
					</table>


				</a>
			</div>


		</c:forEach>
	</div>

</c:if>