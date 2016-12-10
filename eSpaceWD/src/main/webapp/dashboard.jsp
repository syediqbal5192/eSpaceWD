<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>

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
 <spring:url value="/resources/js/warehouseGrid.js"  var="warehouseGridJs" />   
 <spring:url value="/resources/js/readinessGrid.js"  var="readinessGridJs" />  
 <spring:url value="/resources/js/salesPipeLineGrid.js"  var="salesPipeLineGridJs" /> 
 <spring:url value="/resources/js/readinessTemplateGrid.js"  var="readinessTemplateGridJs" /> 
 <spring:url value="/resources/js/ageReportGrid.js"  var="ageReportGridJs" /> 
 <spring:url value="/resources/js/readinessTemplateGrid.js"  var="readinessTemplateGridJS" /> 
 <spring:url value="/resources/js/inlineGrid.js"  var="inlineGrid" /> 
 <spring:url value="/resources/js/inlineEditGrid.js"  var="inlineEditGrid" /> 
 <spring:url value="/resources/js/areaReportGrid.js"  var="areaReportGrid" /> 
 <spring:url value="/resources/js/clientGrid.js"  var="clientReportGrid" /> 
 <spring:url value="/resources/js/customerGrid.js"  var="customerGrid" /> 
 <spring:url value="/resources/js/readinessTemplateReportGrid.js"  var="readinessTemplateReportGridJS" /> 
 
 <spring:url value="/resources/js/plugins/noty/jquery.noty.js"  var="notyJs" /> 
 <spring:url value="/resources/js/plugins/noty/layouts/topRight.js"  var="topCenterJs" />  
 <spring:url value="/resources/js/plugins/noty/themes/default.js"  var="themeNotyJs" /> 
 <spring:url value="/resources/js/plugins/maskedinput/jquery.maskedinput.min.js"  var="maskedJs" /> 

 <spring:url value="/resources/js/plugins/validationengine/languages/jquery.validationEngine-en.js"  var="validationEngineJs" />  
 <spring:url value="/resources/js/plugins/validationengine/jquery.validationEngine.js"  var="validationEngineJs2" /> 
 <spring:url value="/resources/js/plugins/jquery-validation/jquery.validate.js"  var="validateJs" /> 
 <spring:url value="/resources/img/SPARSH.PNG"  var="logoImg" /> 



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
    <script src="${warehouseGridJs}"></script>
    <script src="${readinessGridJs}"></script>
    <script src="${salesPipeLineGridJs}"></script>
    <script src="${readinessTemplateGridJs}"></script>
    <script src="${ageReportGridJs}"></script>
    <script src="${areaReportGrid}"></script>
    <script src="${clientReportGrid}"></script>
    <script src="${readinessTemplateGridJS}"></script>    
    <script src="${readinessTemplateReportGridJS}"></script> 
    <script src="${inlineGrid}"></script>
    <script src="${inlineEditGrid}"></script>
    <script src="${notyJs}"></script>
    <script src="${topCenterJs}"></script>
    <script src="${themeNotyJs}"></script>
    <script src="${maskedJs}"></script>
    <script src="${validationEngineJs}"></script>
    <script src="${validationEngineJs2}"></script>
    <script src="${validateJs}"></script>

    <script src="${customerGrid}"></script>
<script type='text/javascript' src="http://trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js"></script>
<script type='text/javascript'  src="http://trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.min.js"></script>

		
 <script type='text/javascript'>
 var readinessTemplateValues = [];
 var warehouseNameValues = [];
 var validatorWarehouse;
 var validatorCustomer;
 var validatorUpdate;
 function dashboardValues()
	{
		$.ajax({
		type:'POST',
		encoding : "UTF-8",
		url : "dashboardIconInfo",
	    dataType: 'json',
	    success: function(data) {
	    	
	    	
	    	
	    	var a= data.totalWarehouse;
	    	var b = data.totalSpaceUtilizedCount;
	    	var c = data.totalClientsCount;
	    	var d = data.totalSpaceAvailableCount;
	    	
	    	    $('#totalWarehouse').val(a);
				$('#totalSpaceUtilizedCount').val(parseInt(b));
				$('#totalClientsCount').val(c);
				$('#totalSpaceAvailableCount').val(d);
	    }
	});
}
 
 
 
 function loadClientNames()
 {

	 $("#clientRTName").empty();
	 
	 $.ajax({
			type:'GET',
			encoding : "UTF-8",
			url : "listRTClientName",
			data : "",
		    dataType: 'json',
		    success: function( json ) {
		        $.each(json, function(i, value) {
		        	
		        	$('#clientRTName').append($('<option>').text(value.companyName).attr('value', value.salesPipeLineId));

		        	readinessTemplateValues.push(value.readiness_element_name);
		        	
		        });
		    }
		});
	 
 }


 function loadWarehouseName()
 {

	 $("#clientWarehouseFilter").empty();
	 
	 $.ajax({
			type:'GET',
			encoding : "UTF-8",
			url : "listWarehouse",
			data : "",
		    dataType: 'json',
		    success: function( json ) {
		        $.each(json, function(i, value) {
		        	
		        	$('#clientWarehouseFilter').append($('<option>').text(value.warehouse_name).attr('value', value.warehouse_id));

		        	warehouseNameValues.push(value.warehouse_name);
		        	
		        });
		    }
		});
	 
 }

 
 

 function loadReadinessElementName()
 {

	 //$("#clientRTName").empty();
	 
	 $.ajax({
			type:'GET',
			encoding : "UTF-8",
			url : "listReadinessElementName",
			data : "",
		    dataType: 'json',
		    success: function( json ) {
		        $.each(json, function(i, value) {
		        	
		        	readinessTemplateValues.push(value.readiness_element_name);
		        	
		        });
		    }
		});
	 
 }

 
 
 function validateSalesPipeLine()
 {
	 
	 
     
    
	 var jvalidate = $("#jvalidate").validate({
         ignore: [],
         rules: {                                            
        	 estimatedFloorBuiltupArea: {
                         required: true
                        
                 },
                 estimatedFloorCarpetArea: {
                         required: true
                 },
                 
                 estimatedRackCarpetArea: {
                         required: true
                 },
                 estimatedRackCarpetArea: {
                         required: true
                 },
                 estimatedStartDate: {
                         required: true,
                         date: true
                 },
                 estimatedRevenue: {
                         required: true
                        
                 }
             }                                        
         });            
	 
	 
 }
 
 
