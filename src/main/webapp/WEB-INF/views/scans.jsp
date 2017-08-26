<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>     
<%@ include file="../tiles/layouts/taglibsAll.jsp"%>

<c:set var="date" value='<%=new java.util.Date()%>' />
<fmt:formatDate type="time"  value="${date}" pattern="yyyy-MM-dd HH:mm:ss" var="date" />

<input type='button' id='hideshow' value='Přidat/Upravit scan' class="margin5px">
	<div id='create-update-form'>
	<form:form method="post" modelAttribute="scan"
		action="/GoF/admin/addScan">
		
		<table>
			<tr>
				<form:hidden path="id" />
				<td><form:label path="player">Hráč:</form:label></td>
				<td><form:select path="player.id">
						<form:options items="${playersList}" itemValue="id"
							itemLabel="nickname" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="fraction">Frakce:</form:label></td>
				<td><form:select path="fraction.id">
						<form:options items="${fractionsList}" itemValue="id"
							itemLabel="name" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="flag">Vlajka:</form:label></td>
				<td><form:select path="flag.id">
						<form:options items="${flagsList}" itemValue="id"
							itemLabel="name" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="fingerprint">Otisk:</form:label></td>
				<td><form:input path="fingerprint" size="30" required="required"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="scanWhen">Oscanováno:</form:label></td>
				<td><form:input path="scanWhen" size="30" id="scanWhen" required="required"></form:input>
				<input type="button" value="now" id="btn-now"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="blue-button margin5px" /></td>
			</tr>
		</table>
	</form:form>
	</div>
	
	<h3>Výpis scanů</h3>
	<c:if test="${!empty listOfScans}">
		<table class="table table-striped my-table">
			<tr>
				<th>Id</th>
				<th>Hráč</th>
				<th>Frakce</th>
				<th>Vlajka</th>
				<th>Otisk</th>
				<th>Oscanováno</th>
				<th>Upravit</th>
				<th>Detail</th>
			</tr>
			<c:forEach items="${listOfScans}" var="scan">
				<tr>
					<td>${scan.id}</td>
					<td>${scan.player.nickname}</td>
					<td>${scan.fraction.name}</td>
					<td>${scan.flag.name}</td>
					<td>${scan.fingerprint}</td>
					<td><fmt:formatDate value="${scan.scanWhen}"
						pattern="dd.MM.yyyy HH:mm:ss" /></td>
					<td><a href="<c:url value='/admin/updateScan/${scan.id}' />">Upravit</a></td>
					<td><a href="<c:url value='/admin/scan/${scan.id}' />">Detail</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

<script>	
	jQuery(document).ready(function(){
        jQuery('#hideshow').on('click', function(event) {        
             jQuery('#create-update-form').toggle('show');
        });
       if (${scan.id != 0})
    	   jQuery('#create-update-form').toggle('show');
      
    	    $('#btn-now').on('click', function () {
    	        var text = $('#scanWhen');
    	        text.val("${date}");    
    	    });
    	
    });
</script>