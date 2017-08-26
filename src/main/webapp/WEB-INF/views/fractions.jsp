<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>     
<%@ include file="../tiles/layouts/taglibsAll.jsp"%>


<sec:authorize access="hasRole('ROLE_ADMIN')">
	<div id='create-update-form'>
		<form:form method="post" modelAttribute="fraction"
			action="/GoF/admin/updateFraction">

			<form:input type="hidden" path="id"></form:input>
			<table>
				<tr>
					<td><form:label path="name">Jméno frakce:</form:label></td>
					<td><form:input path="name" size="30" maxlength="50" required="required"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="description">popis:</form:label></td>
					<td><form:input path="description" size="30" maxlength="500"></form:input></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="blue-button" /></td>
				</tr>
			</table>

		</form:form>
	</div>
</sec:authorize>

<h3>Přehled frakcí</h3>
	<c:if test="${!empty listOfFractions}">
		<table class="table table-striped my-table">
			<tr>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
				<th>Id</th>
				</sec:authorize>
				<th>Název frakce</th>
				<th>Popis frakce</th>
				<th>Počet vlajek</th>
				<th>Počet hráčů</th>
				<th>Celkový počet bodů</th>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
				<th>Upravit</th>
			</sec:authorize>
			</tr>
		<c:forEach items="${listOfFractions}" var="fraction">
			<tr>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
				<td>${fraction.id}</td>
				</sec:authorize>
				<td>${fraction.name}</td>
				<td>${fraction.description}</td>
				<c:set var="countFlags" value="0" scope="page" />
				<c:forEach items="${fraction.flags}" var="flags">
					<c:set var="countFlags" value="${countFlags + 1}" scope="page" />
				</c:forEach>
				<td>${countFlags}</td>
				<c:set var="countPlayers" value="0" scope="page" />
				<c:forEach items="${fraction.players}" var="players">
				<c:set var="countPlayers" value="${countPlayers + 1}" scope="page" />
				</c:forEach>
				<td>${countPlayers}</td>
				
				<c:set var="countTotalPoints" value="0" scope="page" />
				<c:forEach items="${listOfScans}" var="scans">
				<c:if test="${scans.fraction.id == fraction.id}">
				<c:set var="countTotalPoints" value="${countTotalPoints + 1}" scope="page" />				
				</c:if>
				</c:forEach>
				<td>${countTotalPoints}</td>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<td><a href="<c:url value='/admin/updateFraction/${fraction.id}' />">Upravit</a></td>
				</sec:authorize>
			</tr>
		</c:forEach>
	</table>
	</c:if>


<script>	
	jQuery(document).ready(function(){
       if (${fraction.id != 0})
    	   jQuery('#create-update-form').toggle('show');
    });
</script>