$(document).ready(function(){
	
   
	
	dashboardValues();
	loadClientNames();
	loadReadinessElementName();
	loadWarehouseName();

	$('#warehouseLink').css( 'cursor', 'pointer' );
	$('#customerLink').css( 'cursor', 'pointer' );
	$('#dashboardLink').css( 'cursor', 'pointer' );
	$('#salesPipeLineLink').css( 'cursor', 'pointer' );
	$('#readinessLink').css( 'cursor', 'pointer' );
	$('#graphicalReportLink').css( 'cursor', 'pointer' );
	$('#tabularReportLink').css( 'cursor', 'pointer' );
	$('#areaReportLink').css( 'cursor', 'pointer' );
	$('#clientReportLink').css( 'cursor', 'pointer' );
	$('#readinessReportLink').css( 'cursor', 'pointer' );
	$('#settingLink').css( 'cursor', 'pointer' );
	$('#logoutLink').css( 'cursor', 'pointer' );
	$('#cancelReadinessOrder').css( 'cursor', 'pointer' );
	
	
	$("#logoutLink").click(function(){
		 $("#logoutDiv").fadeIn(500);
		 
		 
		});
	graphicalChartDiv
	

	$("#graphicalReportLink").click(function(){
         $("#graphicalChartDiv").fadeIn(500);
		 $("#dashboardDiv").hide(500);
		 $("#salesPipeLineDiv").hide();
		 $('#warehouseDiv').hide();
		 $('#areaReportDiv').hide();
		 $('#clientReportDiv').hide();
		 $('#readinessTemplateReportDiv').hide();
		 $('#reportDiv').hide();

		 $("#customerDiv").hide();
		 $("#viewCustomerDiv").hide();
		});

	
	$("#dashboardLink").click(function(){
		 $("#dashboardDiv").fadeIn(500);
		 $("#salesPipeLineDiv").hide();
		 $('#warehouseDiv').hide();
		 $('#areaReportDiv').hide();
		 $('#clientReportDiv').hide();
		 $('#readinessTemplateReportDiv').hide(); 
		 $("#graphicalChartDiv").hide();
		 $('#reportDiv').hide();
		 $('#readinessDiv').hide();

		 $("#customerDiv").hide();
		 $("#viewCustomerDiv").hide();
		});

	$("#tabularReportLink").click(function(){
		$('#reportDiv').show();
		$('#areaReportDiv').hide();
		 $("#warehouseDiv").hide();
		 $('#clientReportDiv').hide();
		 $("#salesPipeLineDiv").hide();
		 $("#readinessDiv").hide();
		 $('#dashboardDiv').hide();
		 $('#addTitle').hide();
		 $('#updateTitle').hide();
		 $('#addWarehouse').show();
		 $('#saveWarehouseInfo').hide();
		 $('#cancelWarehouseInfo').hide();
		 $('#updateWarehouseInfo').hide();
		 $('#areaReportDiv').hide();
		 $('#readinessTemplateReportDiv').hide();
		 $("#graphicalChartDiv").hide();

		 $("#customerDiv").hide();
		 $("#viewCustomerDiv").hide();	
		 
		 
		 $.ajax({
				type:'GET',
				encoding : "UTF-8",
				url : "reloadFunctionality",
				success: function(json) {
			 
			    	var statusWorkCondition = 'wIP';
			    	$("#grid5").jqGrid('setGridParam', { 
			            postData: {"statusWorkCondition":statusWorkCondition }
			     }).trigger('reloadGrid'); 
					    	
			    	
		  	        
			      
			    }
			});
		 
		 
		});
	
	
	
	
	$("#areaReportLink").click(function(){
		$('#areaReportDiv').show();
		$('#clientReportDiv').hide();
		 $('#reportDiv').hide();
		 $("#warehouseDiv").hide();
		 $("#salesPipeLineDiv").hide();
		 $("#readinessDiv").hide();
		 $('#dashboardDiv').hide();
		 $('#addTitle').hide();
		 $('#updateTitle').hide();
		 $('#addWarehouse').show();
		 $('#saveWarehouseInfo').hide();
		 $('#cancelWarehouseInfo').hide();
		 $('#updateWarehouseInfo').hide();
		 $('#readinessTemplateReportDiv').hide();
		 $("#graphicalChartDiv").hide();
		 $("#areaGrid").trigger("reloadGrid");


		 $("#customerDiv").hide();
		 $("#viewCustomerDiv").hide();
		 
		});
	
	$("#clientReportLink").click(function(){
		loadWarehouseName();
		$('#clientReportDiv').show();
		$('#areaReportDiv').hide();
		 $('#reportDiv').hide();
		 $("#warehouseDiv").hide();
		 $("#salesPipeLineDiv").hide();
		 $("#readinessDiv").hide();
		 $('#dashboardDiv').hide();
		 $('#addTitle').hide();
		 $('#updateTitle').hide();
		 $('#addWarehouse').show();
		 $('#saveWarehouseInfo').hide();
		 $('#cancelWarehouseInfo').hide();
		 $('#updateWarehouseInfo').hide();
		 $('#readinessTemplateReportDiv').hide();
		 $("#graphicalChartDiv").hide();
		 $("#clientGrid").trigger("reloadGrid");


		 $("#customerDiv").hide();
		 $("#viewCustomerDiv").hide();
		});
	
	
	$("#readinessReportLink").click(function(){

		//$('#reportRTDiv').show();
		$('#readinessTemplateReportDiv').show();
		loadClientNames();
		$('#clientReportDiv').hide();
		$('#areaReportDiv').hide();
		$('#reportDiv').hide();
		 $("#warehouseDiv").hide();
		 $("#salesPipeLineDiv").hide();
		 $("#readinessDiv").hide();
		 $("#customerDiv").hide();
		 $("#viewCustomerDiv").hide();
		 $('#dashboardDiv').hide();
		 $('#addTitle').hide();
		 $('#updateTitle').hide();
		 $('#addWarehouse').show();
		 $('#saveWarehouseInfo').hide();
		 $('#cancelWarehouseInfo').hide();
		 $('#updateWarehouseInfo').hide();
		 $('#areaReportDiv').hide();
		 $("#graphicalChartDiv").hide();
		 $("#readinessTemplateReportGrid").trigger("reloadGrid");
		});
	
	
	
	
	
	$("#warehouseLink").click(function(){
		 $("#warehouseDiv").fadeIn(500);
		 $("#viewWarehouseDiv").fadeIn(500);
		 $("#salesPipeLineDiv").hide();
		 $('#reportDiv').hide();
		 $("#readinessDiv").hide();
		 $('#dashboardDiv').hide();
		 $('#addTitle').hide();
		 $('#updateTitle').hide();
		 $('#addWarehouse').show();
		 $('#saveWarehouseInfo').hide();
		 $('#cancelWarehouseInfo').hide();
		 $('#updateWarehouseInfo').hide();
		 $('#areaReportDiv').hide();
		 $('#clientReportDiv').hide();
		 $("#graphicalChartDiv").hide();
		 $('#readinessTemplateReportDiv').hide();

		 $("#customerDiv").hide();
		 $("#viewCustomerDiv").hide();
		 
		});

	$("#customerLink").click(function(){
		 $("#customerDiv").fadeIn(500);
		 $("#viewCustomerDiv").fadeIn(500);
		 $("#warehouseDiv").hide();
		 $("#viewWarehouseDiv").hide();
		 $("#salesPipeLineDiv").hide();
		 $('#reportDiv').hide();
		 $("#readinessDiv").hide();
		 $('#dashboardDiv').hide();
		 $('#addCustomerTitle').hide();
		 $('#updateCustomerTitle').hide();
		 $('#addCustomer').show();
		 $('#saveCustomerInfo').hide();
		 $('#cancelCustomerInfo').hide();
		 $('#updateCustomerInfo').hide();
		 $('#areaReportDiv').hide();
		 $('#clientReportDiv').hide();
		 $("#graphicalChartDiv").hide();
		 $('#readinessTemplateReportDiv').hide();
		});
	
	$("#readinessLink").click(function(){
		 $("#readinessDiv").fadeIn(500);
		 $("#viewReadinessDiv").fadeIn(500);
		 $("#salesPipeLineDiv").hide();
		 $('#dashboardDiv').hide();
		 $('#warehouseDiv').hide();
		 $('#reportDiv').hide();
		 $('#addRETitle').hide();
		 $('#updateRETitle').hide();
		 $('#addReadiness').show();
		 $('#saveReadinessInfo').hide();
		 $('#cancelReadinessInfo').hide();
		 $('#updateReadinessInfo').hide();
		 $('#areaReportDiv').hide();
		 $('#clientReportDiv').hide();
		 $("#graphicalChartDiv").hide();
		 $('#readinessTemplateReportDiv').hide();

		 $("#customerDiv").hide();
		 $("#viewCustomerDiv").hide();
		});
	

/* 	$("#readinessTemplateLink").click(function(){
		 $("#readinessTemplateDiv").fadeIn(500);
		 $("#viewReadinessTemplateDiv").fadeIn(500);
		 $("#salesPipeLineDiv").hide();
		 $('#dashboardDiv').hide();
		 $('#warehouseDiv').hide();
		 $('#readinessDiv').hide();
		});*/
	 
	$("#salesPipeLineLink").click(function(){
			 $("#salesPipeLineDiv").fadeIn(500);
			 $("#viewSalesPipeLineDiv").fadeIn(500);
			 $("#dashboardDiv").hide();
			 $('#warehouseDiv').hide();	 
			 $("#readinessDiv").hide();
			 $('#reportDiv').hide();
			 $('#addSPLTitle').hide();
			 $('#updateSPLTitle').hide();
			 $('#addSalesPipeLine').show();
			 $('#saveSalesPipeLineInfo').hide();
			 $('#cancelSalesPipeLineInfo').hide();
			 $('#updateSalesPipeLineInfo').hide(); 
			 $("#addSalesPipeLineDiv").hide();
			 $('#areaReportDiv').hide();
			 $('#clientReportDiv').hide();
			 $("#graphicalChartDiv").hide();
			 $('#readinessTemplateReportDiv').hide();		

			 $("#customerDiv").hide();
			 $("#viewCustomerDiv").hide();	 
			});
	
	/* Add Warehouse
	 */
	$("#addWarehouse").click(function(){
		 $("#addWarehouseDiv").fadeIn();
		 $('#addTitle').fadeIn();
		 $('#addWarehouse').hide();
		 $('#saveWarehouseInfo').show();
		 $('#cancelWarehouseInfo').show();
		 $('#updateWarehouseInfo').hide();
		 $("#viewWarehouseDiv").hide();
		 $('#dashboardDiv').hide();
		 $('#updateTitle').hide();
			$("#warehouseName").val("");
			$("#floorBuiltupArea").val("");
			$("#floorCarpetArea").val("");
			$("#rackBuiltupArea").val("");
			$("#palette_positions").val("");
			$("#totalNumberOfDocks").val("");
			$("#floorCarpetAreaRef").val("0");
			$("#rackBuiltupAreaRef").val("0");

	validatorWarehouse.resetForm();
			
			$("#warehouseName").css("border-color","#d7d7d7");
			$("#floorBuiltupArea").css("border-color","#d7d7d7");
			$("#floorCarpetArea").css("border-color","#d7d7d7");
			$("#rackBuiltupArea").css("border-color","#d7d7d7");
			$("#palette_positions").css("border-color","#d7d7d7");
			$("#totalNumberOfDocks").css("border-color","#d7d7d7");
		 
		});
	
	
	/* Add Readiness
	 */
	$("#addReadiness").click(function(){
		 $("#addReadinessDiv").fadeIn();
		 $('#addRETitle').fadeIn();
		 $('#saveReadinessInfo').show();
		 $('#cancelReadinessInfo').show();
		 $('#addReadiness').hide();
		 $('#updateReadinessInfo').hide();
		 $("#viewReadinessDiv").hide();
		 $('#dashboardDiv').hide();
		 $('#updateRETitle').hide();
			$("#readinessElementName").val("");		 
		 
		});
	
	
	/* Add Readiness Template
	 */
	$("#addReadinessTemplate").click(function(){
		 $("#addReadinessTemplateDiv").fadeIn();
		 $('#addRTLTitle').fadeIn();
		 $('#addReadinessTemplate').hide();
		 $('#saveReadinessTemplate').show();
		 $('#cancelReadinessTemplate').show();
		 $('#updateReadinessTemplate').hide();
		 $("#viewReadinessTemplateDiv").hide();
		 $('#dashboardDiv').hide();
		 $('#updateRTLTitle').hide();
		 $('#customerNameRT').empty();
         $('#readinessElementNameRT').empty();
	    	
		/* 	$("#warehouseName").val("");
			$("#floorBuiltupArea").val("");
			$("#floorCarpetArea").val("");
			$("#rackBuiltupArea").val("");
			$("#rackCarpetArea").val(""); */
		
			
			//Populate Dropdown with Custmer Name

			$.ajax({
				type:'GET',
				encoding : "UTF-8",
				url : "listSalesPipeLine",
				data : "",
			    dataType: 'json',
			    success: function( json ) {
			    	
			        $.each(json, function(i, value) {
			        	$('#customerNameRT').append($('<option>').text(value.customerName).attr('value', value.salesPipeLineId));
			        });
			    }
			});
			
			/* 
			Populate Droupdown with Readiness Element */
			
			$.ajax({
				type:'GET',
				encoding : "UTF-8",
				url : "listReadinessElements",
				data : "",
			    dataType: 'json',
			    success: function( json ) {
			    	
			    	    $.each(json, function(i, value) {
			        	
			        	$('#readinessElementNameRT').append($('<option>').text(value.readiness_element_name).attr('value', value.re_id));
			        });
			    }
			});

		 
		});
	
	
	
	/* Add SalesPipeLine
	 */
	
	$("#addSalesPipeLine").click(function(){
		
		
		 $("#addSalesPipeLineDiv").fadeIn();
		 $('#addSPLTitle').fadeIn();
		 $('#saveSalesPipeLineInfo').show();
		 $('#cancelSalesPipeLineInfo').show();
		 $('#addSalesPipeLine').hide();
		 $('#updateReadinessInfo').hide();
		 $("#viewSalesPipeLineDiv").hide();
		 $('#dashboardDiv').hide();
		 $('#updateSPLTitle').hide();
		 $('#updateSalesPipeLineInfo').hide();
		 
		
		 
		 
		 
		 $('#allocatedWarehouse').empty();
		 $("#customerName").empty();   
		 $("#customerType").empty();   
			$("#availableFloor").val("");
			$("#availableCarpet").val("");
			$("#estimatedFloorBuiltupArea").val("");
			$("#estimatedFloorCarpetArea").val("");
			$("#estimatedRackBuiltupArea").val("");
			$("#estimated_palette_positions").val("");
			$("#estimatedRevenue").val("");
			$("#estimatedStartDate").val("");
			$("#allocatedWarehouse").val("");
			/* $("#statusWork").empty(); */
			$("#actualFloorBuiltupArea").val("");
			$("#actualFloorCarpetArea").val("");
			$("#actualRackBuiltupArea").val("");
			$("#actual_palette_positions").val("");
			$("#actualRevenue").val("");
			$("#actualStartDate").val("");
			$("#remark").val("");

				$("#statusWork").val("wIP");
			 	$("#actualFloorBuiltupArea").attr('disabled','disabled');
				$("#actualFloorCarpetArea").attr('disabled','disabled');
				$("#actualRackBuiltupArea").attr('disabled','disabled');
				$("#actual_palette_positions").attr('disabled','disabled');
				$("#actualRevenue").attr('disabled','disabled');
				$("#actualStartDate").attr('disabled','disabled');
			
				$('#confirmed').hide();
			
			//Populate Dropdown

			$.ajax({
				type:'GET',
				encoding : "UTF-8",
				url : "listWarehouse",
				data : "",
			    dataType: 'json',
			    success: function( json ) {
			        $.each(json, function(i, value) {
			        	
			        	$('#allocatedWarehouse').append($('<option>').text(value.warehouse_name).attr('value', value.warehouse_id));
			        });
			    }
			});

			$.ajax({
				type:'GET',
				encoding : "UTF-8",
				url : "listCustomer",
				data : "",
			    dataType: 'json',
			    success: function( json ) {
			        $.each(json, function(i, value) {
			        	
			        	$('#customerName').append($('<option>').text(value.customer_name).attr('value', value.customer_id));
			        });
			    }
			});

		

			var customerType = [  			{
									"customer_type" : "Sub Lease",						
				},{
					"customer_type" : "3PL",
					},{
						"customer_type" : "Temporary",
						},{
							"customer_type" : "4PL",
							}];
			$.each(customerType, function(i, value) {
	        	
	        	$('#customerType').append($('<option>').text(value.customer_type).attr('value', value.customer_type));
	        });

			
			validator.resetForm();
			validatorUpdate.resetForm();
			
			$("#customerName").css("border-color","#d7d7d7");
			$("#estimatedFloorBuiltupArea").css("border-color","#d7d7d7");
			$("#estimatedFloorCarpetArea").css("border-color","#d7d7d7");
			$("#estimatedRevenue").css("border-color","#d7d7d7");
			$("#estimatedStartDate").css("border-color","#d7d7d7");
			$("#estimatedRackBuiltupArea").css("border-color","#d7d7d7");
			$("#estimated_palette_positions").css("border-color","#d7d7d7");
			$("#remark").css("border-color","#d7d7d7");
			$("#actualFloorBuiltupArea").css("border-color","#d7d7d7");
			$("#actualFloorCarpetArea").css("border-color","#d7d7d7");
			$("#actualRevenue").css("border-color","#d7d7d7");
			$("#actualRackBuiltupArea").css("border-color","#d7d7d7");
			$("#actual_palette_positions").css("border-color","#d7d7d7");	
		    $("#actualStartDate").css("border-color","#d7d7d7");

		    $('#statusWork').empty();
			$("#statusWork").append('<option value="wIP">Work In Progress</option>');
		 
		});
	
	$("#addCustomer").click(function(){


				 $("#addCustomerDiv").fadeIn();
				 $('#addCustomerTitle').fadeIn();
				 $('#saveCustomerInfo').show();
				 $('#cancelCustomerInfo').show();
				 $('#addCustomer').hide();
				 $('#updateReadinessInfo').hide();
				 $("#viewCustomerDiv").hide();
				 $('#dashboardDiv').hide();
				 $('#updateCustomerTitle').hide();
				 $('#updateCustomerInfo').hide();
				 
					$("#customer_name").val("");
					$("#contact_name_1").val("");
					$("#contact_number_1").val("");
					$("#contact_email_id_1").val("");
					$("#contact_name_2").val("");
					$("#contact_number_2").val("");
					$("#contact_email_id_2").val("");

					validatorCustomer.resetForm();
					$("#customer_name").css("border-color","#d7d7d7");
					$("#contact_number_1").css("border-color","#d7d7d7");
					$("#contact_name_1").css("border-color","#d7d7d7");
					$("#contact_email_id_1").css("border-color","#d7d7d7");
					$("#contact_number_2").css("border-color","#d7d7d7");
					$("#contact_name_2").css("border-color","#d7d7d7");
					$("#contact_email_id_2").css("border-color","#d7d7d7");

				
		});
	
	//Populate Client 
	
	
	$('#statusFilterSPL').change(function () {
		   var status = $('#statusFilterSPL').val();
		   
		    $('#statusFilterSPL').prop("selected", true);
			  
		    $("#grid2").jqGrid('setGridParam', { 
	            postData: {"status":status }
	     }).trigger('reloadGrid'); 
  	
			   
		   		} );



	
	
//Populate warehouse available area based on Warehouse Selected id= #allocatedWarehouse
	
	$('#allocatedWarehouse').change(function () {
	   var selectedWarehouseId = $('#allocatedWarehouse').val();
	   var $txt = $("#allocatedWarehouse option:selected").text();
	   //alert(txt);
	   $('#allocatedWarehouseId').val(selectedWarehouseId);
	// Re-select the original options
	    $('#allocatedWarehouse').prop("selected", true);
		  
	  // alert($('#allocatedWarehouseId').val());
	   
		$.ajax({
			type:'GET',
			encoding : "UTF-8",
			url : "getWarehouseAreaById",
			data : 
			{
				selectedWarehouseId : selectedWarehouseId,
			},
		    dataType: 'json',
		    success: function( json ) {
		        $.each(json, function(i, value) {
		        	
		        	 var valueOfFieldFloor = value.available_floor_carpet_area;
		        	 var valueOfFieldCarpet =value.available_rack_carpet_area;
		        	 $("#availableFloor").val(valueOfFieldFloor);
		        	 $("#availableCarpet").val(valueOfFieldCarpet);
		        });
		    }
		}); 
	   
		//Populate Dropdown

	
		
		
	   
	} );
	
	
	
	
	 $('#statusWork').change(function(){
		/*  $('.actualData').hide();
         $('#' + $(this).val()).fadeIn(500);
        */
        
        var currentStatus = $(this).val();
       
		var confirmed = "confirmed";
		if(currentStatus == confirmed){


			    $("#actualFloorBuiltupArea").prop('disabled', false);
				$("#actualFloorCarpetArea").prop('disabled', false);
				$("#actualRackBuiltupArea").prop('disabled', false);
				$("#actual_palette_positions").prop('disabled', false);
				$("#actualRevenue").prop('disabled', false);
				$("#actualStartDate").prop('disabled', false);
	
			}
		else
			{
			
			  $("#actualFloorBuiltupArea").attr('disabled','disabled');
				$("#actualFloorCarpetArea").attr('disabled','disabled');
				$("#actualRackBuiltupArea").attr('disabled','disabled');
				$("#actual_palette_positions").attr('disabled','disabled');
				$("#actualRevenue").attr('disabled','disabled');
				$("#actualStartDate").attr('disabled','disabled');
			
			}
         
     /* 	var estimatedFloorBuiltupArea = $("#estimatedFloorBuiltupArea").val();
		var estimatedFloorCarpetArea = $("#estimatedFloorCarpetArea").val();
		var estimatedRackBuiltupArea = $("#estimatedRackBuiltupArea").val();
		var estimatedRackCarpetArea = $("#estimatedRackCarpetArea").val();
		var estimatedStartDate = $("#estimatedStartDate").val();
     	
		
		
		 $("#actualFloorBuiltupArea").val(estimatedFloorBuiltupArea);
			$("#actualFloorCarpetArea").val(estimatedFloorCarpetArea);
			$("#actualRackBuiltupArea").val(estimatedRackBuiltupArea);
			$("#actualRackCarpetArea").val(estimatedRackCarpetArea);
			$("#actualStartDate").val(estimatedStartDate); */
     });
	
	/* Carpet Area calculations */
	
	
	
	
	$('#floorCarpetArea').change(function () {
	   var floorCarpetArea =  parseInt($('#floorCarpetArea').val());
	   var floorBuiltupArea = parseInt((floorCarpetArea*1.25));
	   $("#floorBuiltupArea").val(floorBuiltupArea);

/* 		var floorRef = parseInt($("#floorCarpetAreaRef").val());

		if(floorRef<floorCarpetArea)
			{
			var  availableWarehouseFloor =  floorCarpetArea - floorRef;

			$('#availableWarehouseFloor').val(availableWarehouseFloor);
			$('#floorCarpetErrorLabel').text("");
			$('#floorCarpetErrorLabel').hide();
			
			}
		else
			{
			$('#floorCarpetErrorLabel').text("Sorry Cannot Reduce the value");
			$('#floorCarpetErrorLabel').show();
			}
		
 */	   
	});
	
	
	$('#floorBuiltupArea').change(function () {
	   var floorBuiltupArea = $('#floorBuiltupArea').val();
	   if(floorBuiltupArea>0){
		   var floorCarpetArea = parseInt((floorBuiltupArea/1.25));
		   $("#floorCarpetArea").val(floorCarpetArea);
		  }
	  });


	

	$('#palette_positions').change(function () {
		   var palette_positions = $('#palette_positions').val();
		   var rackBuiltupArea = parseInt((palette_positions*25));
		   $("#rackBuiltupArea").val(rackBuiltupArea);
		});



	$('#estimated_palette_positions').change(function () {
		   var estimated_palette_positions = $('#estimated_palette_positions').val();
		   var rackBuiltupArea = parseInt((estimated_palette_positions*25));
		   $("#estimatedRackBuiltupArea").val(rackBuiltupArea);
		});

	$('#actual_palette_positions').change(function () {
		   var actual_palette_positions = $('#actual_palette_positions').val();
		   var rackBuiltupArea = parseInt((actual_palette_positions*25));
		   $("#actualRackBuiltupArea").val(rackBuiltupArea);
		});
	
		$('#estimatedFloorCarpetArea').change(function () {
			   var estimatedFloorCarpetArea = $('#estimatedFloorCarpetArea').val();
			   
			   var estimatedFloorBuiltupArea = parseInt((estimatedFloorCarpetArea*1.25));
			   $("#estimatedFloorBuiltupArea").val(estimatedFloorBuiltupArea);
			   
			});
	
		$('#estimatedFloorBuiltupArea').change(function () {
			   var estimatedFloorBuiltupArea = $('#estimatedFloorBuiltupArea').val();
			   if(estimatedFloorBuiltupArea>0){
				   var estimatedFloorCarpetArea = parseInt((estimatedFloorBuiltupArea/1.25));
				   $("#estimatedFloorCarpetArea").val(estimatedFloorCarpetArea);
				  }
			  });
		
		
		
		
		$('#actualFloorCarpetArea').change(function () {
			   var actualFloorCarpetArea = $('#actualFloorCarpetArea').val();
			   
			   var actualFloorBuiltupArea = parseInt((actualFloorCarpetArea*1.25));
			   $("#actualFloorBuiltupArea").val(actualFloorBuiltupArea);
			   
			});
		

		$('#actualFloorBuiltupArea').change(function () {
		   var actualFloorBuiltupArea = $('#actualFloorBuiltupArea').val();
		   if(actualFloorBuiltupArea>0){
			   var actualFloorCarpetArea = parseInt((actualFloorBuiltupArea/1.25));
			   $("#actualFloorCarpetArea").val(actualFloorCarpetArea);
			  }
		  });
		
		
	
	/* Collects n Passes Warehouse Information from UI to the Warehouse Contoller
	 */
	 jQuery.validator.addMethod("floorAreaCheck", function (value, element) {
				
		        var floorBuiltupArea =  parseInt($('#floorBuiltupArea').val());
		   		var floorRef = parseInt($("#floorCarpetAreaRef").val());

			if(floorRef<=floorBuiltupArea)
				{
				var  availableWarehouseFloor =  floorBuiltupArea - floorRef;

				$('#availableWarehouseFloor').val(availableWarehouseFloor);

				return true;
				
				}
			else
				{
				return false;
				}
			
	    }, "You can't reduce the area");


		
	 jQuery.validator.addMethod("rackAreaCheck", function (value, element) {
			
		 var rackBuiltupArea =  parseInt($('#rackBuiltupArea').val());
		  
			var rackRef = parseInt($("#rackBuiltupAreaRef").val());
			
			if(rackRef<=rackBuiltupArea)
				{
				var  availableWarehouseRack =  rackBuiltupArea - rackRef;
				console.log(availableWarehouseRack);
				$('#availableWarehouseRack').val(availableWarehouseRack);

				return true;
				
				}
			else{

				return false;
								}	 
		
 }, "You can't reduce the area");


	  validatorWarehouse = $("#warehouseForm").validate({
	        rules: {
	        	warehouseName :"required",
				floorBuiltupArea : {
					required : true,
					floorAreaCheck : true
					},
				floorCarpetArea : "required",
				rackBuiltupArea : {
					required : true,
					rackAreaCheck : true
					},
				palette_positions : "required",
				totalNumberOfDocks : {
	        	      required: true,
	        	      digits: true
	        	    }
	        },
	        messages: {
	        	warehouseName :"Please specify Warehouse Name",
	        	floorCarpetArea : "What is the Built-up area",
				palette_positions : "Whats the Carpet Area",
				
	           
	        }
	    });

	 
	$("#saveWarehouseInfo").click(function(){

		if($("#warehouseForm").valid())
		 {
		
		 $("#addWarehouseDiv").hide();
		 $("#viewWarehouseDiv").fadeIn();
		 $('#dashboardDiv').hide();
		 $('#updateWarehouseInfo').hide();
		 $("#addTitle").hide();
		 $("#updateTitle").hide();
		 $("#addWarehouse").fadeIn();
		 $('#cancelWarehouseInfo').hide();
		 $('#updateWarehouseInfo').hide();
		 $('#saveWarehouseInfo').hide();
		 
		var warehouseName = $("#warehouseName").val();
		var floorBuiltupArea = $("#floorBuiltupArea").val();
		var floorCarpetArea = $("#floorCarpetArea").val();
		var rackBuiltupArea = $("#rackBuiltupArea").val();
		var palette_positions = $("#palette_positions").val();
		var totalNumberOfDocks = $("#totalNumberOfDocks").val();
		
		
		$.ajax({
			
			type : "POST",
			encoding : "UTF-8",
			url : "addWarehouse",
			datatype :'json', 
			data : {
				warehouseName : warehouseName,
				floorBuiltupArea : floorBuiltupArea,
				floorCarpetArea : floorCarpetArea,
				rackBuiltupArea : rackBuiltupArea,
				palette_positions : palette_positions,
				totalNumberOfDocks : totalNumberOfDocks,
				  },
			success : function(data) {
				console.log("SUCCESS: ", data);
				$("#grid").trigger("reloadGrid");

				validatorWarehouse.resetForm();
				$("#warehouseName").css("border-color","#d7d7d7");
				$("#floorBuiltupArea").css("border-color","#d7d7d7");
				$("#floorCarpetArea").css("border-color","#d7d7d7");
				$("#rackBuiltupArea").css("border-color","#d7d7d7");
				$("#palette_positions").css("border-color","#d7d7d7");
				$("#totalNumberOfDocks").css("border-color","#d7d7d7");
				
				
			},
			error : function(e) {
				console.log("ERROR: ", e);
			
			}
		});	
		 }
     
		 			 
		});

	 
	
	/* Collects n Passes Warehouse Information from UI to the Warehouse Contoller
	 */
	 
	$("#updateWarehouseInfo").click(function(){

		if($("#warehouseForm").valid())
		 {
		
		$("#addWarehouseDiv").hide();
		 $("#viewWarehouseDiv").fadeIn();
		 $('#dashboardDiv').hide();
		 
		 
		 $("#addTitle").hide();
		 $("#updateTitle").hide();
		 $("#addWarehouse").fadeIn();
		 $('#cancelWarehouseInfo').hide();
		 $('#updateWarehouseInfo').hide();
		 $('#saveWarehouseInfo').hide();
		 
		var warehouseId = $("#warehouseId").val();
		var warehouseName = $("#warehouseName").val();
		var floorBuiltupArea = $("#floorBuiltupArea").val();
		var floorCarpetArea = $("#floorCarpetArea").val();
		var rackBuiltupArea = $("#rackBuiltupArea").val();
		var palette_positions = $("#palette_positions").val();
		var totalNumberOfDocks = $("#totalNumberOfDocks").val();
		var availableWarehouseFloor = $('#availableWarehouseFloor').val();
		var availableWarehouseRack = $('#availableWarehouseRack').val();
		
		$.ajax({
			
			type : "POST",
			encoding : "UTF-8",
			url : "updateWarehouse",
			datatype :'json', 
			data : {
				warehouseId : warehouseId,
				warehouseName : warehouseName,
				floorBuiltupArea : floorBuiltupArea,
				floorCarpetArea : floorCarpetArea,
				rackBuiltupArea : rackBuiltupArea,
				palette_positions : palette_positions,
				totalNumberOfDocks : totalNumberOfDocks,
				availableWarehouseFloor : availableWarehouseFloor,
				availableWarehouseRack : availableWarehouseRack,
			   },
			success : function(data) {
				console.log("SUCCESS: ", data);
				$("#grid").trigger("reloadGrid");
				validatorWarehouse.resetForm();
				$("#warehouseName").css("border-color","#d7d7d7");
				$("#floorBuiltupArea").css("border-color","#d7d7d7");
				$("#floorCarpetArea").css("border-color","#d7d7d7");
				$("#rackBuiltupArea").css("border-color","#d7d7d7");
				$("#palette_positions").css("border-color","#d7d7d7");
				$("#totalNumberOfDocks").css("border-color","#d7d7d7");
				var msg="";
				// $("#warehouseDivCount").html(msg).fadeIn();
			},
			error : function(e) {
				console.log("ERROR: ", e);
			
			}
		});				 
		 }
		});
	

	//Cancel Operation of Adding Warehouse
	
	$("#cancelWarehouseInfo").click(function(){
		 $("#addWarehouseDiv").hide();
		 $("#viewWarehouseDiv").fadeIn();
		 $("#addTitle").hide();
		 $("#updateTitle").hide();
		 $("#addWarehouse").fadeIn();
		 $('#cancelWarehouseInfo').hide();
		 $('#updateWarehouseInfo').hide();
		 $('#saveWarehouseInfo').hide();

			validatorWarehouse.resetForm();
			
			$("#warehouseName").css("border-color","#d7d7d7");
			$("#floorBuiltupArea").css("border-color","#d7d7d7");
			$("#floorCarpetArea").css("border-color","#d7d7d7");
			$("#rackBuiltupArea").css("border-color","#d7d7d7");
			$("#palette_positions").css("border-color","#d7d7d7");
			$("#totalNumberOfDocks").css("border-color","#d7d7d7");
		 
		});


		
	
	/* Collects n Passes Warehouse Information from UI to the Warehouse Contoller
	 */


	  validatorCustomer = $("#myFormCustomer").validate({
	        rules: {
	        	customer_name :"required",
				contact_name_1 : "required",
				contact_number_1 : "required",
				contact_email_id_1 : {
				      required: true,
				      email: true
				    },
				contact_name_2 : "required",
				contact_number_2 : "required",
				contact_email_id_2 :{
				      required: true,
				      email: true
				    },
				
	        },
	        messages: {
	        	customer_name :"required",
				contact_name_1 : "required",
				contact_number_1 : "required",
				contact_name_2 : "required",
				contact_number_2 : "required",
				
	           
	        }
	    });

	 
	$("#saveCustomerInfo").click(function(){

		if($("#myFormCustomer").valid())
		 {
		
		 $("#addCustomerDiv").hide();
		 $("#viewCustomerDiv").fadeIn();
		 $('#dashboardDiv').hide();
		 $('#updateCustomerInfo').hide();
		 $("#addCustomerTitle").hide();
		 $("#updateCustomerTitle").hide();
		 $("#addCustomer").fadeIn();
		 $('#cancelCustomerInfo').hide();
		 $('#updateCustomerInfo').hide();
		 $('#saveCustomerInfo').hide();
		 
		    var customer_name = $("#customer_name").val();
		    var contact_name_1 = $("#contact_name_1").val();
		    var contact_number_1 = $("#contact_number_1").val();
		    var contact_email_id_1 = $("#contact_email_id_1").val();
		    var contact_name_2 = $("#contact_name_2").val();
		    var contact_number_2 = $("#contact_number_2").val();
		    var contact_email_id_2 = $("#contact_email_id_2").val();
		
		
		$.ajax({
			
			type : "POST",
			encoding : "UTF-8",
			url : "addCustomer",
			datatype :'json', 
			data : {
				customer_name : customer_name,
				contact_name_1 : contact_name_1,
				contact_number_1 : contact_number_1,
				contact_email_id_1 : contact_email_id_1,
				contact_name_2 : contact_name_2,
				contact_number_2 : contact_number_2,
				contact_email_id_2 : contact_email_id_2,
				  },
			success : function(data) {
				console.log("SUCCESS: ", data);
				$("#customerGrid").trigger("reloadGrid");

				validatorCustomer.resetForm();
				
				$("#customer_name").css("border-color","#d7d7d7");
				$("#contact_number_1").css("border-color","#d7d7d7");
				$("#contact_name_1").css("border-color","#d7d7d7");
				$("#contact_email_id_1").css("border-color","#d7d7d7");
				$("#contact_number_2").css("border-color","#d7d7d7");
				$("#contact_name_2").css("border-color","#d7d7d7");
				$("#contact_email_id_2").css("border-color","#d7d7d7");
				
				
			},
			error : function(e) {
				console.log("ERROR: ", e);
			
			}
		});	
		 }
     
		 			 
		});

	 
	
	/* Collects n Passes Warehouse Information from UI to the Warehouse Contoller
	 */
	 
	$("#updateCustomerInfo").click(function(){

		if($("#myFormCustomer").valid())
		 {
		
		$("#addCustomerDiv").hide();
		 $("#viewCustomerDiv").fadeIn();
		 $('#dashboardDiv').hide();
		 
		 
		 $("#addCustomerTitle").hide();
		 $("#updateCustomerTitle").hide();
		 $("#addCustomer").fadeIn();
		 $('#cancelCustomerInfo').hide();
		 $('#updateCustomerInfo').hide();
		 $('#saveCustomerInfo').hide();
		 


		    var customer_id = $("#customer_id").val();
		    var customer_name = $("#customer_name").val();
		    var contact_name_1 = $("#contact_name_1").val();
		    var contact_number_1 = $("#contact_number_1").val();
		    var contact_email_id_1 = $("#contact_email_id_1").val();
		    var contact_name_2 = $("#contact_name_2").val();
		    var contact_number_2 = $("#contact_number_2").val();
		    var contact_email_id_2 = $("#contact_email_id_2").val();
		
		
		$.ajax({
			
			type : "POST",
			encoding : "UTF-8",
			url : "updateCustomer",
			datatype :'json', 
			data : {

				customer_id : customer_id,
				customer_name : customer_name,
				contact_name_1 : contact_name_1,
				contact_number_1 : contact_number_1,
				contact_email_id_1 : contact_email_id_1,
				contact_name_2 : contact_name_2,
				contact_number_2 : contact_number_2,
				contact_email_id_2 : contact_email_id_2,
			   },
			success : function(data) {
				console.log("SUCCESS: ", data);
				console.log("SUCCESS: ", data);
				$("#customerGrid").trigger("reloadGrid");

				validatorCustomer.resetForm();
				
				$("#customer_name").css("border-color","#d7d7d7");
				$("#contact_number_1").css("border-color","#d7d7d7");
				$("#contact_name_1").css("border-color","#d7d7d7");
				$("#contact_email_id_1").css("border-color","#d7d7d7");
				$("#contact_number_2").css("border-color","#d7d7d7");
				$("#contact_name_2").css("border-color","#d7d7d7");
				$("#contact_email_id_2").css("border-color","#d7d7d7");
			/* 	
				var msg="";
				 $("#warehouseDivCount").html(msg).fadeIn().delay(2000); */
			},
			error : function(e) {
				console.log("ERROR: ", e);
			
			}
		});				 
		 }
		});
	
	

	
	$("#cancelCustomerInfo").click(function(){
		 $("#addCustomerDiv").hide();
		 $("#viewCustomerDiv").fadeIn();
		 $("#addCustomerTitle").hide();
		 $("#updateCustomerTitle").hide();
		 $("#addCustomer").fadeIn();
		 $('#cancelCustomerInfo').hide();
		 $('#updateCustomerInfo').hide();
		 $('#saveCustomerInfo').hide();

			validatorCustomer.resetForm();
			
			$("#customer_name").css("border-color","#d7d7d7");
			$("#contact_number_1").css("border-color","#d7d7d7");
			$("#contact_name_1").css("border-color","#d7d7d7");
			$("#contact_email_id_1").css("border-color","#d7d7d7");
			$("#contact_number_2").css("border-color","#d7d7d7");
			$("#contact_name_2").css("border-color","#d7d7d7");
			$("#contact_email_id_2").css("border-color","#d7d7d7");
			
		});

	/* Collects n Passes Warehouse Information from UI to the Warehouse Contoller
	 */
	 $("#readinessForm").validate({
	        rules: {
	        	readinessElementName: "required",
	        },
	        messages: {
	        	readinessElementName: "Please specify Readines name",
	           
	        }
	    });

	 
	$("#saveReadinessInfo").click(function(){

		if($("#readinessForm").valid())
		 {

		 $("#addReadinessDiv").hide();
		 $("#viewReadinessDiv").fadeIn();
		 $('#dashboardDiv').hide();
		 $('#updateReadinessInfo').hide();
		
		 $("#addRETitle").hide();
		 $("#updateRETitle").hide();
	
		 $("#addReadiness").fadeIn();
		 $('#cancelReadinessInfo').hide();
		 $('#updateReadinessInfo').hide();
		 $('#saveReadinessInfo').hide();
		 
		var readinessElementName = $("#readinessElementName").val();
		
		$.ajax({
			
			type : "POST",
			encoding : "UTF-8",
			url : "addReadinessElement",
			datatype :'json', 
			data : {
				readinessElementName : readinessElementName,
	        		        	
	            },
			success : function(data) {
				console.log("SUCCESS: ", data);
				$("#grid3").trigger("reloadGrid");
			},
			error : function(e) {
				console.log("ERROR: ", e);
			
			}
		});				
		 } 
		});
	
	
	/* Collects n Passes Warehouse Information from UI to the Warehouse Contoller
	 */
	 
	$("#updateReadinessInfo").click(function(){

			if($("#readinessForm").valid())
		 {
		
		$("#addReadinessDiv").hide();
		 $("#viewReadinessDiv").fadeIn();
		 $('#dashboardDiv').hide();
		 $('#updateReadinessInfo').hide();
		 $("#addRETitle").hide();
		 $("#updateRETitle").hide();
	
		 $("#addReadiness").fadeIn();
		 $('#cancelReadinessInfo').hide();
		 $('#updateReadinessInfo').hide();
		 $('#saveReadinessInfo').hide();
		 
		 
		 var readinessId = $("#readinessId").val(); 
		var readinessElementName = $("#readinessElementName").val();
		

		
		$.ajax({
			
			type : "POST",
			encoding : "UTF-8",
			url : "updateReadiness",
			datatype :'json', 
			data : {
				readinessId : readinessId,
				readinessElementName : readinessElementName,
	        		        	
	            },
			success : function(data) {
				console.log("SUCCESS: ", data);
				$("#grid3").trigger("reloadGrid");
			},
			error : function(e) {
				console.log("ERROR: ", e);
			
			}
		});				 
		 }
		});
	

	//Cancel Operation of Adding Warehouse
	
	$("#cancelReadinessInfo").click(function(){
		 $("#addReadinessDiv").hide();
		 $("#viewReadinessDiv").fadeIn();
		 $("#addRETitle").hide();
		 $("#updateRETitle").hide();
	
		 $("#addReadiness").fadeIn();
		 $('#cancelReadinessInfo').hide();
		 $('#updateReadinessInfo').hide();
		 $('#saveReadinessInfo').hide();
		 
		 
		});

	
	
	
	/* Collects n Passes Warehouse Information from UI to the Warehouse Contoller
	 */
	 
	$("#saveReadinessTemplate").click(function(){
		 $("#addReadinessTemplateDiv").hide();
		 $("#viewReadinessTemplateDiv").fadeIn();
		 $('#dashboardDiv').hide();
		 $('#updateReadinessTemplateInfo').hide();
		 
		 $("#addRTLTitle").hide();
		 $("#updateRTLTitle").hide();
		 $("#addReadinessTemplate").fadeIn();
		 $('#cancelReadinessTemplate').hide();
		 $('#updateReadinessTemplate').hide();
		 $('#saveReadinessTemplate').hide();
		
		$.ajax({
			
			type : "POST",
			encoding : "UTF-8",
			url : "addReadinessTemplate",
			datatype :'json', 
			data : {
				warehouseName : warehouseName,
				floorBuiltupArea : floorBuiltupArea,
				floorCarpetArea : floorCarpetArea,
				rackBuiltupArea : rackBuiltupArea,
				palette_positions : palette_positions,
	        		        	
	            },
			success : function(data) {
				console.log("SUCCESS: ", data);
				$("#grid4").trigger("reloadGrid");
			},
			error : function(e) {
				console.log("ERROR: ", e);
			
			}
		});				 
		});
	
	
	/* Collects n Passes Warehouse Information from UI to the Warehouse Contoller
	 */
	 
	$("#updateReadinessTemplate").click(function(){
		
		$("#addReadinessTemplateDiv").hide();
		 $("#viewReadinessTemplateDiv").fadeIn();
		 $('#dashboardDiv').hide();
		 $('#updateReadinessTemplateInfo').hide();
		 
		 $("#addRTLTitle").hide();
		 $("#updateRTLTitle").hide();
		 $("#addReadinessTemplate").fadeIn();
		 $('#cancelReadinessTemplate').hide();
		 $('#updateReadinessTemplate').hide();
		 $('#saveReadinessTemplate').hide();
		 
		 
		var warehouseId = $("#warehouseId").val();
		var warehouseName = $("#warehouseName").val();
		var floorBuiltupArea = $("#floorBuiltupArea").val();
		var floorCarpetArea = $("#floorCarpetArea").val();
		var rackBuiltupArea = $("#rackBuiltupArea").val();
		var palette_positions = $("#palette_positions").val();
		

		
		$.ajax({
			
			type : "POST",
			encoding : "UTF-8",
			url : "updateReadinessTemplate",
			datatype :'json', 
			data : {
				warehouseId : warehouseId,
				warehouseName : warehouseName,
				floorBuiltupArea : floorBuiltupArea,
				floorCarpetArea : floorCarpetArea,
				rackBuiltupArea : rackBuiltupArea,
				palette_positions : palette_positions,
	        		        	
	            },
			success : function(data) {
				console.log("SUCCESS: ", data);
				$("#grid4").trigger("reloadGrid");
			},
			error : function(e) {
				console.log("ERROR: ", e);
			
			}
		});				 
		});
	

	//Cancel Operation of Adding Warehouse
	
	$("#cancelReadinessTemplate").click(function(){
		 $("#addReadinessTemplateDiv").hide();
		 $("#viewReadinessTemplateDiv").fadeIn();
		 $("#addRTLTitle").hide();
		 $("#updateRTLTitle").hide();
		 $("#addReadinessTemplate").fadeIn();
		 $('#cancelReadinessTemplate').hide();
		 $('#updateReadinessTemplate').hide();
		 $('#saveReadinessTemplate').hide();
		 
		});

	
	
	/* Collects n Passes SalesPipeLine Information from UI to the SalesPipeLine Contoller
	 */


	 var validator = $("#myForm").validate({
	        rules: {
	        	customerName: "required",
	        	estimatedFloorBuiltupArea : "required",
	        	estimatedFloorCarpetArea: "required",
	        	estimatedRackBuiltupArea : "required",
	        	estimated_palette_positions: "required",
	        	estimatedRevenue : "required",
	        	estimatedStartDate: "required",
	    		remark : "required",
	    	    
	        },
	        messages: {
	        	customerName: "Please specify customer name",
	            estimatedFloorBuiltupArea : "How much is the Floor built-up area ?",
	            estimatedFloorCarpetArea: "How much is the Floor carpet area ?",
	            estimatedRackBuiltupArea: "How much is the Rack built-up area ?",
	            estimated_palette_positions : "How much is the Rack carpet area ?",
	            estimatedRevenue: "What amount of revenue is expected ?",
	            estimatedStartDate : "By when is this project expected to begin?",
	    		remark : "Please enter Remark",
	    	    
	        }
	    });

	    

	


	$("#saveSalesPipeLineInfo").click(function(){
		
		if($("#myForm").valid())
		 {
		 var empty="";
		var customerName = $("#customerName").val();
		var customerType = $("#customerType").val();
		var estimatedFloorBuiltupArea = $("#estimatedFloorBuiltupArea").val();
		var estimatedFloorCarpetArea = $("#estimatedFloorCarpetArea").val();
		var estimatedRackBuiltupArea = $("#estimatedRackBuiltupArea").val();
		var estimated_palette_positions = $("#estimated_palette_positions").val();
		var estimatedRevenue = $("#estimatedRevenue").val();
		var estimatedStartDate = $("#estimatedStartDate").val();
		var allocatedWarehouse = $("#allocatedWarehouseId").val();
		var statusWork = $("#statusWork").val();
		var remark = $("#remark").val();
		
       
		
			$.ajax({
				
				type : "POST",
				encoding : "UTF-8",
				url : "addSalesPipeLine",
				datatype :'json', 
				data : {
					customerName : customerName,
					customerType : customerType,
					estimatedFloorBuiltupArea : estimatedFloorBuiltupArea,
					estimatedFloorCarpetArea : estimatedFloorCarpetArea,
					estimatedRackBuiltupArea : estimatedRackBuiltupArea,
					estimated_palette_positions : estimated_palette_positions,
					estimatedStartDate : estimatedStartDate,
					estimatedRevenue : estimatedRevenue,
					allocatedWarehouse : allocatedWarehouse,
					statusWork : statusWork,
					remark : remark,
						        	
		            },
				success : function(data) {
					console.log("SUCCESS: ", data);
					
					 $("#addSalesPipeLineDiv").hide();
					 $("#viewSalesPipeLineDiv").fadeIn();
					 $('#dashboardDiv').hide();
					 $('#updateWarehouseInfo').hide();
					 $("#addSPLTitle").hide();
					 $("#updateSPLTitle").hide();
					 $("#addSalesPipeLine").show();
					 $('#cancelSalesPipeLineInfo').hide();
					 $('#updateSalesPipeLineInfo').hide();
					 $('#saveSalesPipeLineInfo').hide();
					 
					$("#grid2").trigger("reloadGrid");
					$("#grid5").trigger("reloadGrid");
					
					$("#customerName").css("border-color","#d7d7d7");
					$("#estimatedFloorBuiltupArea").css("border-color","#d7d7d7");
					$("#estimatedFloorCarpetArea").css("border-color","#d7d7d7");
					$("#estimatedRevenue").css("border-color","#d7d7d7");
					$("#estimatedStartDate").css("border-color","#d7d7d7");
					$("#estimatedRackBuiltupArea").css("border-color","#d7d7d7");
					$("#estimated_palette_positions").css("border-color","#d7d7d7");
					$("#remark").css("border-color","#d7d7d7");
					$("#myForm").resetForm();
					
				},
				error : function(e) {
					console.log("ERROR: ", e);
				
				}
			});	
			}
		else
			{
console.log("hello");
			}
				});
	
	
	/* Collects n Passes Warehouse Information from UI to the Warehouse Contoller
	 */


	 jQuery.validator.addMethod("availableAreaValidation", function (value, element) {

			var availableFloor = parseInt($("#availableFloor2").val());
			var actualFloorCarpetArea = parseInt($("#actualFloorBuiltupArea").val());
			var actualFloorCarpetAreaRef = parseInt($("#actualFloorCarpetAreaRef").val());
			var availableMatchingValue;
			console.log(availableFloor);
			console.log(actualFloorCarpetArea);
			console.log(actualFloorCarpetAreaRef);
			
			availableMatchingValue = actualFloorCarpetArea - actualFloorCarpetAreaRef;
			/* if(actualFloorCarpetAreaRef>actualFloorCarpetArea){
				availableMatchingValue = actualFloorCarpetAreaRef - actualFloorCarpetArea;
				}
			else{
				availableMatchingValue = actualFloorCarpetArea - actualFloorCarpetAreaRef;
				} */

			console.log(availableMatchingValue);
			if(availableMatchingValue>0)
				{
			if(availableMatchingValue>availableFloor)
				{
					return false;
				}
			else
				{
				if(actualFloorCarpetAreaRef != 0)
				{
				var availableFloor = parseInt($("#availableFloor2").val());
				var newAvailableFloorArea = availableFloor - parseInt(availableMatchingValue);
				$("#availableFloor").val(newAvailableFloorArea);
				}
				return true;
					
				}
				}
			else
				{
				if(actualFloorCarpetAreaRef != 0)
					{
				var availableFloor = parseInt($("#availableFloor2").val());
				var newAvailableFloorArea = availableFloor - parseInt(availableMatchingValue);
				$("#availableFloor").val(newAvailableFloorArea);
					}
					return true;
				}
	    }, "You are exceeding the space limit.Ref Avialable Area Field above.");
	 


	 jQuery.validator.addMethod("availableRackValidation", function (value, element) {

			var availableRack = parseInt($("#availableRack2").val());
			var actualRackBuiltupArea = parseInt($("#actualRackBuiltupArea").val());
			var actualRackBuiltupAreaRef = parseInt($("#actualRackBuiltupAreaRef").val());
			var availableMatchingValue;
			console.log(availableRack);
			console.log(actualRackBuiltupArea);
			console.log(actualRackBuiltupAreaRef);
			
			availableMatchingValue = actualRackBuiltupArea - actualRackBuiltupAreaRef;
			/* if(actualFloorCarpetAreaRef>actualFloorCarpetArea){
				availableMatchingValue = actualFloorCarpetAreaRef - actualFloorCarpetArea;
				}
			else{
				availableMatchingValue = actualFloorCarpetArea - actualFloorCarpetAreaRef;
				} */

			console.log(availableMatchingValue);
			if(availableMatchingValue>0)
				{
			if(availableMatchingValue>availableRack)
				{
					return false;
				}
			else
				{
				if(actualRackBuiltupAreaRef != 0)
				{
				var availableRack = parseInt($("#availableRack2").val());
				var newAvailableFloorArea = availableRack - parseInt(availableMatchingValue);
				$("#availableCarpet").val(newAvailableFloorArea);
				}
				return true;
					
				}
				}
			else
				{
				if(actualRackBuiltupAreaRef != 0)
					{
				var availableRack = parseInt($("#availableRack2").val());
				var newAvailableFloorArea = availableRack - parseInt(availableMatchingValue);
				$("#availableCarpet").val(newAvailableFloorArea);
					}
					return true;
				}
	    }, "You are exceeding the space limit.Ref Avialable Area Field above.");
	 

	 
	 jQuery.validator.addMethod("valueCheck", function (value, element) {

		 var actualFloorCarpetArea = parseInt($("#actualFloorCarpetArea").val());
		 var actualRackBuiltupArea = parseInt($("#actualRackBuiltupArea").val());
		 var actual_palette_position = parseInt($("#actual_palette_positions").val());

		 if(actualFloorCarpetArea == 0 && actualRackBuiltupArea==0 && actual_palette_position == 0)
			 {
				return false;	

			 }
		 else
			 {
				if(actualFloorCarpetArea==0 && actualRackBuiltupArea!=0 && actual_palette_position != 0)
					{
						return true;
					}
				else if(actualFloorCarpetArea!=0 && actualRackBuiltupArea==0 && actual_palette_position == 0)
					{
					   return true;
					}
				else if(actualFloorCarpetArea!=0 && actualRackBuiltupArea!=0 && actual_palette_position != 0)
				{
				   return true;
				}
				else{
					return false;
					}

					}
			 
			
	    }, "Value Cant be Zero");


		
	 validatorUpdate = $("#myFormUpdate").validate({
	        rules: {

				actualFloorCarpetArea : {
	                required: true,
	                digits: true,
	                valueCheck : true,
	                availableAreaValidation : true
	            },
				actualRackBuiltupArea : {
	                required: true,
	                digits: true,
	                valueCheck: true,
	                availableRackValidation : true
	            },
	            actual_palette_positions : {
	                required: true,
	                digits: true,
	                valueCheck: true
	            },
				actualRevenue : {
	                required: true,
	                min :1,
	                number: true
	            },
				actualStartDate : {
	                required: true,
	                date: true
	            },
		    },
	        messages: {
	        	actual_palette_positions : "Enter Actual Rack Space",
				actualRevenue : "enter Actual Revenue",
				actualStartDate : "Enter Actual Start Date ",
			   
	        }
	    });

	    


	 
	$("#updateSalesPipeLineInfo").click(function(){

		
		if($("#myForm").valid() && $("#myFormUpdate").valid())
		 {
		 
		 $("#addSalesPipeLineDiv").hide();
		 $("#viewSalesPipeLineDiv").fadeIn();
		 $("#addWarehouseDiv").hide();
	     $("#viewWarehouseDiv").hide();
		 $('#dashboardDiv').hide();
		 $('#updateWarehouseInfo').hide();
		 
		 $("#addSPLTitle").hide();
		 $("#updateSPLTitle").hide();
		 $("#addSalesPipeLine").show();
		 $('#cancelSalesPipeLineInfo').hide();
		 $('#updateSalesPipeLineInfo').hide();
		 $('#saveSalesPipeLineInfo').hide();
		 
		    var salesPipeLineId = $("#sp_Id").val();
			var customerName = $("#customerName").val();
			var customerType = $("#customerType").val();
			var availableFloor = parseInt($("#availableFloor").val());
			var availableCarpet = $("#availableCarpet").val();
			var estimatedFloorBuiltupArea = $("#estimatedFloorBuiltupArea").val();
			var estimatedFloorCarpetArea = $("#estimatedFloorCarpetArea").val();
			var estimatedRackBuiltupArea = $("#estimatedRackBuiltupArea").val();
			var estimated_palette_positions = $("#estimated_palette_positions").val();
			var estimatedRevenue = $("#estimatedRevenue").val();
			var estimatedStartDate = $("#estimatedStartDate").val();
			var allocatedWarehouse = $("#allocatedWarehouse").val();
			var statusWork = $("#statusWork").val();
			var actualFloorBuiltupArea = parseInt($("#actualFloorBuiltupArea").val());
			var actualFloorCarpetArea = parseInt($("#actualFloorCarpetArea").val());
			var actualFloorCarpetAreaRef = parseInt($("#actualFloorCarpetAreaRef").val());
			var actualRackBuiltupArea = parseInt($("#actualRackBuiltupArea").val());
			var actual_palette_positions = parseInt($("#actual_palette_positions").val());
			var actualRackBuiltupAreaRef = parseInt($("#actualRackBuiltupAreaRef").val());
			var actualRevenue = parseInt($("#actualRevenue").val());
			var actualStartDate = $("#actualStartDate").val();
			var remark = $("#remark").val();
			//alert(statusWork);
			var empty="";
			var confirmed1 = "confirmed";

	/* 		
		if(actualFloorCarpetArea>availableFloor)
			{

			var spaceExceedingWarning = "You have exceeded the available space limit.Please contact System Admin for increase of Area ";
        	$('#warningPara').text(spaceExceedingWarning);
        	$('#warningDiv').show();


			} 
		 else if(actualFloorBuiltupArea<=0 && actualFloorCarpetArea<=0 && actualRackBuiltupArea<=0 && actualRackCarpetArea<=0 && actualRevenue<=0)
		{
			var spaceExceedingWarning = "Please enter valid Actual Values";
        	$('#warningPara').text(spaceExceedingWarning);
        	$('#warningDiv').show();
			
			}  */
	/* 	else
			{
   */
			
			$.ajax({
				
				type : "POST",
				encoding : "UTF-8",
				url : "updateSalesPipeLine",
				datatype :'json', 
				data : {
					salesPipeLineId : salesPipeLineId,
					customerName : customerName,
					customerType : customerType,
					availableFloor : availableFloor,
					availableCarpet : availableCarpet,
					estimatedFloorBuiltupArea : estimatedFloorBuiltupArea,
					estimatedFloorCarpetArea : estimatedFloorCarpetArea,
					actualFloorCarpetAreaRef : actualFloorCarpetAreaRef,
					actualRackBuiltupAreaRef : actualRackBuiltupAreaRef,
					estimatedRackBuiltupArea : estimatedRackBuiltupArea,
					estimated_palette_positions : estimated_palette_positions,
					estimatedRevenue : estimatedRevenue,
					estimatedStartDate : estimatedStartDate,
					allocatedWarehouse : allocatedWarehouse,
					statusWork : statusWork,
					actualFloorBuiltupArea : actualFloorBuiltupArea,
					actualFloorCarpetArea : actualFloorCarpetArea,
					actualRackBuiltupArea : actualRackBuiltupArea,
					actual_palette_positions : actual_palette_positions,
					actualRevenue : actualRevenue,
					actualStartDate : actualStartDate,
					remark : remark,
		            },
				success : function(data) {
					console.log("SUCCESS: ", data);
					$("#grid2").trigger("reloadGrid");
					$("#grid5").trigger("reloadGrid");
					var workStatus = $.trim(data);
					var confirmed = "confirmed";
					if(workStatus == confirmed)
						{
						    	/* $('#readinessTemplateCompanyName').val(customerName);
						    	$('#readinessSalesPipeLineId').val(salesPipeLineId);
						    	$('#readinessTemplate').show();
						    	$('#addReadinessTemplateGrid').show();
						    	$('#editReadinessTemplateGrid').hide();
						    	$('#bulkSave').show();
						    	$('#bulkUpdate').hide();
						    	$("#grid4").trigger("reloadGrid");
						*/
						var customerValue = $("#customerName :selected").text();
						$('#readinessTemplateCompanyName').val(customerValue);
				    	$('#readinessSalesPipeLineId').val(salesPipeLineId);
						
						$("#inlineEditGrid").jqGrid('setGridParam', { 
				            postData: {"salesPipeLineId":salesPipeLineId }
				     }).trigger('reloadGrid'); 
			  	
				    	$('#readinessTemplate').show();
				    	$('#addReadinessTemplateGrid').hide();
				    	$('#editReadinessTemplateGrid').show();
				    	$('#bulkSave').hide();
				    	$('#bulkUpdate').show();
						

				    	$("#updateReadinessOrderTitle").hide();
				    	$("#addReadinessOrderTitle").show();
												
						}
					
				},
				error : function(e) {
					console.log("ERROR: ", e);
				
				}
			});	
	
	           
			//}
}
		else
			{
               console.log("failed");
			}
		
		});
	
	
//	Cancel Opertaion of SalesPipleLine
	
		$("#cancelSalesPipeLineInfo").click(function(){
			 $("#addWarehouseDiv").hide();
			 $("#viewWarehouseDiv").hide();
			 $("#addSalesPipeLineDiv").hide();
			 $("#viewSalesPipeLineDiv").fadeIn();
			 $("#addSPLTitle").hide();
			 $("#updateSPLTitle").hide();
			 $("#addSalesPipeLine").show();
			 $('#cancelSalesPipeLineInfo').hide();
			 $('#updateSalesPipeLineInfo').hide();
			 $('#saveSalesPipeLineInfo').hide();
			 
			 validator.resetForm();
			 validatorUpdate.resetForm();
				$("#customerName").css("border-color","#d7d7d7");
				//alert("here");
				$("#estimatedFloorBuiltupArea").css("border-color","#d7d7d7");
				$("#estimatedFloorCarpetArea").css("border-color","#d7d7d7");
				$("#estimatedRevenue").css("border-color","#d7d7d7");
				$("#estimatedStartDate").css("border-color","#d7d7d7");
				$("#estimatedRackBuiltupArea").css("border-color","#d7d7d7");
				$("#estimated_palette_positions").css("border-color","#d7d7d7");

				$("#actualFloorBuiltupArea").css("border-color","#d7d7d7");
				$("#actualFloorCarpetArea").css("border-color","#d7d7d7");
				$("#actualRevenue").css("border-color","#d7d7d7");
				$("#actualRackBuiltupArea").css("border-color","#d7d7d7");
				$("#actual_palette_positions").css("border-color","#d7d7d7");	
			    $("#actualStartDate").css("border-color","#d7d7d7");
			});
	
	$("#cancelReadinessTemplateDailog").click(function()
			{
		      
		     $("#readinessTemplate").hide();
		
	        }
			);

	
	 
	$("#readinessTemplateEditButton").click(function(){


		if($("#readinessTemplateForm").valid())
		 {
		  
			 
		var grid = $('#inlineEditGrid');    
		var rowid = $("#rowNumber").val();
		var readinessTemplateEditId = $("#readinessTemplateEditId").val();
		var readinessTemplateEditCustomerName = $("#readinessTemplateEditCustomerName").val();
		var readinessTemplateEditElement =$("#readinessTemplateEditElement").val();                                 
		var readinessTemplateEditStartDate = $("#readinessTemplateEditStartDate").val();                                
		var readinessTemplateEditEndDate = $("#readinessTemplateEditEndDate").val(); 
		var readinessTemplateEditElementStatus = $("#readinessTemplateEditElementStatus").val();
		var readinessTemplateEditOwnerName = $("#readinessTemplateEditOwnerName").val(); 
		var readinessTemplateEditQuantity = $("#readinessTemplateEditQuantity").val(); 
		
		//alert(rowid+","+readinessTemplateEditId);
		
		var startDateV    = new Date(readinessTemplateEditStartDate),
	    yr      = startDateV.getFullYear(),
	    month   = startDateV.getMonth() < 10 ? '0' + startDateV.getMonth()+1 : startDateV.getMonth()+1,
	    day     = startDateV.getDate()  < 10 ? '0' + startDateV.getDate()  : startDateV.getDate(),
	    startDate = day + '-' + month + '-' + yr;
		//alert(startDate);

	    var endDateV    = new Date(readinessTemplateEditEndDate),
	    yr      = endDateV.getFullYear(),
	    month   = endDateV.getMonth() < 10 ? '0' + endDateV.getMonth()+1 : endDateV.getMonth()+1,
	    day     = endDateV.getDate()  < 10 ? '0' + endDateV.getDate()  : endDateV.getDate(),
	    endDate = day + '-' + month + '-' + yr;
		//alert(endDate);
		
		
		
		grid.jqGrid('setCell', rowid, 'readinessTemplateId',readinessTemplateEditId);	
		grid.jqGrid('setCell', rowid, 'readiness_element_name',readinessTemplateEditCustomerName);	
		 grid.jqGrid('setCell', rowid, 'readinessElementQuantity',readinessTemplateEditQuantity);	
		grid.jqGrid('setCell', rowid, 'taskStartDate',startDate);	
		grid.jqGrid('setCell', rowid, 'taskEndDate',endDate);	
		grid.jqGrid('setCell', rowid, 'ownerName',readinessTemplateEditOwnerName);	
		grid.jqGrid('setCell', rowid, 'readinessElementStatus',readinessTemplateEditElementStatus);	
		grid.jqGrid('setCell', rowid, 'taskStartDateAct',readinessTemplateEditStartDate);	
		grid.jqGrid('setCell', rowid, 'taskEndDateAct',readinessTemplateEditEndDate);	
		$("#editReadinessTemplateDiv").hide();
		
		
		$("#readinessTemplateEditId").val("");
		$("#readinessTemplateEditCustomerName").val("");
		$("#readinessTemplateEditElement").val("");                                 
		$("#readinessTemplateEditStartDate").val("");                                
		$("#readinessTemplateEditEndDate").val(""); 
		$("#readinessTemplateEditElementStatus").val("");
		$("#readinessTemplateEditOwnerName").val(""); 
		$("#readinessTemplateEditQuantity").val(""); 
		
	/* 	$.ajax({
			
			type : "POST",
			encoding : "UTF-8",
			url : "updateReadinessTemplate",
			datatype :'json', 
			data : {
				readinessTemplateEditId : readinessTemplateEditId,
				readinessTemplateEditCustomerName : readinessTemplateEditCustomerName,
				readinessTemplateEditStartDate : readinessTemplateEditStartDate,
				readinessTemplateEditEndDate : readinessTemplateEditEndDate,
				readinessTemplateEditElementStatus : readinessTemplateEditElementStatus,
				readinessTemplateEditOwnerName : readinessTemplateEditOwnerName,
				readinessTemplateEditQuantity : readinessTemplateEditQuantity,
	            },
			success : function(data) {
				console.log("SUCCESS: ", data);
				alert(data);
				$('#editReadinessTemplateDiv').hide();
				
			},
			error : function(e) {
				
				console.log("ERROR: ", e);
			
			}
		});		 */		
		
		 }
		 else
			 {
			 console.log('hello');

			 }
		
		
		
		});
	
	$("#singleAdd").click(function()
			{
		$("#editReadinessTemplateDiv").show();
		$("#readinessTemplateEditButton").hide();
		$("#addReadinessTemplateButton").show();
		$("#readinessTemplateEditId").val("");
		$("#readinessTemplateEditCustomerName").val("");
		$("#readinessTemplateEditElement").val("");                                 
		$("#readinessTemplateEditStartDate").val("");                                
		$("#readinessTemplateEditEndDate").val(""); 
		$("#readinessTemplateEditElementStatus").val("");
		$("#readinessTemplateEditOwnerName").val(""); 
		$("#readinessTemplateEditQuantity").val(""); 
		
		
		

		 $('#readinessTemplateEditCustomerName').empty();
		 
		
		$.ajax({
			type:'GET',
			encoding : "UTF-8",
			url : "listReadinessElements",
			data : "",
		    dataType: 'json',
		    success: function( json ) {
		        $.each(json, function(i, value) {
		        	
		        	$('#readinessTemplateEditCustomerName').append($('<option>').text(value.readiness_element_name).attr('value', value.readiness_element_name));
		        });
		    }
		});
		
		
			});

	
	

	 var validatorReadiness = $("#readinessTemplateForm").validate({
	        rules: {
	        	readinessTemplateEditStartDate : "required",
	        	readinessTemplateEditEndDate: "required",
	        	readinessTemplateEditElementStatus : "required",
	        	readinessTemplateEditOwnerName: "required",
	        	readinessTemplateEditQuantity: {
	        	      required: true,
	        	      digits: true
	        	    },
	        },
	        messages: {
	        	readinessTemplateEditStartDate : "Please select Start Date",
	        	readinessTemplateEditEndDate: "Please select End Date",
	        	readinessTemplateEditElementStatus : "Please Enter Element Status",
	        	readinessTemplateEditOwnerName: "Enter Owner Name",/* 
	        	readinessTemplateEditQuantity : "Enter the Quantity ", */
	           
	        }
	    });

	

	$("#addReadinessTemplateButton").click(function()
			{
		
		if($("#readinessTemplateForm").valid())
		 {
		  
		
		var grid = $('#inlineEditGrid'); 
		var exactRowCount = $("#inlineEditGrid").getGridParam("reccount");
		var counter = "1"; 
		var rowid =parseInt(exactRowCount) + parseInt(counter);
		//alert(rowid);
		var readinessTemplateEditId = $("#readinessTemplateEditId").val();
		var readinessTemplateEditCustomerName = $("#readinessTemplateEditCustomerName").val();
		var readinessTemplateEditElement =$("#readinessTemplateEditElement").val();                                 
		var readinessTemplateEditStartDate = $("#readinessTemplateEditStartDate").val();                                
		var readinessTemplateEditEndDate = $("#readinessTemplateEditEndDate").val(); 
		var readinessTemplateEditElementStatus = $("#readinessTemplateEditElementStatus").val();
		var readinessTemplateEditOwnerName = $("#readinessTemplateEditOwnerName").val(); 
		var readinessTemplateEditQuantity = $("#readinessTemplateEditQuantity").val(); 
	 	var counterId = parseInt("0");

	 	var startDateV    = new Date(readinessTemplateEditStartDate),
	    yr      = startDateV.getFullYear(),
	    month   = startDateV.getMonth() < 10 ? '0' + startDateV.getMonth()+1 : startDateV.getMonth()+1,
	    day     = startDateV.getDate()  < 10 ? '0' + startDateV.getDate()  : startDateV.getDate(),
	    startDate = day + '-' + month + '-' + yr;
		//alert(startDate);

	    var endDateV    = new Date(readinessTemplateEditEndDate),
	    yr      = endDateV.getFullYear(),
	    month   = endDateV.getMonth() < 10 ? '0' + endDateV.getMonth()+1 : endDateV.getMonth()+1,
	    day     = endDateV.getDate()  < 10 ? '0' + endDateV.getDate()  : endDateV.getDate(),
	    endDate = day + '-' + month + '-' + yr;
		//alert(endDate);
	 	
		var mydata3 =  [{
			                 "readinessTemplateId": counterId,
				            "readiness_element_name": readinessTemplateEditCustomerName,
		            	    "readinessElementQuantity": readinessTemplateEditQuantity,
		            	    "taskStartDate": startDate,
		            	    "taskEndDate": endDate,
		            	    "ownerName": readinessTemplateEditOwnerName,
		            	    "readinessElementStatus": readinessTemplateEditElementStatus,
		            	    "isDeleted": "No",
		            	    "taskStartDateAct": readinessTemplateEditStartDate,
		            	    "taskEndDateAct": readinessTemplateEditEndDate
		            	  }]; 

		
		grid.addRowData(rowid, mydata3);
		
		 var readinessCompanyName = $('#readinessTemplateCompanyName').val();
		
		
		
	/* 	$.ajax({
			
			type : "POST",
			encoding : "UTF-8",
			url : "addReadinessTemplateBulk",
			datatype :'json', 
			data : {
				valueOfReadinessCompanyName : readinessCompanyName,
				valueOfReadinessSalesPipeLineId : readinessSalesPipeLineId,
				readinessArrayValue : mydata3,
	            },
			success : function(data) {
				console.log("SUCCESS: ", data);	alert(data);
				$('#inlineEditGrid').trigger("reloadGrid");
			
			},
			error : function(e) {
				console.log("ERROR: ", e);
			
			}
		});	  */
		
		$("#editReadinessTemplateDiv").hide();
		 }
		else{
			console.log("validation works");

			}
			});
	
	
	
	
	$('#cancelReadinessOrder').click(function()
			{
	      
	     $("#editReadinessTemplateDiv").hide();
	     //$("#readinessTemplateForm").resetForm();
	     validatorReadiness.resetForm();
	     
	     $("#readinessTemplateEditStartDate").css("border-color","#d7d7d7");
	     $("#readinessTemplateEditEndDate").css("border-color","#d7d7d7");
	     $("#readinessTemplateEditElementStatus").css("border-color","#d7d7d7");
	     $("#readinessTemplateEditOwnerName").css("border-color","#d7d7d7");
	     $("#readinessTemplateEditQuantity").css("border-color","#d7d7d7");
	     
       }
		);
	
	$('#applyFilter').click(function()
			{
		
		var filterText = $('#statusWorkFilter').val();
		//alert(filterText);
		var grid = jQuery("#grid5");
		var postdata = grid.jqGrid('getGridParam','postData');
		
		var myfilter = { groupOp: "OR", rules: [] };        
	    myfilter.rules.push({ field: "statusWork", op: "cn", data: filterText });
	    $.extend(postdata, { filters: myfilter });
	//	$.extend (postdata,{filters:'',searchField: 'error_column',searchOper: 'eq',searchString: filterText});
		grid.jqGrid('setGridParam', { search: true, postData: postdata });
		grid.trigger("reloadGrid");
		
		
			});
	
	

	$("#bulkRemove").click(function()
			{
	/* 	var ids=$('#grid4').getGridParam('selarrrow');
		$('#grid4').delRowData(ids);
		
		for( var i=ids.length-1;i>=0;i--)
			{

			$('#grid4').delRowData(ids[i]);
			
			} */
	/* 	var myData = grid.jqGrid('getRowData');
		alert(myData);
		 */
		 var demo = $("#inlineGrid").jqGrid('getRowData')
		
		console.log(demo);
		 
			});
	
	
	$('#bulkSave').click(function(){
	 /*    var p = $('#grid4').getGridParam();
	    console.log("found gridParamData:", p.data); */
	  /*   if (p.data){
	        var newData = [
	            {id: 462, thingy: "abc"}
	        ];
	        var rowId = $.jgrid.randId();
	        $("#grid").jqGrid('addRowData', rowId, newData);
	        console.log(rowId);
	    }  */  
	     var readinessArrayValue = JSON.stringify($("#inlineGrid").jqGrid('getRowData'));
		console.log(readinessArrayValue);

	    
	 	var readinessCompanyName = $('#readinessTemplateCompanyName').val();
		var readinessSalesPipeLineId = $('#readinessSalesPipeLineId').val();
		
		
		$.ajax({
			
			type : "POST",
			encoding : "UTF-8",
			url : "addReadinessTemplateBulk",
			datatype :'json', 
			data : {
				valueOfReadinessCompanyName : readinessCompanyName,
				valueOfReadinessSalesPipeLineId : readinessSalesPipeLineId,
				readinessArrayValue : readinessArrayValue,
	            },
			success : function(data) {
				console.log("SUCCESS: ", data);
				
				//alert(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			
			}
		});		
	    
	    
	    
	});
	
	
	$('#bulkUpdate').click(function(){
		
		     var readinessArrayValue = JSON.stringify($("#inlineEditGrid").jqGrid('getRowData'));
			
		     console.log(readinessArrayValue);

		    
		 	var readinessCompanyName = $('#readinessTemplateCompanyName').val();
			var readinessSalesPipeLineId = $('#readinessSalesPipeLineId').val();
			
			
			$.ajax({
				
				type : "POST",
				encoding : "UTF-8",
				url : "updateReadinessTemplateBulk",
				datatype :'json', 
				data : {
					valueOfReadinessCompanyName : readinessCompanyName,
					valueOfReadinessSalesPipeLineId : readinessSalesPipeLineId,
					readinessArrayValue : readinessArrayValue,
		            },
				success : function(data) {
					console.log("SUCCESS: ", data);
					$("#grid3").trigger("reloadGrid");
					readinessTemplateValues.length = 0;
					loadReadinessElementName();
					//alert(readinessTemplateValues);
					
					
					$('#readinessTemplate').hide();
				},
				error : function(e) {
					console.log("ERROR: ", e);
				
				}
			});		
		    
		    
		    
		});
	
	$('#bulkUndo').click(function()
			{
		 
		
		 var rowData = $("#inlineEditGrid").getDataIDs();
		 console.log(rowData);
		 
		 
		    for (var i = 0; i<rowData.length; i++) 
		    {
		    	var trElement = jQuery("#"+rowData[i],jQuery('#inlineEditGrid'));
		    	trElement.addClass('displayShow');
		    	$("#inlineEditGrid").trigger("reloadGrid");
		    	//$("#inlineEditGrid").jqGrid('setRowData', rowData[i], false, {display:block});
		    }
		
			});
	
	
	$("#clientRTButton").click(function()
			{
		
		var clientRTValue = $('#clientRTName').val();
		//alert(clientRTValue);
		
		$("#readinessTemplateReportGrid").jqGrid('setGridParam', { 
            postData: {"salesPipeLineId":clientRTValue }
     }).trigger('reloadGrid'); 
		
			});

	

	$("#clientStatusFilterButton").click(function()
			{
		
		var clientStatusFilter = $('#clientStatusFilter').val();
		//alert(clientRTValue);
		
		$("#areaGrid").jqGrid('setGridParam', { 
            postData: {"clientStatusFilter":clientStatusFilter }
     }).trigger('reloadGrid'); 
		
			});
	


	$("#clientWarehouseFilterButton").click(function()
			{
		
		var clientWarehouseFilter = $('#clientWarehouseFilter').val();
		//alert(clientRTValue);
		
		$("#clientGrid").jqGrid('setGridParam', { 
            postData: {"clientWarehouseFilter":clientWarehouseFilter }
     }).trigger('reloadGrid'); 
		
			});
	
	
	
	

    $("#hideLogout").click(function(){
    	$('#logoutDiv').hide();
        	});

    $("#hideWarning").click(function(){
    	$('#warningDiv').hide();
        	});

    $("#hideAlert").click(function(){
    	$('#alertDiv').hide();
        	});

	 $('#doWarehouseOperation').click(function()
	 {

		 var warehouseId = $('#alertPara').val();
		// alert(id);
		  $.ajax({
      		
      		type : "POST",
      		encoding : "UTF-8",
      		url : "deleteWarehouseById",
      		datatype :'json', 
      		data : {
      			warehouseId : warehouseId,
      			        },
      		success : function(data) {
                    console.log("Marked for Deletion");
                    $("#grid").trigger("reloadGrid");
                    $('#alertDiv').hide();
      		           },
      		error : function(e) {
      			console.log("ERROR: ", e);
      		
      			}
      	});
	      	
		 });	


	 $('#doCustomerOperation').click(function()
			 {

				 var warehouseId = $('#alertPara').val();
				// alert(id);
				  $.ajax({
		      		
		      		type : "POST",
		      		encoding : "UTF-8",
		      		url : "deleteCustomer",
		      		datatype :'json', 
		      		data : {
		      			customer_id : warehouseId,
		      			        },
		      		success : function(data) {
		                    console.log("Marked for Deletion");
		                    $("#grid").trigger("reloadGrid");
		                    $('#alertDiv').hide();
		      		           },
		      		error : function(e) {
		      			console.log("ERROR: ", e);
		      		
		      			}
		      	});
			      	
				 });	

	 

	 $('#doReadinessOperation').click(function()
			 {

				 var id = $('#alertPara').val();
				// alert(id);
				  $.ajax({
			                         		type : "POST",
			                         		encoding : "UTF-8",
			                         		url : "deleteReadinessById",
			                         		datatype :'json', 
			                         		data : {
			                         			re_id : id,
			                         			        },
			                         		success : function(data) {
			                                       console.log("Marked for Deletion");
			                                       $("#grid3").trigger("reloadGrid");
			                                       $('#alertDiv').hide();
			                         		           },
			                         		error : function(e) {
			                         			console.log("ERROR: ", e);
			                         		
			                         		}
			                         	});
				 });



	 $('#doSalesPipeLineOperation').click(function()
			 {

				 var salesPipeline_id = $('#alertSalesPipeLineId').val();
				 var warehouse_id = $('#alertWarehousId').val();
				 var actualFloorCarpetArea_value = $('#alertFloorCarpertArea').val();
				 var alertRackArea = $('#alertRackArea').val();	
					  $.ajax({
              		
              		type : "POST",
              		encoding : "UTF-8",
              		url : "deleteSalesPipeLineById",
              		datatype :'json', 
              		data : {
              			salesPipeLineId : salesPipeline_id,
              			warehouseId : warehouse_id,
              			estimatedFloorCarpetArea : actualFloorCarpetArea_value,
              			alertRackArea : alertRackArea,
              			        },
              		success : function(data) {
                            console.log("Marked for Deletion");
                            $("#grid2").trigger("reloadGrid");
                            $('#alertDiv').hide();
              		           },
              		error : function(e) {
              			console.log("ERROR: ", e);
              		
              		}
              	});
	              	
				 });



	 $('#uploadDocument').click(function()
			 {
		 var salesPipeLineId = $("#sp_Id").val();
		 
		 sessionStorage.setItem("salesPipeLineId", salesPipeLineId); 
		 
		 window.open ("http://localhost:8080/eSpaceWD/uploadFile.jsp", "Janela", "status=no, width=360, height=300")
		 
		 });


	 

	 
	 $('#downloadDocument').click(function()
			 {

		 

		 var salesPipeLineIdUpload = $("#sp_Id").val();
		
			  $.ajax({
      		
      		type : "POST",
      		encoding : "UTF-8",
      		url : "getDownloadDocById",
      		datatype :'json', 
      		data : {
      			salesPipeLineIdUpload : salesPipeLineIdUpload,
      			
      			        },
      		success : function(data) {
                    console.log(data);
                   
      		           },
      		error : function(e) {
      			console.log("ERROR: ", e);
      		
      		}
      	});


		 
		 });

/* 	 $("form#dataUpload").submit(function(){

			alert($("#file").val());
				
		 });
 */

		
		var start = document.getElementById('readinessTemplateEditStartDate');
		var end = document.getElementById('readinessTemplateEditEndDate');

		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1; //January is 0!
		var yyyy = today.getFullYear();
		 if(dd<10){
		        dd='0'+dd
		    } 
		    if(mm<10){
		        mm='0'+mm
		    } 

		today = yyyy+'-'+mm+'-'+dd;
		document.getElementById('readinessTemplateEditStartDate').setAttribute("min", today);
		document.getElementById('actualStartDate').setAttribute("min", today);
		document.getElementById('estimatedStartDate').setAttribute("min", today);
		
		
		start.addEventListener('change', function() {
		    if (start.value)
		        end.min = start.value;
		}, false);
		/* end.addEventListener('change', function() {
		    if (end.value)
		        start.max = end.value;
		}, false);
 */
		




		
});

