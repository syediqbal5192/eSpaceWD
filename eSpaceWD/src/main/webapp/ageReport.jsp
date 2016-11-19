<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Age Report</title>

<spring:url value="/resources/css/theme-white.css" var="themeCss" />
<spring:url value="/resources/css/jqGrid/jqGridStyle.css" var="jqGridCss" />
<spring:url value="/resources/js/ageReportGrid.js"  var="ageReportGrid" />   

<script type='text/javascript' src="http://trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js"></script>
<script type='text/javascript'  src="http://trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js"></script>

<link href="${themeCss}" rel="stylesheet" />	
	<link href="${jqGridCss}" rel="stylesheet" />
	
    <script src="${ageReportGrid}"></script>

</head>
<body>
		<div>
</div>

</body>
</html>