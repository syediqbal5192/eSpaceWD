jQuery(document).ready(function () {

jQuery("#grid2").jqGrid({
    url: "listSalesPipeLine",
    async : false,
    datatype: "json",
    jsonReader: {repeatitems: false, id: "ref"},
    colNames:['SalesId','WID','Customer Name','Warehouse ','Customer Type','Est. Floor Built-up Area', 'Est. Floor Carpet Area','Actual Floor Built-up Area','Actual Floor Carpet Area', 'Actual Rack Area','Status','Edit','Delete','Readiness Add/Edit'],
    colModel:[
        {name:'salesPipeLineId',index:'salesPipeLineId', width:10},
        {name:'warehouseId',index:'warehouseId', width:10},
        {name:'customerName',index:'customerName', width:60},
        {name:'allocatedWarehouse',index:'allocatedWarehouse', width:90},
        {name:'customerType',index:'customerType', width:60},
        {name:'estimatedFloorBuiltupArea',index:'estimatedFloorBuiltupArea', width:120},
        {name:'estimatedFloorCarpetArea',index:'estimatedFloorCarpetArea', width:120},
        {name:'actualFloorBuiltupArea',index:'actualFloorBuiltupArea', width:120},
        {name:'actualFloorCarpetArea',index:'actualFloorCarpetArea', width:120},
        {name:'actualRackBuiltupArea',index:'actualRackBuiltupArea', width:120},
        {name:'statusNew',index:'statusNew', width:100},
        {name:'edit',search:false,index:'salesPipeLineId',width:60,sortable: false,formatter: editSPLLink},
        {name:'delete',search:false,index:'salesPipeLineId',width:65,sortable: false,formatter: deleteSPLLink},
        {name:'rTUpdate',search:false,index:'salesPipeLineId',width:60,sortable: false,formatter: rTUpdateLink},
        
        
    ],
    rowNum:10,
    rowList:[20,60,100],
    height:500,
    pager: "#pagingDiv2",
    viewrecords: true,
    loadComplete : function(){
        $(this).jqGrid('hideCol',["warehouseId"]);
         $(this).jqGrid('hideCol',["salesPipeLineId"]);
       },
    caption: "",
    	 subGrid: true,
    	    subGridOptions: { "plusicon" : "ui-icon-triangle-1-e",
    	                      "minusicon" :"ui-icon-triangle-1-s",
    	                      "openicon" : "ui-icon-arrowreturn-1-e",
    	                      "reloadOnExpand" : false,
    	                      "selectOnExpand" : true },
    	    subGridRowExpanded: function(subgrid_id, row_id) {
    	        var subgrid_table_id, pager_id; subgrid_table_id = subgrid_id+"_t";
    	        
    	        var currentRow = $("#grid2").jqGrid('getRowData', row_id);
                var salesPipeLineId = currentRow.salesPipeLineId;
               
    	        pager_id = "p_"+subgrid_table_id;
    	        $("#"+subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+pager_id+"' class='scroll'></div>");
    	        $("#"+subgrid_table_id).jqGrid({
    	        	 url: "listReadinessTemplate",
    	        	    async : false,
    	        	    postData: {
    	        	    	salesPipeLineId: salesPipeLineId,
    	        	    },
    	        	    datatype: "json",
    	        	    jsonReader: {repeatitems: false, id: "ref"},
    	        	    colNames:['readinessTemplateId','Company Name','Readiness Name','readinessElementQuantity','Owner Name','Element Status','Start Date','End Date','Update'],
    	        	    colModel:[
    	        	        {name:'readinessTemplateId',index:'readinessTemplateId',width:40},
    	        	        {name:'companyName',index:'companyName', width:140},
    	        	        {name:'readinessName',index:'readinessName', width:140},
    	        	        {name:'readinessElementQuantity',index:'readinessElementQuantity',width:40},
    	        	        {name:'ownerName',index:'ownerName', width:140},
    	        	        {name:'readinessElementStatus',index:'readinessElementStatus',width:40},
    	        	        {name:'taskStartDate',index:'taskStartDate', width:140},
    	        	        {name:'taskEndDate',index:'taskEndDate', width:140},
    	        	        {name:'edit',search:false,index:'readinessTemplateId',width:60,sortable: false,formatter: updateReadinessTemplateLink},
    	        	        
    	        	         
    	        	    ],
    	            rowNum:20,
    	            pager: pager_id,
    	            sortname: 'num',
    	            sortorder: "asc", height: '100%' });
    	         $("#"+subgrid_table_id).jqGrid('navGrid',"#"+pager_id,{edit:false,add:false,del:false});
    	        
    	         var subNames = ["num", "item", "qty"];
    	         var mysubdata = [];
    	         for (var i = 0; i < subgridData.length; i++) {
    	            mysubdata[i] = {};
    	            for (var j = 0; j < subgridData[i].length; j++) {
    	                mysubdata[i][subNames[j]] = subgridData[i][j];
    	             }
    	         }
    	         for (var i = 0; i <= mysubdata.length; i++) {
    	           $("#"+subgrid_table_id).jqGrid('addRowData', i + 1, mysubdata[i]);
    	         }
    	    }
});
});

