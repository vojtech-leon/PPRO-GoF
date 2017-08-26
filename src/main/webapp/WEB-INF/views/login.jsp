<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../tiles/layouts/taglibsAll.jsp"%>


	<div class="login-box">


		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm' class="form-signin"
		  action="<c:url value='/login' />" method='POST'>

		<table class="login-table">
			<tr>
				<td>Uživatel:</td>
				<td><input type='text' name='username' class="form-control" required autofocus></td>
			</tr>
			<tr>
				<td>Heslo:</td>
				<td><input type='password' name='password' class="form-control" required /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
				  value="Přihlásit" class="btn btn-lg btn-primary btn-block" /></td>
			</tr>
		  </table>

		  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		</form>
	</div>
