<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>  
<%@ include file="../layouts/taglibsAll.jsp"%>
<jsp:useBean id="date" class="java.util.Date" />
<p>&copy; <fmt:formatDate value="${date}" pattern="yyyy" /> - Leon Vojtěch</p>