function editSPLLink(cellValue, options, rowdata, action)  {
    
	var salesPipeLineId = rowdata.salesPipeLineId;
	return "<a class='btn btn-info pull-right fa fa-pencil-square-o' href='javascript:editSPLRecord(" + rowdata.salesPipeLineId + ")'></a>";

}

function updateReadinessTemplateLink(cellValue, options, rowdata, action)  {
    
	var readinessTemplateId = rowdata.readinessTemplateId;
	return "<a class='btn btn-info pull-right fa fa-pencil-square-o' href='javascript:updateReadinessTemplateRecord(" + rowdata.readinessTemplateId + ")'></a>";

}

function updateReadinessTemplateRecord(readinessTemplateId)
{
	
	$('#editReadinessTemplateDiv').show();
	
	var readinessTemplateEditId = $("#readinessTemplateEditId").val();
	var readinessTemplateEditCustomerName = $("#readinessTemplateEditCustomerName").val();
	var readinessTemplateEditElement =$("#readinessTemplateEditElement").val();                                 
	var readinessTemplateEditStartDate = $("#readinessTemplateEditStartDate").val();                                
	var readinessTemplateEditEndDate = $("#readinessTemplateEditEndDate").val(); 
	var readinessTemplateEditElementStatus = $("#readinessTemplateEditElementStatus").val();
	var readinessTemplateEditOwnerName = $("#readinessTemplateEditOwnerName").val(); 
	var readinessTemplateEditQuantity = $("#readinessTemplateEditQuantity").val(); 
	
	
	
	$.ajax({
			
			type : "POST",
			encoding : "UTF-8",
			url : "getReadinessTemplateDetailsById",
			datatype :'json', 
			data : {
				readinessTemplateId : readinessTemplateId,
				        },
			success : function(data) {

				$("#readinessTemplateEditId").val();
				$("#readinessTemplateEditCustomerName").val();
				$("#readinessTemplateEditElement").val();                                 
				$("#readinessTemplateEditStartDate").val();                                
				$("#readinessTemplateEditEndDate").val(); 
				$("#readinessTemplateEditElementStatus").val();
				$("#readinessTemplateEditOwnerName").val(); 
				$("#readinessTemplateEditQuantity").val(); 
					
				 var posts = JSON.parse(data);
				console.log("SUCCESS: ", posts.salePLId);
				
				$("#readinessTemplateEditId").val(posts.readinessTemplateId);
				$("#readinessTemplateEditCustomerName").val(posts.companyName);
				$("#readinessTemplateEditQuantity").val(posts.readinessElementQuantity);
				$("#readinessTemplateEditOwnerName").val(posts.ownerName);
				$("#readinessTemplateEditElementStatus").val(posts.readinessElementStatus);
				$("#readinessTemplateEditStartDate").val(posts.taskStartDate);
				$("#readinessTemplateEditEndDate").val(posts.taskEndDate);
				
	          
				
				
				//Populate Dropdown

			/* 	$.ajax({
					type:'GET',
					encoding : "UTF-8",
					url : "listWarehouseById",
					data : 
						{
						warehouseId:warehouseId,
						},
				    dataType: 'json',
				    success: function( json ) {
				        $.each(json, function(i, value) {
				        	
				        	$('#allocatedWarehouse').append($('<option>').text(value.warehouse_name).attr('value', value.warehouse_id));
				        	 var valueOfFieldFloor = value.available_floor_carpet_area;
				        	 var valueOfFieldCarpet =value.available_rack_carpet_area;
				        	 $("#availableFloor").val(valueOfFieldFloor);
				        	 $("#availableCarpet").val(valueOfFieldCarpet);
				        	
				        });
				        
				        
				      
				    }
				}); */
				
				//Enabled Confirm Actual Box
				
				/*  $("#actualFloorBuiltupArea").prop('disabled', false);
					$("#actualFloorCarpetArea").prop('disabled', false);
					$("#actualRackBuiltupArea").prop('disabled', false);
					$("#actualRackCarpetArea").prop('disabled', false);
					$("#actualStartDate").prop('disabled', false);
				
					$('#confirmed').hide(); */
				
				
				
				
			},
			error : function(e) {
				console.log("ERROR: ", e);
			
			}
		});
	
}



