<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../tiles/layouts/taglibsAll.jsp"%>
<html>
<body>
	<h1>Přístup odepřen!</h1>
	<c:choose>
		<c:when test="${empty user}">
		  <h2>Nemáš přístup do této sekce!</h2>
		</c:when>
		<c:otherwise>
		  <h2>Ahoj ${user.name}, nemáš přístup do této sekce!</h2>
		</c:otherwise>
	</c:choose>

</body>
</html>