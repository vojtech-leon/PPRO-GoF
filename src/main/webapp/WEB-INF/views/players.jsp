<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>     
<%@ include file="../tiles/layouts/taglibsAll.jsp"%>

<c:set var="date" value='<%=new java.util.Date()%>' />
<fmt:formatDate type="time"  value="${date}" pattern="yyyy-MM-dd HH:mm:ss" var="date" />

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<input type='button' id='hideshow' value='Přidat/Upravit hráče' class="margin5px">
	<div id='create-update-form'>
		<form:form method="post" modelAttribute="player"
			action="/GoF/admin/addPlayer">

			<form:input type="hidden" path="id"></form:input>
			<table>
				<tr>
					<td><form:label path="username">username:</form:label></td>
					<td><form:input path="username" size="30" maxlength="50" required="required"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="password">password:</form:label></td>
					<td><form:input type="password" path="password" size="30"
							maxlength="50" required="required"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="userId">userId:</form:label></td>
					<td><form:input path="userId" size="30" maxlength="50"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="nickname">nickname:</form:label></td>
					<td><form:input path="nickname" size="30" maxlength="30" required="required"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="fraction">ID_fraction:</form:label></td>
					<td><form:select path="fraction.id">
							<form:options items="${fractionsList}" itemValue="id"
								itemLabel="name" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="changeFractionWhen">changeFractionWhen:</form:label></td>
					<td><form:input path="changeFractionWhen" size="30"
							id="changeFractionWhen" required="required"></form:input>
							
				<input type="button" value="now" id="btn-now"/></td>
				</tr>
				<tr>
					<td><form:label path="score">score:</form:label></td>
					<td><form:input path="score" size="30" maxlength="30" required="required"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="role">role:</form:label></td>
					<td><form:select path="role.id">
							<form:options items="${rolesList}" itemValue="id"
								itemLabel="name" />

						</form:select></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="blue-button margin5px" /></td>
				</tr>
			</table>

		</form:form>
	</div>
</sec:authorize>

<h3>Přehled hráčů</h3>
<c:if test="${!empty listOfPlayers}">
	<table class="table table-striped my-table">
		<tr>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<th>Id</th>
				<th>Username</th>
				<th>Password</th>
				<th>UserId</th>
			</sec:authorize>
			<th>Přezdívka</th>
			<th>Frakce</th>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<th>Frakce změněna</th>
			</sec:authorize>
			<th>Počet bodů</th>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<th>Upravit</th>
				<th>Smazat</th>
			</sec:authorize>
		</tr>
		<c:forEach items="${listOfPlayers}" var="player">
			<tr>
				<sec:authorize access="hasRole('ROLE_ADMIN')">	
					<td>${player.id}</td>
					<td>${player.username}</td>
					<td>${player.password}</td>
					<td>${player.userId}</td>
				</sec:authorize>
				<td>${player.nickname}</td>
				<td>${player.fraction.name}</td>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<td><fmt:formatDate value="${player.changeFractionWhen}"
						pattern="dd.MM.yyyy HH:mm:ss" /></td>
				</sec:authorize>
				<td>${player.score}</td>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<td><a href="<c:url value='/admin/updatePlayer/${player.id}' />">Upravit</a></td>
					<td>
					<c:if test="${empty player.scans and empty player.flags}"><a href="<c:url value='/admin/deletePlayer/${player.id}' />">Smazat</a></c:if>
					</td>
				</sec:authorize>
			</tr>
		</c:forEach>
	</table>
</c:if>
<script>	
	jQuery(document).ready(function(){
        jQuery('#hideshow').on('click', function(event) {        
             jQuery('#create-update-form').toggle('show');
        });
       if (${player.id != 0})
    	   jQuery('#create-update-form').toggle('show');

	    $('#btn-now').on('click', function () {
	        var text = $('#changeFractionWhen');
	        text.val("${date}");    
	    });
    });
</script>