function rTUpdateLink(cellValue, options, rowdata, action)  {
    
	return "<a class='btn btn-warning pull-right fa fa-file-text-o' href='javascript:rTUpdateRecord(" + rowdata.salesPipeLineId + ")' style='width:90px;'>  </a>";
	
} 

function rTViewLink(cellValue, options, rowdata, action)  {
    
	var salesPipeLineId = rowdata.salesPipeLineId;
	return "<a class='btn btn-success pull-right fa fa-eye' href='javascript:rTViewRecord(" + rowdata.salesPipeLineId + ")' style='width:90px;'> </a>";

}

function rTUpdateRecord(salesPipeLineId)
{
//alert(salesPipeLineId);
	
	$.ajax({
		type:'GET',
		encoding : "UTF-8",
		url : "getCustomerNameById",
		data : 
			{
			salesPipeLineId : salesPipeLineId,
			},
	    success: function(json) {
	    	
	    	$('#readinessTemplateCompanyName').val(json);
	    	$('#readinessSalesPipeLineId').val(salesPipeLineId);
	    	//alert(salesPipeLineId);
	    	
	    	//$("#inlineEditGrid").trigger("reloadGrid");
	    	
	    	
	    	$("#inlineEditGrid").jqGrid('setGridParam', { 
	            postData: {"salesPipeLineId":salesPipeLineId }
	     }).trigger('reloadGrid'); 
	    	
	    	
  	
	    	$('#readinessTemplate').show();
	    	$('#addReadinessTemplateGrid').hide();
	    	$('#editReadinessTemplateGrid').show();
	    	$('#bulkSave').hide();
	    	$("#updateReadinessOrderTitle").show();
	    	$("#addReadinessOrderTitle").hide();
	    	$('#bulkUpdate').show();
	    	
	    	
	    	//$("#grid4").trigger("reloadGrid");
	        
	      
	    }
	});
	
	
	
}

function buttonFormatter() {
	/*return "<a class='btn btn-danger pull-right fa fa-times' href='javascript:deleteRecordRT()'></a>";
	*/return "<button class='btn btn-danger pull-right fa fa-times' type='button' onClick='clickFunction1.call(this)'></button>";
}

function clickFunction1()
{
	

    
	var grid = $('#inlineGrid'), rowid = $(this).closest("tr.jqgrow").attr("id");
	var myCellData = grid.jqGrid('getCell', rowid, 'Name');
	//alert("Selected  Name: " + myCellData);
	$('#inlineGrid').jqGrid('delRowData',rowid);
	
	
}


function rTViewRecord(salesPipeLineId)
{
	//alert(" Update  "+salesPipeLineId);
}



