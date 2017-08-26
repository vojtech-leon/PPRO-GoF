<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@page session="true"%>
<%@ include file="../layouts/taglibsAll.jsp"%>
 
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="Leon Vojtěch">

<title><tiles:getAsString name="title" /></title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  
<link href="<c:url value='${contextPath}/resources/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='${contextPath}/resources/css/styles.css' />" rel="stylesheet"></link>

<script src= "<c:url value='${contextPath}/resources/js/zingchart.min.js' />"></script>
  
	
</head>
<body id="body">
    <div class="container">
        <div class="menu">
            <nav class="navbar navbar-default fixed-top">
                <div class="container-fluid">
                    <tiles:insertAttribute name="menu" />
                </div><!-- /.container-fluid -->
            </nav>
        </div>

        <div class="cover-body-footer">
            <div class="body">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" id="dynamicContent">
                            <tiles:insertAttribute name="body" />
                        </div>
                    </div>
                </div>
            </div>
            <hr/>
            <div class="footer center">
                <footer>
                	<tiles:insertAttribute name="footer" />
                </footer>
            </div>
        </div>
    </div>
                <!-- Bootstrap core JavaScript
            ================================================== -->
                <!-- Placed at the end of the document so the pages load faster -->
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    
 
<script>
    $(function() {
        var current_page_URL = location.href;
        $("a").each(function() {
            if ($(this).attr("href") !== "#") {
                var target_URL = $(this).prop("href");
                if (target_URL == current_page_URL) {
                    $('nav a').parents('li, ul').removeClass('active');
                    $(this).parent('li').addClass('active');
                    return false;
                }
            }
        });
    });
</script>
<script>
    $(function() {
        var current_page_URL = location.href;
        $("a").each(function() {
            if ($(this).attr("href") !== "#") {
                var target_URL = $(this).prop("href");
                if (target_URL == current_page_URL) {
                    $('nav a').removeClass('active');
                    $(this).addClass('active');
                    return false;
                }
            }
        });
    });
</script>
</body>
</html>