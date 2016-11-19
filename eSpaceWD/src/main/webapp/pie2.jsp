<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<spring:url value="/resources/js/plugins/jquery/jquery.min.js" var="jqueryJs" />
<spring:url value="/resources/js/plugins/highcharts/highcharts.js" var="highChartsJs" />
<spring:url value="/resources/js/plugins/highcharts/data.js" var="dataJs" />
<spring:url value="/resources/js/plugins/highcharts/drilldown.js" var="drillDownJs" />
<spring:url value="/resources/js/graphicalReport.js"  var="hcJs" />


   <%--  <script src="${jqueryJs}"></script> --%>



    <script src="${highChartsJs}"></script>
    <script src="${dataJs}"></script>
    <script src="${drillDownJs}"></script>
    <script src="${hcJs}"></script>

</head>
<body>

<br/>
<div id="container" style="min-width: 770px;max-width: 1030px;height: 570px;margin: 0 auto;"></div>


</body>
</html>