function editSPLRecord(salesPipeLineId){
  
	$("#statusWork").prop('disabled', false);
	
$.ajax({
		
		type : "POST",
		encoding : "UTF-8",
		url : "getSalesPipeLineDetailsById",
		datatype :'json', 
		data : {
			salesPipeLineId : salesPipeLineId,
			        },
		success : function(data) {

			 $("#addSalesPipeLineDiv").fadeIn(500);
			 $("#viewSalesPipeLineDiv").hide();
			 $('#dashboardDiv').hide();

			 $('#addSPLTitle').hide();
			 $('#saveSalesPipeLineInfo').hide();
			 
			 $('#updateSPLTitle').fadeIn();
			 $('#updateSalesPipeLineInfo').show();
			 
			 $('#cancelSalesPipeLineInfo').show();
			 $('#addSalesPipeLine').hide();
			 $('#confirmed').show();
			 
				$("#customerName").empty();
				$("#customerType").empty();
				$("#availableFloor").val("");
				$("#availableCarpet").val("");
				$("#estimatedFloorBuiltupArea").val("");
				$("#estimatedFloorCarpetArea").val("");
				$("#estimatedRackBuiltupArea").val("");
				$("#estimated_palette_positions").val("");
				$("#estimatedStartDate").val("");
				$("#allocatedWarehouse").empty();
				//$("#statusWork").empty();
				$("#actualFloorBuiltupArea").val("");
				$("#actualFloorCarpetArea").val("");
				$("#actualRackBuiltupArea").val("");
				$("#actual_palette_positions").val("");
				$("#actualStartDate").val("");
				$("#remark").val("");
				var remark = $("#remark").val();
			 
			
			 var posts = JSON.parse(data);
			console.log("SUCCESS: ", posts.salePLId);
			console.log("Customer Id : ",posts.customerName);
			
			$("#sp_Id").val(posts.salePLId);
			$("#customerName").val(posts.customerName);     	
			$('#customerType').append($('<option>').text(posts.customerType).attr('value', posts.customerType));
			$("#estimatedFloorBuiltupArea").val(posts.estimatedFloorBuiltupArea);
			$("#estimatedFloorCarpetArea").val(posts.estimatedFloorCarpetArea);
			$("#estimatedRackBuiltupArea").val(posts.estimatedRackBuiltupArea);
			$("#estimated_palette_positions").val(posts.estimated_palette_positions);
			$("#estimatedStartDate").val(posts.estimatedStartDate);
			$("#estimatedRevenue").val(posts.estimatedRevenue);
			$("#allocatedWarehouse").val(posts.allocatedWarehouse);
			/*alert(posts.statusWork);*/
			$("#statusWork").val(posts.statusWork);
			$("#actualFloorBuiltupArea").val(posts.actualFloorBuiltupArea);
			$("#actualFloorCarpetArea").val(posts.actualFloorCarpetArea);
			$("#actualFloorCarpetAreaRef").val(posts.actualFloorCarpetArea);
			$("#actualRackBuiltupArea").val(posts.actualRackBuiltupArea);
			$("#actualRackBuiltupAreaRef").val(posts.actualRackBuiltupArea);
			$("#actual_palette_positions").val(posts.actual_palette_positions);
			$("#actualStartDate").val(posts.actualStartDate);
			$("#actualRevenue").val(parseInt(posts.actualRevenue));
			$("#remark").val(posts.remarks);
			console.log(posts.remarks);
			var workStatus = $.trim(posts.statusWork);
			var confirmed = "confirmed";
			if(workStatus == confirmed){
			
				    $("#actualFloorBuiltupArea").prop('disabled', false);
					$("#actualFloorCarpetArea").prop('disabled', false);
					$("#actualRackBuiltupArea").prop('disabled', false);
					$("#actual_palette_positions").prop('disabled', false);
					$("#actualStartDate").prop('disabled', false);
					$("#actualRevenue").prop('disabled', false);
		
				}
			else
				{
				
				  $("#actualFloorBuiltupArea").attr('disabled','disabled');
					$("#actualFloorCarpetArea").attr('disabled','disabled');
					$("#actualRackBuiltupArea").attr('disabled','disabled');
					$("#actual_palette_positions").attr('disabled','disabled');
					$("#actualStartDate").attr('disabled','disabled');
					$("#actualRevenue").attr('disabled', 'disabled');
		
				
				}
			
			/*alert(posts.allocatedWarehouse);*/
			
			var warehouseId = posts.allocatedWarehouse;
			
			//Populate Dropdown

			$.ajax({
				type:'GET',
				encoding : "UTF-8",
				url : "listWarehouseById",
				data : 
					{
					warehouseId:warehouseId,
					},
			    dataType: 'json',
			    success: function( json ) {
			        $.each(json, function(i, value) {
			        	
			        	$('#allocatedWarehouse').append($('<option>').text(value.warehouse_name).attr('value', value.warehouse_id));
			        	 var valueOfFieldFloor = value.available_floor_carpet_area;
			        	 var valueOfFieldCarpet =value.available_rack_carpet_area;
			        	 
			        	 $("#availableFloor").val(valueOfFieldFloor);
			        	 $("#availableFloor2").val(valueOfFieldFloor);
			        	 $("#availableCarpet").val(valueOfFieldCarpet);
			        	 $("#availableRack2").val(valueOfFieldCarpet);
			        	
			        });
			        
			        
			      
			    }
			});
			
          var customer_id = parseInt(posts.customerName);
			
			//Populate Dropdown

			$.ajax({
				type:'POST',
				encoding : "UTF-8",
				url : "getCustomerById",
				data : 
					{
					customer_id:customer_id,
					},
			    dataType: 'json',
			    success: function( json ) {
			        $.each(json, function(i, value) {
			        	
			        	$('#customerName').append($('<option>').text(value.customer_name).attr('value', value.customer_id));
			        });
			        
			        
			      
			    }
			});
			
			//Enabled Confirm Actual Box
	/*		
			 $("#actualFloorBuiltupArea").prop('disabled', false);
				$("#actualFloorCarpetArea").prop('disabled', false);
				$("#actualRackBuiltupArea").prop('disabled', false);
				$("#actualRackCarpetArea").prop('disabled', false);
				$("#actualStartDate").prop('disabled', false);
		*/	
				//$('#confirmed').hide();
			
			
			
		},
		error : function(e) {
			console.log("ERROR: ", e);
		
		}
	});
	
}




