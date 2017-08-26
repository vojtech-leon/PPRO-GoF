<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>  
<%@ include file="../layouts/taglibsAll.jsp"%>

<!-- Brand and toggle get grouped for better mobile display -->
<div class="navbar-header">
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Game of Flags</a>
</div>

<!-- Collect the nav links, forms, and other content for toggling -->
<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
    	<sec:authorize access="hasRole('ROLE_ADMIN')">
        <li><a href="${pageContext.request.contextPath}/admin/flags">Vlajky</a></li>
        </sec:authorize>
        <sec:authorize access="!hasRole('ROLE_ADMIN')">
        <li><a href="${pageContext.request.contextPath}/flags">Vlajky</a></li>
        </sec:authorize>
        <li><a href="${pageContext.request.contextPath}/fractions">Frakce</a></li>
        <li><a href="${pageContext.request.contextPath}/players">Hráči</a></li>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li><a href="${pageContext.request.contextPath}/admin/scans">Otisky</a></li>
        </sec:authorize>
        
    </ul>


    <ul class="nav navbar-nav navbar-right">
       <c:choose>
		<c:when test="${pageContext.request.userPrincipal.name != null}">
		  	<li><p>Uživatel : ${pageContext.request.userPrincipal.name} </p></li>
			<li><a href="javascript:formSubmit()"> Logout</a></li>
			<c:url value="/logout" var="logoutUrl" />
			<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
		</c:when>
		<c:otherwise>
		  <li><a href="${pageContext.request.contextPath}/login">Přihlásit</a></li>
		</c:otherwise>
	</c:choose>
    </ul>
    
</div><!-- /.navbar-collapse -->

