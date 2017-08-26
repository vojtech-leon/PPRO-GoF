<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>     
<%@ include file="../tiles/layouts/taglibsAll.jsp"%>

<c:set var="date" value='<%=new java.util.Date()%>' />
<fmt:formatDate type="time"  value="${date}" pattern="yyyy-MM-dd HH:mm:ss" var="date" />

	<input type='button' id='hideshow' value='Přidat/Upravit vlajku' class="margin5px">
	<div id='create-update-form'>
	<form:form method="post" modelAttribute="flag"
		action="/GoF/admin/addFlag">
		<table>
			<tr>
				<form:hidden path="id" />
				<td><form:label path="name">Jméno vlajky:</form:label></td>
				<td><form:input path="name" size="30" maxlength="50" required="required"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="flagWhen">Zabrána:</form:label></td>
				<td><form:input path="flagWhen" size="30" id="flagWhen" required="required"></form:input>

				<input type="button" value="now" id="btn-now"/></td>
			</tr>
			<tr>
				<td><form:label path="fraction">Frakce:</form:label></td>
				<td><form:select path="fraction.id">
						<form:options items="${fractionsList}" itemValue="id"
							itemLabel="name" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="player">Hráč:</form:label></td>
				<td><form:select path="player.id">
						<form:options items="${playersList}" itemValue="id"
							itemLabel="nickname" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="floor">Patro:</form:label></td>
				<td><form:input path="floor" size="30" maxlength="20" required="required"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="x">x:</form:label></td>
				<td><form:input path="x" size="30" maxlength="11" required="required"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="y">y:</form:label></td>
				<td><form:input path="y" size="30" maxlength="11" required="required"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="qrCode">QR kód:</form:label></td>
				<td><form:input path="qrCode" size="30" maxlength="100" required="required"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="taken">Celkem zabrána:</form:label></td>
				<td><form:input path="taken" size="30" maxlength="11" required="required"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="description">Popis:</form:label></td>
				<td><form:input path="description" size="30" maxlength="100" required="required"></form:input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="blue-button margin5px" /></td>
			</tr>
		</table>
	</form:form>
	
	</div>

	<h3>Přehled vlajek</h3>
	<c:if test="${!empty listOfFlags}">
		<table class="table table-striped my-table">
			<tr>
				<th>Id</th>
				<th>Fraction Name</th>
				<th>Zabrána</th>
				<th>Frakce</th>
				<th>Hráč</th>
				<th>Patro</th>
				<th>x</th>
				<th>y</th>
				<th>QR kód</th>
				<th>Celkem zabrána</th>
				<th>Popis vlajky</th>
				<th>Upravit</th>
				<th>Smazat</th>
			</tr>
			<c:forEach items="${listOfFlags}" var="flag">
				<tr>
					<td>${flag.id}</td>
					<td>${flag.name}</td>
					<td><fmt:formatDate value="${flag.flagWhen}"
						pattern="dd.MM.yyyy HH:mm:ss" /></td>
					<td>${flag.fraction.name}</td>
					<td>${flag.player.nickname}</td>
					<td>${flag.floor}</td>
					<td>${flag.x}</td>
					<td>${flag.y}</td>
					<td>${flag.qrCode}</td>
					<td>${flag.taken}</td>
					<td>${flag.description}</td>
					<td><a href="<c:url value='/admin/updateFlag/${flag.id}' />">Upravit</a></td>
					<td>
					<c:if test="${empty flag.scans}"><a href="<c:url value='/admin/deleteFlag/${flag.id}' />">Smazat</a></c:if>
					</td>
					
				</tr>
			</c:forEach>
		</table>
	</c:if>
<script>	
	jQuery(document).ready(function(){
        jQuery('#hideshow').on('click', function(event) {        
             jQuery('#create-update-form').toggle('show');
        });
       if (${flag.id != 0})
    	   jQuery('#create-update-form').toggle('show');

	    $('#btn-now').on('click', function () {
	        var text = $('#flagWhen');
	        text.val("${date}");    
	    });
    });
</script>