/* $("#from").datepicker({ dateFormat: 'dd-mm-yy' }) */



setInterval(dashboardValues,10000);


</script>
</head>
<body>
<!-- START PAGE CONTAINER -->
        <div class="page-container">
            
            <!-- START PAGE SIDEBAR -->
            
            <div class="page-sidebar">
                <!-- START X-NAVIGATION -->
                <ul class="x-navigation" >
                    <li class="xn-logo">
                        <!-- <a href="#"><i>sparsh</i></a> -->
                        <!--  --><a href="#" class="x-navigation-control"></a>
                        <img src="${logoImg}" alt="John Doe"/>
                    </li> 
                    
                    <li class="xn-profile">
                       
                        <div class="profile">
                            
                            <div class="profile-data">
                                <div class="profile-data-name"><%=request.getAttribute("FullName")%></div>
                                <div class="profile-data-title"><%=request.getAttribute("Designation")%></div>
                            
                            </div>
                            
                        </div>                                                                        
                    </li>

				<li id="dashboardLink"><a><span class="fa fa-home"></span>
						Home</a></li>
					<li class="xn-openable">
					<a href="#"><span class="fa fa-history"></span> Masters</a>
						<ul>
						<li id="warehouseLink"><a><span class="fa fa-desktop"></span>
								<span class="xn-text">WareHouse</span></a></li>
						<li id="readinessLink"><a><span class="fa fa-car"></span>
								<span class="xn-text">Readiness</span></a></li>
								
						<li id="customerLink"><a><span class="fa fa-car"></span>
								<span class="xn-text">Customer</span></a></li>
					  </ul>
					   </li>
				<li class="xn-openable">
					<a href="#"><span class="fa fa-money"></span> Transactions</a>
						<ul>
				<li id="salesPipeLineLink"><a><span class="fa fa-arrows"></span>
						<span class="xn-text">SalesPipeLine</span></a></li>
						</ul>
						</li>
	<!-- 			<li id="readinessTemplateLink"><a><span class="fa fa-calendar"></span>
						<span class="xn-text"> Readiness Template </span></a></li> -->
						
						<li class="xn-openable">
					<a href="#"><span class="fa fa-money"></span> Reports</a>
						<ul>
				<li id="graphicalReportLink"><a><span class="fa fa-circle"></span>
						<span class="xn-text">Graphical Report</span></a></li>
						<li id="tabularReportLink" ><a><span class="fa fa-arrows-h"></span>
						<span class="xn-text">Aging Report </span></a>
						</li>
						<li id="areaReportLink"><a><span class="fa fa-gear"></span>
						<span class="xn-text">Area Report</span></a>
						
						</li>
						<li id="clientReportLink" ><a><span class="fa fa-gear"></span>
						<span class="xn-text">Client Report</span></a>
						
						</li>
						<li id="readinessReportLink" ><a><span class="fa fa-gear"></span>
						<span class="xn-text">Readiness Report</span></a>
						
						</li>
						</ul>
						</li>
						
						
				<li id="settingLink"><a><span class="fa fa-gear"></span> <span
						class="xn-text">Setting</span></a></li>

                   <li id="logoutLink"><a><span class="fa fa-sign-out "></span> <span
						class="xn-text">Logout</span></a></li>
			</ul>
				
                <!-- END X-NAVIGATION -->
            </div>
            <!-- END PAGE SIDEBAR -->
            
            <!-- PAGE CONTENT -->
            <div class="page-content">
                
                   <!-- START X-NAVIGATION VERTICAL -->
                <ul class="x-navigation x-navigation-horizontal x-navigation-panel" style="display:none;">
                    <!-- TOGGLE NAVIGATION -->
                    <li class="xn-icon-button">
                        <a href="#" class="x-navigation-minimize"><span class="fa fa-dedent"></span></a>
                    </li>
                    <!-- END TOGGLE NAVIGATION -->                    
                </ul>
                <!-- END X-NAVIGATION VERTICAL -->                     
                               
                
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">
                 <!-- START WIDGETS -->       
                 <div id="dashboardDiv" style="margin-left: 30px;"> 
				 
                    <div class="row" style="margin-top: 30px;">
                        <div class="col-md-3" id="warehouseDivCount">
                            
                             <div class="widget widget-default widget-item-icon">
                                <div class="widget-item-left">
                                    <span class="fa fa-home" style="color: #1cb29a;"></span>
                                </div>                             
                                <div class="widget-data">
                                    <div class="widget-int num-count" ><input type="text" style="background:white;border:none;width:20px;" id="totalWarehouse" disabled /></div>
                                    <div class="widget-title" style="text-transform: capitalize;">Total Warehouses </div>
                                    <div class="widget-subtitle"></div>
                                </div>      
                               
                            </div>  
                            
                        </div>
                        <div class="col-md-3">
                            
                            <!-- START WIDGET MESSAGES -->
                            <div class="widget widget-default widget-item-icon" >
                                <div class="widget-item-left">
                                    <span class="fa fa-user" style="color: #428bca;"></span>
                                </div>                             
                                <div class="widget-data">
                                    <div class="widget-int num-count"><input type="text" style="background:white;border:none;width:20px" id="totalClientsCount" disabled /></div>
                                    <div class="widget-title" style="text-transform: capitalize;">Total Clients</div>
                                    <div class="widget-subtitle"></div>
                                </div>      
                               
                            </div>                            
                            <!-- END WIDGET MESSAGES -->
                            
                        </div>
                        <div class="col-md-3">
                            
                            <!-- START WIDGET REGISTRED -->
                            <div class="widget widget-default widget-item-icon" >
                                <div class="widget-item-left">
                                    <span class="fa fa-database" style="color: #0a7d0a;"></span>
                                </div>
                                <div class="widget-data">
                                    <div class="widget-int num-count"><input type="text"  style="background:white;border:none;width:150px;" id="totalSpaceAvailableCount" disabled /></div>
                                    <div class="widget-title" style="text-transform: capitalize;">Total Space Available</div>
                                    <div class="widget-subtitle"></div>
                                </div>
                                                     
                            </div>                            
                            <!-- END WIDGET REGISTRED -->
                            
                        </div>
                        
                         <div class="col-md-3">
                            
                            <!-- START WIDGET REGISTRED -->
                            <div class="widget widget-default widget-item-icon" >
                                <div class="widget-item-left">
                                    <span class="fa fa-database" style="color: #fe970a;"></span>
                                </div>
                                <div class="widget-data">
                                    <div class="widget-int num-count"><input type="text"  style="background:white;border:none;width:150px;" id="totalSpaceUtilizedCount" disabled /></div>
                                    <div class="widget-title" style="text-transform: capitalize;">Total Space Utilized</div>
                                    <div class="widget-subtitle"></div>
                                </div>
                                                     
                            </div>                            
                            <!-- END WIDGET REGISTRED -->
                            
                        </div>
                      
                    </div>
                    <!-- END WIDGETS -->                    
                    
                   <div class="row" >
                    <div class="col-md-8">
                    <jsp:include page="pie.jsp" />
                    </div>
                 	<%-- <div class="col-md-8">
                    <jsp:include page="piechart.jsp" />
                    </div> --%>
                    </div>
                    
                    
                    
                    
                    
                    <div class="row" style="display:none;">
						<div class="col-md-8">
                            
                            <!-- START SALES BLOCK -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="panel-title-box">
                                        <h3>Sales</h3>
                                        <span>Sales activity by period you selected</span>
                                    </div>                                     
                                                                 
                                    
                                </div>
                                <div class="panel-body">                                    
                                    <div class="row stacked">
                                        <div class="col-md-4">                                            
                                            <div class="progress-list">                                               
                                                <div class="pull-left"><strong>In Queue</strong></div>
                                                <div class="pull-right">75%</div>                                                
                                                <div class="progress progress-small progress-striped active">
                                                    <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 75%;">75%</div>
                                                </div>
                                            </div>
                                            <div class="progress-list">                                               
                                                <div class="pull-left"><strong>Shipped Products</strong></div>
                                                <div class="pull-right">450/500</div>                                                
                                                <div class="progress progress-small progress-striped active">
                                                    <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 90%;">90%</div>
                                                </div>
                                            </div>
                                            <div class="progress-list">                                               
                                                <div class="pull-left"><strong class="text-danger">Returned Products</strong></div>
                                                <div class="pull-right">25/500</div>                                                
                                                <div class="progress progress-small progress-striped active">
                                                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 5%;">5%</div>
                                                </div>
                                            </div>
                                            <div class="progress-list">                                               
                                                <div class="pull-left"><strong class="text-warning">Progress Today</strong></div>
                                                <div class="pull-right">75/150</div>                                                
                                                <div class="progress progress-small progress-striped active">
                                                    <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;">50%</div>
                                                </div>
                                            </div>
                                            <p><span class="fa fa-warning"></span> Data update in end of each hour. You can update it manual by pressign update button</p>
                                        </div>
                                        <div class="col-md-8">
                                            <div id="dashboard-map-seles" style="width: 100%; height: 200px"></div>
                                        </div>
                                    </div>                                    
                                </div>
                            </div>
                            <!-- END SALES BLOCK -->
                            
                        </div>
						<div class="common-modal modal fade" id="common-Modal1" tabindex="-1" role="dialog" aria-hidden="true">
							<div class="modal-content">
								<ul class="list-inline item-details">
									<li><a href="http://themifycloud.com/downloads/janux-premium-responsive-bootstrap-admin-dashboard-template/">Admin templates</a></li>
									<li><a href="http://themescloud.org">Bootstrap themes</a></li>
								</ul>
							</div>
						</div>
                        
                        <div class="col-md-4">
                            
                                                      
                        </div>
                    </div>
                    
                    
                    
                    <!-- START DASHBOARD CHART -->
					<div class="chart-holder" id="dashboard-area-1" style="height: 200px;"></div>
					<div class="block-full-width">
                                                                       
                    </div>                    
                </div>
                
                <div id="graphicalChartDiv" style="display:none;">
                <div class="row" >
                    <div class="col-md-12">
                    <jsp:include page="pie2.jsp" />
                    </div>
                 
                    </div>
				</div>

				<div id="warehouseDiv" style="display:none;">
				
			<div class="panel-heading ui-draggable-handle" style="background-color: #1aad98;">
						<div class="row">
							<div class="col-md-2">
								<h3 class="panel-title"
									style="font-size: x-large; color: white;">WareHouse</h3>
							</div>
							<div class="col-md-4" style="float: left;">
								<h3 id="addTitle" class="panel-title"
									style="margin-top: 5px; display: none; color: white;">Add
									Warehouse</h3>
								<h3 id="updateTitle" class="panel-title"
									style="margin-top: 5px; display: none; color: white;">Update
									Warehouse</h3>

							</div>

							<div class="col-md-4" style="float: right;">
								<button class="btn btn-info btn-rounded pull-right"	id="addWarehouse" style="background: white;">
									Add WareHouse <span class="fa fa-plus fa-right"></span>
								</button>
								<button class="btn btn-info btn-rounded pull-right"	id="saveWarehouseInfo" style="background: white; display: none;">
									Save Info <span class="fa fa-save fa-right"></span>
								</button>

								<button class="btn btn-warning btn-rounded pull-right" id="updateWarehouseInfo"	style="background: white; display: none;">
									Update Info <span class="fa fa-save fa-right"></span>
								</button>

								<button class="btn btn-danger btn-rounded pull-right" id="cancelWarehouseInfo" style="background: white; display: none;">
									Cancel <span class="fa fa-undo fa-right"></span>
								</button>

							</div>

						</div>
					</div>

				<div class="panel-body"	style="background: rgba(255, 255, 255, 255);">




					<div class="row" id="viewWarehouseDiv">
					
					
						<div class="col-md-12" style="background:white;margin-bottom:170px;">
					
 <!-- START BASIC TABLE SAMPLE -->
                            <div class="panel panel-default">
                               
                                <div class="panel-body" style="padding: 22px 70px;">

										<table id="grid" class="table"></table>
										<div id="pagingDiv"></div>
                                      
										                   
                                </div>
                            </div>
                            <!-- END BASIC TABLE SAMPLE -->

						</div>


					</div>
					
						<div class="row" id="addWarehouseDiv" style="display:none;">
				
				
				
				<div class="col-md-12" style="background:white;margin-bottom:170px;">
					
 <!-- START BASIC TABLE SAMPLE -->
                            <div class="panel panel-default">
                             
                                <div class="panel-body">
                                    
                                      <form id="warehouseForm" class="form-horizontal" >
                                <div class="panel-body">                                    
                                    <div class="form-group" style="display:none;">
                                        <label class="col-md-3 control-label" style="color:black;">Warehouse Name :</label>  
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" id="warehouseId"/>
                                           
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">Warehouse Name :</label>  
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" id="warehouseName" name="warehouseName"/>
                                           
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">Floor Builtup Area :</label>                                        
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" id="floorBuiltupArea" name="floorBuiltupArea"/>                                        
                                            <input type="text" class="form-control" style="display:none;" id="floorCarpetAreaRef" name="floorCarpetAreaRef"/>
                                            <input type="text" class="form-control" style="display:none;" id="availableWarehouseFloor"/>
                                            
                                        </div>
                                    </div> 
                                    
                                    
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">Floor Carpet area :</label>                                       
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" id="floorCarpetArea" name="floorCarpetArea"/>
                                          </div>
                                    </div>    
                                    
                                     <div class="form-group">                                        
                                        <label class="col-md-3 control-label" style="color:black;">Number of Palette Postions  :</label>          
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" id="palette_positions" name="palette_positions"/>                                        
                                            
                                        </div>
                                    </div> 
                                               
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">Rack Builtup area :</label>
                                        <div class="col-md-9">
                                            <input type="text" value="" class="form-control" id="rackBuiltupArea" name="rackBuiltupArea"/>                                        
                                            <input type="text" value="" class="form-control" style="display:none;" id="rackBuiltupAreaRef" name="rackBuiltupAreaRef"/>                                        
                                            <input type="text" class="form-control" style="display:none;" id="availableWarehouseRack"/>
                                			<label id="rackErrorLabel" style="display:none;"></label>
                                        
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">Total no of Shutters:</label>
                                        <div class="col-md-9">
                                            <input type="text" value="" class="form-control" id="totalNumberOfDocks" name="totalNumberOfDocks"/>                                        
                                            
                                        </div>
                                    </div>
                                    
                                   
                                  <!--   
                                     <div class="form-group">                                        
                                        <label class="col-md-3 control-label" style="color:black;">Warehouse Address :</label>          
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" id="rackCarpetArea"/>                                        
                                            
                                        </div> -->
                                    </div> 
                                                                                               
                                   <!--  <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">Date of birth:</label>
                                        <div class="col-md-9">
                                            <input type="text" class="form-control datepicker" name="date"/>
                                            <span class="help-block">required date</span>
                                        </div>
                                    </div> -->
                                                                                                                                                             
                                </div>                                               
                                </form>
                                                                 
                                </div>
                            </div>
                            <!-- END BASIC TABLE SAMPLE -->

						</div>

						<!-- <div class="col-md-2" style="">
						
							<button class="btn btn-info btn-rounded pull-right" id="saveWarehouseInfo" style="background:white;">
								Save Info <span class="fa fa-save fa-right"></span>
							</button>
							
							<button class="btn btn-warning btn-rounded pull-right" id="updateWarehouseInfo" style="background:white;dsiplay:none;">
								Update Info <span class="fa fa-save fa-right"></span>
							</button>
							
							<br/>
							<br/><br/>
							<button class="btn btn-danger btn-rounded pull-right" id="cancelWarehouseInfo" style="background:white;">
								Cancel <span class="fa fa-undo fa-right"></span>
							</button>
							
						</div> -->
				
				
				        </div>

				</div>
		</div>
			
			<div id="readinessDiv" style="display:none;">
				
			<div class="panel-heading ui-draggable-handle" style="background-color: #1aad98;height: 49px;">
						<div class="row">
							<div class="col-md-3">
								<h3 class="panel-title"
									style="font-size: x-large; color: white;">Readiness
									Elements</h3>
							</div>
							<div class="col-md-4" style="float: left;">
								<h3 id="addRETitle" class="panel-title"
									style="margin-top: 5px; display: none; color: white;">Add
									Readiness Element</h3>
								<h3 id="updateRETitle" class="panel-title"
									style="margin-top: 5px; display: none; color: white;">Update
									Readiness Elements</h3>
							</div>
							<div class="col-md-4" style="float: right;">

								<button class="btn btn-info btn-rounded pull-right"	id="addReadiness" style="background: white;">
									Add Readiness Elements <span class="fa fa-plus fa-right"></span>
								</button>

								<button class="btn btn-info btn-rounded pull-right"	id="saveReadinessInfo" style="background: white;">
									Save Info <span class="fa fa-save fa-right"></span>
								</button>

								<button class="btn btn-warning btn-rounded pull-right" id="updateReadinessInfo"	style="background: white; dsiplay: none;">
									Update Info <span class="fa fa-save fa-right"></span>
								</button>

								<button class="btn btn-danger btn-rounded pull-right" id="cancelReadinessInfo" style="background: white;">
									Cancel <span class="fa fa-undo fa-right"></span>
								</button>

							</div>
						</div>
					</div>

				<div class="panel-body"	style="background: rgba(255, 255, 255, 255);">

					<div class="row" id="viewReadinessDiv">
					
					
						<div class="col-md-12" style="background:white;margin-bottom:170px;">
					
 <!-- START BASIC TABLE SAMPLE -->
                            <div class="panel panel-default">
                               
                                <div class="panel-body" style="padding: 22px 70px;margin-left: 200px;">

										<table id="grid3" class="table"></table>
										<div id="pagingDiv3"></div>

										                   
                                </div>
                            </div>
                            <!-- END BASIC TABLE SAMPLE -->

						</div>

					</div>
					
						<div class="row" id="addReadinessDiv" style="display:none;">
				
				
				
				<div class="col-md-12" style="background:white;margin-bottom:170px;">
					
 <!-- START BASIC TABLE SAMPLE -->
                            <div class="panel panel-default">
                             
                                <div class="panel-body">
                                    
                                      <form id="readinessForm" role="form" class="form-horizontal" action="javascript:alert('Form #validate2 submited');">
                                <div class="panel-body">                                    
                                    <div class="form-group" style="display:none;">
                                        <label class="col-md-3 control-label" style="color:black;">Readiness Id :</label>  
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" id="readinessId" disabled/>
                                        </div>
                                    </div>        
                                    
                                     <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">Readiness Element Name :</label>  
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" id="readinessElementName" name="readinessElementName"/>
                                        </div>
                                    </div>    
                                                                                                                                      
                                </div>                                               
                                </form>
                                                                 
                                </div>
                            </div>
                            <!-- END BASIC TABLE SAMPLE -->

						</div>
				
				        </div>

				</div>
				
				
				
				</div>
			
			
				<div id="customerDiv" style="display:none;">
				
			<div class="panel-heading ui-draggable-handle" style="background-color: #1aad98;height: 49px;">
					
				<div class="row">
							<div class="col-md-4">
								<h3 class="panel-title"
									style="font-size: x-large; color: white;">Customer
									Module :</h3>
							</div>
							<div class="col-md-4" style="float: left;">
								<h3 id="addCustomerTitle" class="panel-title" style="margin-top: 5px; display: none; color: white;">Add Customer</h3>
								<h3 id="updateCustomerTitle" class="panel-title"	style="margin-top: 5px; display: none; color: white;">Update Csutomer</h3>
							</div>
							<div class="col-md-4" style="float: right;">

								<button class="btn btn-info btn-rounded pull-right"	id="addCustomer" style="background: white;">
									Add Customer <span class="fa fa-plus fa-right"></span>
								</button>

								<button class="btn btn-info btn-rounded pull-right"	id="saveCustomerInfo" style="background: white;">
									Save Info <span class="fa fa-save fa-right"></span>
								</button>

								<button class="btn btn-warning btn-rounded pull-right" id="updateCustomerInfo" style="background: white; dsiplay: none;">
									Update Info <span class="fa fa-save fa-right"></span>
								</button>
																
								<button class="btn btn-danger btn-rounded pull-right" id="cancelCustomerInfo" style="background: white;">
									Cancel <span class="fa fa-undo fa-right"></span>
								</button>
							</div>
						</div>
			
			
			
			
				</div>

				<div class="panel-body"	style="background: rgba(255, 255, 255, 255);">




					<div class="row" id="viewCustomerDiv">
					
					
						<div class="col-md-12" style="background:white;margin-bottom:170px;">
					
 <!-- START BASIC TABLE SAMPLE -->
                            <div class="panel panel-default">
                 
                                <div class="panel-body" style="padding: 22px 30px;">

										<table id="customerGrid" class="table"></table>
										<div id="pagingDiv2"></div>

										                   
                                </div>
                            </div>
                            <!-- END BASIC TABLE SAMPLE -->

						</div>


					</div>
					
						<div class="row" id="addCustomerDiv" style="display:none;">
				
							<div class="col-md-12" style="background:white;margin-bottom:170px;">
					
			<!-- START BASIC TABLE SAMPLE -->
                            <div class="panel panel-default">
                                    
									<div class="panel-body">
                                    
                                      <form id="myFormCustomer" class="form-horizontal">
                                <div class="panel-body">                                    
                                    <div class="form-group" style="display:none;">
                                        <label class="col-md-3 control-label" style="color:black;">SalesPipeLine :</label>  
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" id="customer_id"/>
                                         </div>
                                    </div>
                                    
                         <div class="row">           
                         <div class="col-md-8">
                                     <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">Customer Name :</label>  
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" id="customer_name" name="customer_name"/>
                                         
                                        </div>
                                    </div>
                                    
                                    </div>
                                    </div>
                                 
                                 <br/>
                                    <hr/>
                                    <div class="row">
                                <div class="col-md-6">
                                    
                                    
                                    <div class="form-group">
                                    <span class="fa fa-user col-md-6 control-label"></span> Primary Contact  
                                    </div>
                                    <hr style="width: 256px;margin-left: 200px;color: blue;"/>
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Contact Name :</label>                                        
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="contact_name_1" name="contact_name_1"/>                                        
                                          
                                        </div>
                                    </div>      
                                    
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Contact Number:</label>                                       
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="contact_number_1" name="contact_number_1"/>
                                            
                                        </div>
                                    </div>              
                                   
                                     <div class="form-group">                                        
                                        <label class="col-md-6 control-label" style="color:black;"> Email - Id :</label>          
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="contact_email_id_1" name="contact_email_id_1"/>                                        
                                         
                                        </div>
                                    </div>  
                                                 
                                    
                                   
                                 </div>
                         
                      
                                        
                         <div class="col-md-6" >
                             <div class="form-group">
                                    <span class="fa fa-user col-md-6 control-label"></span> Secondary Contact  
                                    </div>
                                    <hr style="width: 256px;margin-left: 200px;color: blue;"/>
                                     <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Contact Name :</label>                                        
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="contact_name_2" name="contact_name_2"/>                                        
                                          
                                        </div>
                                    </div>      
                                    
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Contact Number:</label>                                       
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="contact_number_2" name="contact_number_2"/>
                                            
                                        </div>
                                    </div>              
                                   
                                     <div class="form-group">                                        
                                        <label class="col-md-6 control-label" style="color:black;"> Email - Id :</label>          
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="contact_email_id_2" name="contact_email_id_2"/>                                        
                                         
                                        </div>
                                    </div> 
                                   
                                    
                                   
                                    </div>
                                     
                                    </div>
                                      
                                      </div>                                               
                               </form>  
                                                                 
                                </div>
                            </div>
                            <!-- END BASIC TABLE SAMPLE -->

						</div>
						</div>
						</div>
						</div>
						
					
					<div id="salesPipeLineDiv" style="display:none;">
				
			<div class="panel-heading ui-draggable-handle" style="background-color: #1aad98;height: 49px;">
					
				<div class="row">
							<div class="col-md-4">
								<h3 class="panel-title"
									style="font-size: x-large; color: white;">SalesPipeLine
									Module :</h3>
							</div>
							<div class="col-md-4" style="float: left;">
								<h3 id="addSPLTitle" class="panel-title" style="margin-top: 5px; display: none; color: white;">Add SalesPipeLine</h3>
								<h3 id="updateSPLTitle" class="panel-title"	style="margin-top: 5px; display: none; color: white;">Update SalesPipeLine</h3>
							</div>
							<div class="col-md-4" style="float: right;">

								<button class="btn btn-info btn-rounded pull-right"	id="addSalesPipeLine" style="background: white;">
									Add SalesPipeLine <span class="fa fa-plus fa-right"></span>
								</button>

								<button class="btn btn-info btn-rounded pull-right"	id="saveSalesPipeLineInfo" style="background: white;">
									Save Info <span class="fa fa-save fa-right"></span>
								</button>

								<button class="btn btn-warning btn-rounded pull-right" id="updateSalesPipeLineInfo" style="background: white; dsiplay: none;">
									Update Info <span class="fa fa-save fa-right"></span>
								</button>
																
								<button class="btn btn-danger btn-rounded pull-right" id="cancelSalesPipeLineInfo" style="background: white;">
									Cancel <span class="fa fa-undo fa-right"></span>
								</button>
							</div>
						</div>
			
			
			
			
				</div>

				<div class="panel-body"	style="background: rgba(255, 255, 255, 255);">




					<div class="row" id="viewSalesPipeLineDiv">
					
					
						<div class="col-md-12" style="background:white;margin-bottom:170px;">
					
 <!-- START BASIC TABLE SAMPLE -->
                            <div class="panel panel-default">
                     <!--            <div class="panel-heading">
                                    <h3 class="panel-title" style="margin-top:5px;">Information</h3>
                                </div> -->
                                <div class="panel-body" style="padding: 22px 30px;">

										<div class="row">
                                       <div class="col-md-9">
                                       <h3> </h3> 
                                       </div>
                                       <div class="col-md-3">
                                       <select id="statusFilterSPL" class="form-control">
                                       <option value="wIP"> Work in Progress</option>
                                       <option value="confirmed"> Agreement Signed</option>
                                       <option value="billable"> Billable</option>
                                       <option value="closed"> Closed</option>
                                       </select>
                                        </div>
                                       
										</div>
										<br/>
										<table id="grid2" class="table"></table>
										<div id="pagingDiv2"></div>

										                   
                                </div>
                            </div>
                            <!-- END BASIC TABLE SAMPLE -->

						</div>


					</div>
					
						<div class="row" id="addSalesPipeLineDiv" style="display:none;">
				
				
				
				<div class="col-md-12" style="background:white;margin-bottom:170px;">
					
 <!-- START BASIC TABLE SAMPLE -->
                            <div class="panel panel-default">
                              <!--   <div class="panel-heading">
                                    <h3 id="addSPLTitle" class="panel-title" style="margin-top:5px;">Add SalesPipeLine </h3>
                                    <h3 id="updateSPLTitle" class="panel-title" style="margin-top:5px;display:none;">Update SalesPipeLine </h3>
                                </div> -->
                                
                                
                                    
                                <div class="panel-body">
                                    
                                      <form id="myForm" class="form-horizontal">
                                <div class="panel-body">                                    
                                    <div class="form-group" style="display:none;">
                                        <label class="col-md-3 control-label" style="color:black;">SalesPipeLine :</label>  
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" id="sp_Id"/>
                                         </div>
                                    </div>
                                    
                         <div class="row">           
                         <div class="col-md-6">
                                     <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">Customer Name :</label>  
                                        <div class="col-md-9">
                                       <!--      <input type="text" class="form-control" id="customerName" name="customerName"/>
                                       -->  
                                            <select class="form-control" id="customerName" name="customerName"></select>
                                       
                                        </div>
                                    </div>
                                    
                                    </div>
                                    
                                     <div class="col-md-6">
                                     <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">Customer Type :</label>  
                                        <div class="col-md-9">
                                          <select class="form-control" id="customerType" name="customerType">
                                          <option value="subLease">Sub Lease</option>
                                       <option value="3PL">3 PL</option>
                                       <option value="temporary">Temporary</option>
                                       <option value="4PL">4 PL</option>
                                          </select>
                                       
                                        </div>
                                    </div>
                                    
                                    </div>
                                    
                                    
                                    </div>
                                 
                                 <br/>
                                    <div class="row">
                                    <div class="col-md-4">
                                    
                                     <!--  <div class="btn-group bootstrap-select form-control select">
                                      -->   <label class="col-md-7 control-label">Select Warehouse :</label>
                                        <div class="col-md-5">                                        
                                            <select class="form-control" id="allocatedWarehouse">
                                                <option value="0">Select Warehouse </option>
                                               
                                                
                                            </select>
                                            <input type="text" id="allocatedWarehouseId" style="display:none;">
                                              
                                        </div>
                                    <!-- </div>
                                     --></div> 
                                    <div class="col-md-6">
                                    
                                      <div class="form-group">
                                        
                                      
                                           <div class="col-md-6">                                        
                                        <input type="text" class="form-control" id="availableFloor" style="color:black;" placeholder="Available Space" disabled/>
                                           <span class="help-block" style="color: #fe970a;font-weight: bolder;">Available Floor Area</span>
                                          <input type="text" class="form-control" id="availableFloor2" style="color:black;display:none;" placeholder="Available Space" disabled/>
                                       
                                           </div>
                                          
                                           <div class="col-md-6">                                        
                                        <input type="text" class="form-control" id="availableCarpet" style="color:black;" placeholder="Available Space" disabled/>
                                          <span class="help-block" style="color: #e04b4a;font-weight: bolder;">Available Rack Area</span>
                                           <input type="text" class="form-control" id="availableRack2" style="color:black;display:none;" placeholder="Available Space" disabled/>
                                       
                                           </div>
                                    </div>  
                                    </div>
                                    <div class="col-md-2">
                                     <div class="form-group">
                                        <div class="col-md-12">                                        
                                            <select class="form-control" id="statusWork" >
                                                <option value="wIP">Work In Progress</option>
                                                <option value="confirmed">Agreement Signed</option>
                                                <option value="billable">Billable</option>
                                                <option value="cancel">Canceled</option>
                                            </select>
                                        </div>
                                    </div>
                                    </div>
                                    </div>
                                    <br/><br/>
                                    <div class="row">
                                <div class="col-md-6">
                                     
                                  
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Estimated Floor Builtup Area :</label>                                        
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="estimatedFloorBuiltupArea" name="estimatedFloorBuiltupArea"/>                                        
                                          
                                        </div>
                                    </div>      
                                    
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Estimated Floor Carpet area :</label>                                       
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="estimatedFloorCarpetArea" name="estimatedFloorCarpetArea"/>
                                            
                                        </div>
                                    </div>              
                                   
                                     <div class="form-group">                                        
                                        <label class="col-md-6 control-label" style="color:black;">Pallete Postions:</label>          
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="estimated_palette_positions" name="estimated_palette_positions"/>                                        
                                         
                                        </div>
                                    </div>  
                                                 
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Estimated Rack Builtup area :</label>
                                        <div class="col-md-6">
                                            <input type="text" value="" class="form-control" id="estimatedRackBuiltupArea" name="estimatedRackBuiltupArea"/>                                        
                                          
                                        </div>
                                    </div>
                                    
                                   <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Estimated Revenue :</label>
                                        <div class="col-md-6">
                                            <input type="text" value="" class="form-control" id="estimatedRevenue" name="estimatedRevenue"/>                                   
                                        </div>
                                    </div>
                                    
                                    
                                     <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Estimated Start Date : </label>
                                        <div class="col-md-6">
                                            <input type="date" class="form-control" id="estimatedStartDate" name="estimatedStartDate"/>
                                       
                                        </div>
                                    </div>
                                    
                                     <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Remark : </label>
                                        <div class="col-md-6">
                                            <textarea rows="6" cols="120" id="remark" name="remark" ></textarea>
                                           
                                        </div>
                                    </div>

                                    
                                    </form>
                                     

                                 </div>
                         
                      <!--    <div class="col-md-6 actualData" id="wIP" style="display:none;">
                         <h5>Actual Space Allocated Yet to be Confirmed</h5>
                         </div>
                         
                         <div class="col-md-6 actualData" id="cancel" style="display:none;">
                         <h5>Deal Closed</h5>
                         </div> -->
                                        
                         <div class="col-md-6" id="confirmed">
                              <form id="myFormUpdate" class="form-horizontal">
                                     <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Actual Floor Builtup Area :</label>                                        
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="actualFloorBuiltupArea" name="actualFloorBuiltupArea" disabled/>                                        
                                            
                                        </div>
                                    </div>  
                                     
                                      <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Actual Floor Carpet area :</label>                                       
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="actualFloorCarpetArea" name="actualFloorCarpetArea" disabled/>
                                             <input type="text" id="actualFloorCarpetAreaRef" style="display:none;" disabled/>
                                        </div>
                                    </div>  
                                                                                                  
                                                       
                                                
                                    
                                    <div class="form-group">                                        
                                        <label class="col-md-6 control-label" style="color:black;">Actual Pallete Positions :</label>          
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="actual_palette_positions" name="actual_palette_positions" disabled/>                                        
                                         
                                        </div>
                                    </div>  
                                    
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Actual Rack Builtup area :</label>
                                        <div class="col-md-6">
                                            <input type="text" value="" class="form-control" id="actualRackBuiltupArea" name="actualRackBuiltupArea" disabled/>                                        
                                                 <input type="text" id="actualRackBuiltupAreaRef" style="display:none;" disabled/>
                                     
                                        </div>
                                    </div>
                                    
                                    
                                     <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Actual Revenue:</label>
                                        <div class="col-md-6">
                                            <input type="text" value="" class="form-control" id="actualRevenue" name="actualRevenue" disabled/>                                        
                                          
                                        </div>
                                    </div>
                                    
                                    
                                     <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Actual Start Date : </label>
                                        <div class="col-md-6">
                                            <input type="date" class=" form-control" id="actualStartDate" name="actualStartDate" disabled/>
                                          <!-- mask_date -->
                                        </div>
                                    </div>
                                    
                                     <br/><br/><br/><br/><br/><br/><br/>                                 
                                     <div class="form-group" style="margin-left:120px;">
                                        <div class="col-md-4">
                                        <label></label>
                                        </div>
                                        <div class="col-md-4">
                                        <label></label>
                                        </div>
                                        
                                        <div class="col-md-4">
                                        <div class="row">
                                        <div class="col-md-5">
                                          		 <button class="btn btn-info" id="uploadDocument"><span class="fa fa-upload fa-right"></span></button>
                                          		 </div>
                                          		 <div class="col-md-2">
                                          		 <label></label>
                                          		 </div>
                                          		 <div class="col-md-5">   
                                          	  <button class="btn btn-success" id="downloadDocument"><span class="fa fa-download fa-right"></span></button>
												</div>	
                                        </div>
                                     	</div>
                                    </div>
                                    
                                    
                                    </form>
                                    </div>
                                    </div>
                                                                                                                                                             
                                </div>                                               
                               
                                                                 
                                </div>
                            </div>
                            <!-- END BASIC TABLE SAMPLE -->

						</div>

						
				
				
				
				
				        </div>

				</div>
				
				
				
				</div>


				<div id="readinessTemplateDiv" style="display: none;">

					<div class="panel-heading ui-draggable-handle"
						style="background-color: #1aad98;">
						<div class="row">
							<div class="col-md-4">
								<h3 class="panel-title"
									style="font-size: x-large; color: white;">Readiness Template</h3>
							</div>
							<div class="col-md-4" style="float: left;">
								<h3 id="addRTLTitle" class="panel-title"
									style="margin-top: 5px; display: none; color: white;">Create Readiness Template
									</h3>
								<h3 id="updateRTLTitle" class="panel-title"
									style="margin-top: 5px; display: none; color: white;">Update Readiness Template</h3>

							</div>

							<div class="col-md-4" style="float: right;">
								
								<button class="btn btn-info btn-rounded pull-right"
									id="saveReadinessTemplate"
									style="background: white; display: none;">
									Save <span class="fa fa-save fa-right"></span>
								</button>

								<button class="btn btn-warning btn-rounded pull-right"
									id="updateReadinessTemplate"
									style="background: white; display: none;">
									Update <span class="fa fa-save fa-right"></span>
								</button>

								<button class="btn btn-danger btn-rounded pull-right"
									id="cancelReadinessTemplate"
									style="background: white; display: none;">
									Cancel <span class="fa fa-undo fa-right"></span>
								</button>

							</div>

						</div>
					</div>

					<div class="panel-body"
						style="background: rgba(255, 255, 255, 0.2);">




						<div class="row" id="viewReadinessTemplateDiv" style="display:none;">


							<div class="col-md-12"
								style="background: white; margin-bottom: 170px;">

										<div class="panel panel-default" style="margin-top: 50px;margin-bottom: 200px;">
                                <div class="panel-body" style="margin-top: 20px;">
                                 <div class="form-group">
											<div class="col-md-3">
												<label class="control-label text-left"
													style="font-size: medium;">Create Readiness
													Template </label>
											</div>
											<div class="col-md-1">
												<button class="btn btn-danger btn-rounded pull-right"
													id="addReadinessTemplate" style="background: white;">
													Create <span class="fa fa-file-text-o fa-right"></span>
												</button>
											</div>
											<div class="col-md-3">
												<label class="control-label text-left"
													style="font-size: medium;">Update Readiness
													Templates</label>
											</div>
											<div class="col-md-1">
												<button class="btn btn-warning btn-rounded pull-right"
													id="addReadinessTemplate" style="background: white;">
													Update <span class="fa fa-pencil fa-right"></span>
												</button>
											</div>

											<div class="col-md-3">
												<label class="control-label text-left"
													style="font-size: medium;">View Readiness Templates</label>
											</div>
											<div class="col-md-1">
												<button class="btn btn-info btn-rounded pull-right"
													id="viewReadinessTemplate" style="background: white;">
													View <span class="fa fa-pencil fa-right"></span>
												</button>
											</div>
										</div>                                    
                                        
                                        </div>
                                      
                                </div>
                            </div>


								<!-- END BASIC TABLE SAMPLE -->

							</div>


						</div>

						<div class="row" id="addReadinessTemplateDiv" style="display:none;">



							<div class="col-md-12"
								style="background: white; margin-bottom: 170px;">

								<!-- START BASIC TABLE SAMPLE -->
								<div class="panel panel-default">

									<div class="panel-body">

										<form id="jvalidate" role="form" class="form-horizontal"
											action="javascript:alert('Form #validate2 submited');">
											<div class="panel-body">
											
												<div class="form-group">
												    <div class="col-md-3">
													<label class="control-label" style="color: black;">Customer Name</label>
													</div> 
													<div class="col-md-3">
											<select class="form-control select" id="customerNameRT">
                                              <option value="0">Select Customer </option>
                                            </select>
													</div>
											
													<div class="col-md-3 control-label" style="color: black;">Readiness Elements </div>
													<div class="col-md-3">
														<select multiple class="form-control select" id="readinessElementNameRT">
                                                <option>Select Elements </option>
                                                         </select>  
													</div>
												</div>
												


											</div>
										</form>

									</div>
								</div>
								<!-- END BASIC TABLE SAMPLE -->

							</div>
						</div>

					</div>

