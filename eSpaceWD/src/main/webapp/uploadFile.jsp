<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload document</title>

<spring:url value="/resources/css/theme-white.css" var="themeCss" />
<spring:url value="/resources/css/jqGrid/jqGridStyle.css" var="jqGridCss" />       
<spring:url value="/resources/js/plugins/jquery/jquery.min.js" var="jqueryJs" />
<spring:url value="/resources/js/plugins/jquery/jquery-ui.min.js"  var="jqueryUiJs" />
<spring:url value="/resources/js/plugins/bootstrap/bootstrap.min.js"  var="bootstrapJs" />
<spring:url value="/resources/js/plugins/bootstrap/bootstrap-file-input.js"  var="bootstrapFileJs" />
<spring:url value="/resources/js/plugins/bootstrap/bootstrap-select.js"  var="bootstrapSelectJs" />
<spring:url value="/resources/js/plugins/tagsinput/jquery.tagsinput.min.js"  var="bootstrapTagsJs" />
<spring:url value="/resources/js/plugins/bootstrap/bootstrap-datepicker.js"  var="datePickerJs" />
<spring:url value="/resources/js/plugins/bootstrap/bootstrap-timepicker.min.js"  var="timePickerJs" />
<spring:url value="/resources/js/plugins/bootstrap/bootstrap-datepicker.js"  var="datePickerJs" />
<spring:url value="/resources/js/plugins/icheck/icheck.min.js"  var="icheckJs" />
<spring:url value="/resources/js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js"  var="mcustomeJs" />
<spring:url value="/resources/js/settings.js"  var="settingsJs" />
<spring:url value="/resources/js/plugins/owl/owl.carousel.min.js"  var="carouselJs" />
<spring:url value="/resources/js/plugins.js"  var="pluginJs" />
<spring:url value="/resources/js/actions.js"  var="actionsJs" />


	<link href="${themeCss}" rel="stylesheet" />	
	<link href="${jqGridCss}" rel="stylesheet" /> 

    <script src="${jqueryJs}"></script>
    <script src="${jqueryUiJs}"></script>
    <script src="${bootstrapJs}"></script>
    <script src="${bootstrapFileJs}"></script>
    <script src="${bootstrapSelectJs}"></script>
    <script src="${bootstrapTagsJs}"></script>
    <script src="${datePickerJs}"></script>
    <script src="${timePickerJs}"></script>
    <script src="${icheckJs}"></script>
    <script src="${mcustomeJs}"></script>
    <script src="${carouselJs}"></script>
    <script src="${settingsJs}"></script>
    <script src="${pluginJs}"></script>
    <script src="${actionsJs}"></script>

	 <script type='text/javascript'>
	 $(document).ready(function(){
		    //This sessionStorage.getItem(); is also a predefined function in javascript
		    //will retrieve session and get the value;
		    var a = sessionStorage.getItem("salesPipeLineId");
		    alert(a);
		    $('#salesPipeLineIdUpload').val(a);
		}); 
	 </script>

</head>
<body>
    <div class="page-container">
 <div class="page-content">
    <div class="page-content-wrap">
	<div class="panel-body">
		<div class="form-group">
			<label class="col-md-4 control-label" style="color: black;">Upload
				Docs : </label>
			<div class="col-md-8">
				<form id="dataUpload" action="uploadFileDoc" method="post"
					enctype="multipart/form-data">
					<input type="text" style="display: none"
						name="salesPipeLineIdUpload" id="salesPipeLineIdUpload" /> <input
						name="file" type="file" />
					<button class="btn btn-primary">Upload</button>
				</form>

			</div>
		</div>
	</div>
	</div>
	</div>
</div>
</body>
</html>