function deleteSPLLink(cellValue, options, rowdata, action)  
{
//    return "<a class='btn btn-danger pull-right fa fa-times' href='javascript:deleteRecordSPL(" + rowdata.salesPipeLineId + ","+rowdata.warehouseId+","+rowdata.actualFloorCarpetArea+")'></a>";
	return "<button class='btn btn-danger pull-right fa fa-times' type='button' onClick='clickDeleteSalesPipeLine.call(this)'></button>"; 



}

//function deleteRecordSPL(salesPipeLineId,warehouseId,estimatedFloorCarpetArea)
function clickDeleteSalesPipeLine()
{
	
	var rowid = $(this).closest("tr.jqgrow").attr("id");
	var grid = $('#grid2');    

	
	var salesPipeLineId = grid.jqGrid('getCell', rowid, 'salesPipeLineId');	
	var warehouseId = grid.jqGrid('getCell', rowid, 'warehouseId');	
	var estimatedFloorCarpetArea = grid.jqGrid('getCell', rowid, 'actualFloorCarpetArea');
	var actualRackBuiltupArea = grid.jqGrid('getCell',rowid, 'actualRackBuiltupArea');
//	alert(salesPipeLineId+""+warehouseId+""+estimatedFloorCarpetArea);
	
	 $.ajax({
			type:'GET',
			encoding : "UTF-8",
			url : "listReadinessTemplate",
			data : 
			{
				salesPipeLineId : salesPipeLineId,
			},
			success: function(json) {
	
				var post = JSON.parse(json);
				console.log(json);
				
				console.log(post.length);
					
				if (post.length == 0 ) 
				{
					
					
					  $('#alertDiv').show();
					  $('#alertSalesPipeLineId').val(salesPipeLineId);
					  $('#alertWarehousId').val(warehouseId);
					  $('#alertFloorCarpertArea').val(estimatedFloorCarpetArea);
					  $('#alertRackArea').val(actualRackBuiltupArea);
					  
					  $('#doWarehouseOperation').hide();
					  $('#doReadinessOperation').hide();
					  $('#doSalesPipeLineOperation').show();
					
					
				    }
				else
				{
									
					var warehouseWarning = "Readiness Stil in Progress Stage .Please Verify";
		        	$('#warningPara').text(warehouseWarning);
		        	$('#warningDiv').show();
		        	
					
					
				}
		    }
		});
	
	

                 
}