<div id="reportRTDiv" style="display:none;">
<div class="row">

<div class="col-md-4">

<input type="text" id="reportSalesId" />

</div>

<div class="col-md-8">

<table id="gridRT" class="table"></table>
										<div id="pagingDiv5"></div>


</div>




</div>
</div>




                <div id="reportDiv" style="display:none">
                  
                  
                  		
			<div class="panel-heading ui-draggable-handle" style="background-color: #1aad98;height: 49px;">
					
				<div class="row">
							<div class="col-md-4">
								<h3 class="panel-title"
									style="font-size: x-large; color: white;">Aging Report</h3>
							</div>
							<div class="col-md-4" style="float: left;">
								</div>
							<div class="col-md-4" style="float: right;">

								
							</div>
						</div>
			
			
			
			
				</div>

				<div class="panel-body"	style="background: rgba(255, 255, 255, 255);">




					<div class="row" id="viewFilterDiv">
					
					
						<div class="col-md-12" style="background:white;margin-bottom:170px;">
					
 <!-- START BASIC TABLE SAMPLE -->
                            <div class="panel panel-default">
                                
                                <div class="panel-body" style="padding: 22px 30px;">

										<table id="grid5" class="table"></table>
										<div id="pagingDiv5"></div>

										                   
                                </div>
                         <div class="panel-footer text-center">
                            
                                    <div class="form-group">
                                         <div class="col-md-12">
                                            <button class="btn btn-info btn-rounded" id="excelPort">Download as Excel</button>
                                      </div>
                                      </div> 
                        </div>
                            </div>
                            <!-- END BASIC TABLE SAMPLE -->

						</div>
					<!-- 	<div class="col-md-3" id="filterBox">
						 <div class="panel panel-primary">
                            <div class="panel-heading" style="background:white;">
                                <h3 class="panel-title" style="color:black;"><span class="fa fa-tasks"></span> Filter Box :</h3>                                
                                <div class="pull-right">
                                    <button class="btn btn-info btn-rounded" id="applyFilter">Apply Filter</button>
                                </div>
                            </div>
                            <div class="panel-body list-group scroll" style="height: 260px;">                                
                               
                                <div class="panel-body">                                    
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">Work Status</label>  
                                        <div class="col-md-9">
                                            <select class="form-control" id="statusWorkFilter" >
                                                <option value="0">Select Status</option>
                                                <option value="wIP">Work In Progress</option>
                                                <option value="confirmed">Confirmed</option>
                                                <option value="cancel">Canceled</option>
                                            </select>
                                        </div>
                                      </div>                                                                                               
                                </div>                           
                            </div>     
                            <div class="panel-footer text-center">
                              
                            </div>                            
                        </div> 
						</div> -->


					</div>
					
						<div class="row" id="addFilterDiv" style="display:none;">
				
				
				
				<div class="col-md-12" style="background:white;margin-bottom:170px;">
					
 <!-- START BASIC TABLE SAMPLE -->
                            <div class="panel panel-default">
                              <!--   <div class="panel-heading">
                                    <h3 id="addSPLTitle" class="panel-title" style="margin-top:5px;">Add SalesPipeLine </h3>
                                    <h3 id="updateSPLTitle" class="panel-title" style="margin-top:5px;display:none;">Update SalesPipeLine </h3>
                                </div> -->
                                <div class="panel-body">
                                    
                                      <form id="jvalidate" role="form" class="form-horizontal" action="javascript:alert('Form #validate2 submited');">
                                <div class="panel-body">                                    
                                    <div class="form-group" style="display:none;">
                                        <label class="col-md-3 control-label" style="color:black;">SalesPipeLine :</label>  
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" id="sp_Id"/>
                                         </div>
                                    </div>
                                    
                         <div class="row">           
                         <div class="col-md-8">
                                     <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">Customer Name :</label>  
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" id="customerName"/>
                                         
                                        </div>
                                    </div>
                                    
                                    </div>
                                    </div>
                                 
                                 <br/>
                                    <div class="row">
                                    <div class="col-md-4">
                                    
                                      <div class="btn-group bootstrap-select form-control select">
                                        <label class="col-md-7 control-label">Select Warehouse :</label>
                                        <div class="col-md-5">                                        
                                            <select class="form-control" id="allocatedWarehouse">
                                                <option value="0">Select Warehouse </option>
                                               
                                                
                                            </select>
                                              
                                        </div>
                                    </div>
                                    </div> 
                                    <div class="col-md-6">
                                    
                                      <div class="form-group">
                                        
                                      
                                           <div class="col-md-6">                                        
                                        <input type="text" class="form-control" id="availableFloor" style="color:black;" placeholder="Available Space" disabled/>
                                           <span class="help-block" style="color: #fe970a;font-weight: bolder;">Available Floor Area</span>
                                           </div>
                                          
                                           <div class="col-md-6">                                        
                                        <input type="text" class="form-control" id="availableCarpet" style="color:black;" placeholder="Available Space" disabled/>
                                          <span class="help-block" style="color: #e04b4a;font-weight: bolder;">Available Rack Area</span>
                                           </div>
                                    </div>  
                                    </div>
                                    <div class="col-md-2">
                                     <div class="form-group">
                                        <div class="col-md-12">                                        
                                            <select class="form-control select" id="statusWork" >
                                                <option value="0">Select Status</option>
                                                <option value="wIP">Work In Progress</option>
                                                <option value="confirmed">Confirmed</option>
                                                <option value="cancel">Canceled</option>
                                            </select>
                                        </div>
                                    </div>
                                    </div>
                                    </div>
                                    <br/><br/>
                                    <!-- <div class="row">
                                <div class="col-md-6">
                                     <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Estimated Floor Carpet area :</label>                                       
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="estimatedFloorCarpetArea"/>
                                            
                                        </div>
                                    </div> 
                                    
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Estimated Floor Builtup Area :</label>                                        
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="estimatedFloorBuiltupArea"/>                                        
                                          
                                        </div>
                                    </div>                   
                                   
                                     <div class="form-group">                                        
                                        <label class="col-md-6 control-label" style="color:black;">Estimated Rack Carpet area :</label>          
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="estimatedRackCarpetArea"/>                                        
                                         
                                        </div>
                                    </div>  
                                                 
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Estimated Rack Builtup area :</label>
                                        <div class="col-md-6">
                                            <input type="text" value="" class="form-control" id="estimatedRackBuiltupArea"/>                                        
                                          
                                        </div>
                                    </div>
                                    
                                  
                                    
                                     <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Estimated Start Date : </label>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control datepicker" name="date" id="estimatedStartDate"/>
                                       
                                        </div>
                                    </div>
                                 </div>
                         
                         <div class="col-md-6 actualData" id="wIP" style="display:none;">
                         <h5>Actual Space Allocated Yet to be Confirmed</h5>
                         </div>
                         
                         <div class="col-md-6 actualData" id="cancel" style="display:none;">
                         <h5>Deal Closed</h5>
                         </div>
                                        
                         <div class="col-md-6 actualData" id="confirmed">
                              
                                      <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Actuallll Floor Carpet area :</label>                                       
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="actualFloorCarpetArea"/>
                                             
                                        </div>
                                    </div>  
                                                                                                  
                                     <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Actual Floor Builtup Area :</label>                                        
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="actualFloorBuiltupArea" />                                        
                                            
                                        </div>
                                    </div>                    
                                                
                                    
                                    <div class="form-group">                                        
                                        <label class="col-md-6 control-label" style="color:black;">Actual Rack Carpet area :</label>          
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="actualRackCarpetArea" />                                        
                                         
                                        </div>
                                    </div>  
                                    
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Actual Rack Builtup area :</label>
                                        <div class="col-md-6">
                                            <input type="text" value="" class="form-control" id="actualRackBuiltupArea" />                                        
                                         
                                        </div>
                                    </div>
                                    
                                     <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Actual Start Date : </label>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control datepicker" name="date" id="actualStartDate" />
                                          
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Remark : </label>
                                        <div class="col-md-6">
                                            <textarea rows="5" cols="25" id="remark" ></textarea>
                                           
                                        </div>
                                    </div>
                                    
                                    </div>
                                    </div> -->
                                                                                                                                                             
                                </div>                                               
                                </form>
                                                                 
                                </div>
                            </div>
                            <!-- END BASIC TABLE SAMPLE -->

						</div>

						
				
				        </div>

				</div>
				
                  
                  
                  
				</div>
				

				
				<div id="areaReportDiv" style="display:none">
					<div class="panel-heading ui-draggable-handle" style="background-color: #1aad98;height: 49px;">

						<div class="row">
							<div class="col-md-4">
								<h3 class="panel-title"
									style="font-size: x-large; color: white;">Area Report</h3>
							</div>
							<div class="col-md-4" style="float: left;"></div>
							<div class="col-md-4" style="float: right;"></div>
						</div>




					</div>

					<div class="panel-body"	style="background: rgba(255, 255, 255, 255);">
                           	<div class="row" id="viewFilterDiv">
                        	<div class="col-md-12"	style="background: white; margin-bottom: 170px;">

								<!-- START BASIC TABLE SAMPLE -->
								<div class="panel panel-default">
								
									<div class="panel-body" style="padding: 22px 30px;">
										<div class="row">
                                       <div class="col-md-2">
                                       <h3> Client Status : </h3> 
                                       </div>
                                       <div class="col-md-3">
                                       <select id="clientStatusFilter" class="form-control">
                                       <option value="wIP"> Work in Progress</option>
                                       <option value="confirmed"> Agreement Signed</option>
                                       <option value="billable"> Billable</option>
                                       </select>
                                        </div>
                                        <div class="col-md-3">
                                        <button class="btn btn-warning btn-rounded" id="clientStatusFilterButton">Apply Filter</button>
										</div>
										</div>
										<br/><br/>
										<table id="areaGrid" class="table"></table>
										<div id="pagingDiv5"></div>


									</div>
									<div class="panel-footer text-center">

										<div class="form-group">
											<div class="col-md-12">
												<button class="btn btn-info btn-rounded" id="excelAreaPort">Download
													as Excel</button>
											</div>
										</div>
									</div>
								</div>
								<!-- END BASIC TABLE SAMPLE -->

							</div>



						</div>

					</div>




				</div>



	
				
				<div id="clientReportDiv" style="display:none">
					<div class="panel-heading ui-draggable-handle"
						style="background-color: #1aad98;height: 49px;">

						<div class="row">
							<div class="col-md-4">
								<h3 class="panel-title"
									style="font-size: x-large; color: white;">Client Report</h3>
							</div>
							<div class="col-md-4" style="float: left;"></div>
							<div class="col-md-4" style="float: right;"></div>
						</div>




					</div>

					<div class="panel-body"	style="background: rgba(255, 255, 255, 255);">
                           	<div class="row" id="viewFilterDiv">
                        	<div class="col-md-12"	style="background: white; margin-bottom: 170px;">

								<!-- START BASIC TABLE SAMPLE -->
								<div class="panel panel-default">
									
									<div class="panel-body" style="padding: 22px 30px;">
										
											<div class="row">
                                       <div class="col-md-2">
                                       <h3> Warehouse : </h3> 
                                       </div>
                                       <div class="col-md-3">
                                       <select id="clientWarehouseFilter" class="form-control">
                                       </select>
                                        </div>
                                        <div class="col-md-3">
                                        <button class="btn btn-warning btn-rounded" id="clientWarehouseFilterButton">Apply Filter</button>
										</div>
										</div>
										<br/><br/>
										
										<table id="clientGrid" class="table"></table>
										<div id="pagingDiv5"></div>


									</div>
									<div class="panel-footer text-center">

										<div class="form-group">
											<div class="col-md-12">
												<button class="btn btn-info btn-rounded" id="excelClientPort">Download
													as Excel</button>
											</div>
										</div>
									</div>
								</div>
								<!-- END BASIC TABLE SAMPLE -->

							</div>



						</div>

					</div>




				</div>


	<div id="readinessTemplateReportDiv" style="display:none">
					<div class="panel-heading ui-draggable-handle"
						style="background-color: #1aad98;height: 49px;">

						<div class="row">
							<div class="col-md-4">
								<h3 class="panel-title"
									style="font-size: x-large; color: white;">Readiness Report</h3>
							</div>
							<div class="col-md-4" style="float: left;"></div>
							<div class="col-md-4" style="float: right;"></div>
						</div>




					</div>

					<div class="panel-body"	style="background: rgba(255, 255, 255, 255);">
                           	<div class="row" id="viewFilterDiv">
                        	<div class="col-md-12"	style="background: white; margin-bottom: 170px;">

								<!-- START BASIC TABLE SAMPLE -->
								<div class="panel panel-default">
									
									<div class="panel-body" style="padding: 22px 30px;">
                                       <div class="row">
                                       <div class="col-md-2">
                                       <h3> CLient Name : </h3> 
                                       </div>
                                       <div class="col-md-5">
                                       <select id="clientRTName" class="form-control"></select>
                                        </div>
                                        <div class="col-md-3">
                                        <button class="btn btn-warning btn-rounded" id="clientRTButton">Apply Filter</button>
										</div>
										</div>
										<br/><br/>
										<table id="readinessTemplateReportGrid" class="table"></table>
										<div id="pagingDiv5"></div>


									</div>
									<div class="panel-footer text-center">

										<div class="form-group">
											<div class="col-md-12">
												<button class="btn btn-info btn-rounded" id="excelReadinessPort">Dowload
													as Excel</button>
											</div>
										</div>
									</div>
								</div>
								<!-- END BASIC TABLE SAMPLE -->

							</div>



						</div>

					</div>




				</div>



			</div>
                <!-- END PAGE CONTENT WRAPPER -->                
            </div>            
            <!-- END PAGE CONTENT -->
        </div>
        <!-- END PAGE CONTAINER -->
  <!-- ADD WAREHOUSE -->

		 <div id="" class="message-box animated fadeIn" data-sound="alert" id="mb-signout">
            <div class="mb-container" style="position: static; margin-top: 50px;">
                <div class="mb-middle" style="background-color:white;">
                    <div class="mb-title"><span class="fa fa-sign-out"></span> Add Warehouse</div>
                    <div class="mb-content" style="background-color:white;">
                        <div class="block">
                                 <form id="jvalidate" role="form" class="form-horizontal" action="javascript:alert('Form #validate2 submited');">
                                <div class="panel-body">                                    
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">Login:</label>  
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" name="login"/>
                                            <span class="help-block">min size = 2, max size = 8</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">Password:</label>                                        
                                        <div class="col-md-9">
                                            <input type="password" class="form-control" name="password" id="password2"/>                                        
                                            <span class="help-block">min size = 5, max size = 10</span>
                                        </div>
                                    </div>                    
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">Confirm Password:</label>                                       
                                        <div class="col-md-9">
                                            <input type="password" class="form-control" name="re-password"/>
                                            <span class="help-block">required same value as Password</span>
                                        </div>
                                    </div>               
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">E-mail:</label>
                                        <div class="col-md-9">
                                            <input type="text" value="" name="email" class="form-control"/>                                        
                                            <span class="help-block">required email</span>
                                        </div>
                                    </div>
                                    <div class="form-group">                                        
                                        <label class="col-md-3 control-label" style="color:black;">Age:</label>          
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" name="age"/>                                        
                                            <span class="help-block">min size = 18, max size = 100</span>
                                        </div>
                                    </div>                                                             
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" style="color:black;">Date of birth:</label>
                                        <div class="col-md-9">
                                            <input type="text" class="form-control datepicker" name="date"/>
                                            <span class="help-block">required date</span>
                                        </div>
                                    </div>
                                                                                                                           
                                    <div class="btn-group pull-right">
                                        <button class="btn btn-primary" type="button" onClick="jvalidate.resetForm();$('#gender').next('.bootstrap-select').removeClass('error').removeClass('valid')">Hide prompts</button>
                                        <button class="btn btn-primary" type="submit">Submit</button>
                                    </div>                                                                                                                          
                                </div>                                               
                                </form>
                            <!-- END JQUERY VALIDATION PLUGIN -->
                            </div>
						
						
                    </div>
                    <div class="mb-footer">
                        <div class="pull-right">
                            <a href="pages-login.html" class="btn btn-success btn-lg">Yes</a>
                            <button class="btn btn-default btn-lg mb-control-close">No</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
		  <!-- END PAGE ADD Warehouse -->

		
        <!-- MESSAGE BOX-->
        <div class="message-box animated fadeIn" data-sound="alert" id="logoutDiv" style="display:none;">
            <div class="mb-container">
                <div class="mb-middle">
                    <div class="mb-title"><span class="fa fa-sign-out"></span> Log <strong>Out</strong> ?</div>
                    <div class="mb-content">
                        <p>Are you sure you want to log out?</p>                    
                        <p>Press No if youwant to continue work. Press Yes to logout current user.</p>
                    </div>
                    <div class="mb-footer">
                        <div class="pull-right">
                            <a href="index.jsp" class="btn btn-success btn-lg">Yes</a>
                            <a id="hideLogout" class="btn btn-default btn-lg mb-control-close">No</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
		
		<!-- ERROR MESSAGE BOX-->
        <div class="message-box message-box-info animated fadeIn" data-sound="alert" id="warningDiv" style="display:none;">
            <div class="mb-container" style="width: 630px;margin-left: 370px;">
                <div class="mb-middle">
                    <div class="mb-title"><span class="fa fa-warning"></span>Warning ?</div>
                    <div class="mb-content">
                        <p id="warningPara" style="font-size: small"></p>                    
                       
                    </div>
                    <div class="mb-footer">
                        <div class="pull-right">
                            <a id="hideWarning" class="btn btn-default btn-lg mb-control-close">Okay</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	
		<!-- ALERT MESSAGE BOX-->
        <div class="message-box message-box-success animated fadeIn" data-sound="alert" id="alertDiv" style="display:none;">
            <div class="mb-container" style="width: 430px;margin-left: 430px;background: #1aad98;">
                <div class="mb-middle" style="left: 15%;">
                    <div class="mb-title" style="width: 290px;font-size: 19px;"><span class="fa fa-warning"></span>Do you want to continue ?</div>
                    <div class="mb-content">
                        <input type="text" id="alertPara" style="font-size: small;display:none;" />                    
                       
                       <input type="text" id="alertSalesPipeLineId" style="font-size: small;display:none;" />                    
                       <input type="text" id="alertWarehousId" style="font-size: small;display:none;" />                    
                       <input type="text" id="alertFloorCarpertArea" style="font-size: small;display:none;" />                    
                       <input type="text" id="alertRackArea" style="font-size: small;display:none;" />                    
                      
                       
                    </div>
                    <div class="mb-footer">
                        <div class="pull-left" style="margin-left: 43px;">
                            <a id="doWarehouseOperation" class="btn btn-default btn-lg mb-control-close" style="dispay:none;">Yes</a>
                        </div>
                        <div class="pull-left" style="margin-left: 43px;">
                            <a id="doReadinessOperation" class="btn btn-default btn-lg mb-control-close" style="dispay:none;">Yes</a>
                        </div>
                         <div class="pull-left" style="margin-left: 43px;">
                            <a id="doSalesPipeLineOperation" class="btn btn-default btn-lg mb-control-close" style="dispay:none;">Yes</a>
                        </div>
                        <div class="pull-right">
                            <a id="hideAlert" class="btn btn-default btn-lg mb-control-close">No</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
		
		<div class="message-box animated fadeIn" data-sound="alert" id="readinessTemplate" style="display:none;">
            <div class="mb-container" style="background:white;width: 975px;margin-left: 206px;margin-top: -199px;height: 610px;">
                <div class="mb-middle" style="left:0.1%;background-color: #1aad98;">
                    <div class="mb-title" style="background-color: #1aad98;width: 970px;height: 70px;margin-top: -20px;margin-left: -21px;"> 
                    <div class="row">
                    <div class="col-md-6">
                    <h3 style="color: #f5f5f5;margin-left: 50px;"> Readiness Template </h3>
                    </div>
                   
                    <div class="col-md-6">
                     <button class="btn btn-info btn-rounded " id="singleAdd" style="background: white;margin-left: 150px;">Add Element</button> 
                    <input type="text" id="readinessSalesPipeLineId" class="form-control" style="display:none;" disabled>
                    <button class="btn btn-info btn-rounded " id="bulkSave" style="background: white;">Save</button> 
                    <button class="btn btn-warning btn-rounded" id="bulkUpdate" style="background: white;">Update <!-- <span class="fa fa-save"></span> --></button>  
                    <button class="btn btn-danger btn-rounded" id="bulkUndo" style="background: white;">Undo <!-- <span class="fa fa-save"></span> --></button>  
                    <button class="btn btn-default btn-rounded " id="cancelReadinessTemplateDailog" style="float:right;background: white;margin-right:10px;margin-top:5px;"> Close<!-- <span class="fa fa-times"></span> --></button>
                    
                    </div>
                    
                    </div>
                    </div>
                    <div class="mb-content" style="width: 703px;">
                    <div class="row">
                    <div class="col-md-3">
                    <h5 style="color:black;font-size: medium;float:right;">Company Name : </h5>
                    </div>
                    <div class="col-md-3">
                    <input type="text" id="readinessTemplateCompanyName" class="form-control" style="font-size: medium;background: white;font-size: medium;color: black;border:white;" disabled>
                    </div>
                    <div class="col-md-7">
                    
                    </div>
                    </div>
                    <div id="addReadinessTemplateGrid" style="display:none;">
                        <table id="inlineGrid" class="table"></table>
										<div id="pagingDiv4"></div>
                        </div>
                       <div id="editReadinessTemplateGrid" style="display:none;">
                        <table id="inlineEditGrid" class="table"></table>
										<div id="inlineEditPaging" style="color: white;background: #1aad98;"></div>
                        </div>   
                          
                    </div>
                    <div class="mb-footer">
                      
                    </div>
            </div>
        </div>
        </div>
        
         <div class="message-box animated fadeIn" data-sound="alert" id="editReadinessTemplateDiv" style="display:none;">
            <div class="mb-container" style="background:#818181;width: 930px;margin-left: 376px;margin-top: -139px;height: 0px;">
                <div class="mb-middle" style="left:0.1%;">
        <div class="panel panel-primary animated zoomIn xn-drop-left xn-panel-dragging" style="width: 470px;">
                            <div class="panel-heading" style="background:white;">
                                <h3 class="panel-title" style="color:black;display:none;" id="addReadinessOrderTitle"><span class="fa fa-tasks"></span> Add Readiness Order </h3>                                
                                 <h3 class="panel-title" style="color:black;display:none;" id="updateReadinessOrderTitle" ><span class="fa fa-tasks"></span> Update Readiness Order </h3>                                
                               <div class="pull-right">
                                    <button class="label label-warning" id="cancelReadinessOrder">X</button>
                                </div>
                            </div>
                            <div class="panel-body list-group scroll" style="height: 260px;">                                
                               
                                <div class="panel-body">                                    
                                    <form id="readinessTemplateForm">
                                    <div class="form-group" style="display:none;">
                                        <label class="col-md-3 control-label" style="color:black;">SPL Id :</label>  
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" id="rowNumber"/>
                                           
                                        </div>
                                    </div>
                                    
                                    <div class="form-group" style="display:none;">
                                        <label class="col-md-3 control-label" style="color:black;">SPL Id :</label>  
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" id="readinessTemplateEditId"/>
                                           
                                        </div>
                                    </div>
                                 
                                            
                                  <div class="form-group" style="display:none;">
                                        <label class="col-md-3 control-label" style="color:black;">SPL Id :</label>  
                                        <div class="col-md-9">
                                                <select class="form-control" id="elementReadiness">
                                                <option value="0">Select Elements </option>
                                            </select> 
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Element Name :</label>  
                                        <div class="col-md-6">
                                            
                                           <select class="form-control" id="readinessTemplateEditCustomerName">
                                                <option value="0">Select Elements </option>
                                            </select> 
                                        </div>
                                    </div>
                                    
                                    
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Readiness Quantity :</label>                                       
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="readinessTemplateEditQuantity" name="readinessTemplateEditQuantity" />
                                             
                                        </div>
                                    </div>    
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Readiness Owner Name :</label>                                        
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" id="readinessTemplateEditOwnerName" name="readinessTemplateEditOwnerName"/>                                        
                                            
                                        </div>
                                    </div> 
                                    
                                     <div class="form-group">                                        
                                        <label class="col-md-6 control-label" style="color:black;">Readiness Element Status :</label>          
                                        <div class="col-md-6">
                                            <select class="form-control" id="readinessTemplateEditElementStatus" name="readinessTemplateEditElementStatus" >
                                                <option value="wIP">Work In Progress</option>
                                                <option value="confirmed">Confirmed</option>
                                                <option value="cancel">Canceled</option>
                                            </select>                                       
                                            
                                        </div>
                                    </div> 
                                    
                                               
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Readiness Start Date :</label>
                                        <div class="col-md-6">
                                            <input type="date" value="" class=" form-control" id="readinessTemplateEditStartDate" name="readinessTemplateEditStartDate"/>                                        
                                            
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" style="color:black;">Readiness End Date:</label>
                                        <div class="col-md-6">
                                            <input type="date" value="" class=" form-control" id="readinessTemplateEditEndDate" name="readinessTemplateEditEndDate"/>                                        
                                        </div>
                                    </div>                                                                                                                     
                                </form>
                                </div>                        
                            </div>     
                            <div class="panel-footer text-center">
                                <button class="btn btn-info btn-rounded pull-right" id="readinessTemplateEditButton" style="background: white; ">
									 <span class="fa fa-save fa-right"></span>
								</button>

								<button class="btn btn-primary btn-rounded pull-right" id="addReadinessTemplateButton" style="background: white;">
									 <span class="fa fa-save fa-right">Add</span>
								</button>
                            </div>                            
                        </div> 
		</div>
		</div>
		</div>
		
        
		
		
        <!-- END MESSAGE BOX-->

             
        
   
</body>
</html>