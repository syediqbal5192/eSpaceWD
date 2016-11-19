jQuery(document).ready(function () {

jQuery("#grid2").jqGrid({
    url: "listSalesPipeLine",
    async : false,
    datatype: "json",
    jsonReader: {repeatitems: false, id: "ref"},
    colNames:['Customer Name','Est. Built-up Area', 'Est. Carpet Area','Actual Built-up Area','Actual Carpet Area', 'Warehouse ','Status','Edit','Delete','Readiness Add/Edit'],
    colModel:[
       /* {name:'salesPipeLineId',index:'salesPipeLineId', width:60},
       */
        {name:'customerName',index:'customerName', width:120},
        {name:'estimatedFloorBuiltupArea',index:'estimatedFloorBuiltupArea', width:140},
        {name:'estimatedFloorCarpetArea',index:'estimatedFloorCarpetArea', width:140},
        {name:'actualFloorBuiltupArea',index:'actualFloorBuiltupArea', width:140},
        {name:'actualFloorCarpetArea',index:'actualFloorCarpetArea', width:140},
        {name:'allocatedWarehouse',index:'allocatedWarehouse', width:70},
        {name:'statusWork',index:'statusWork', width:80},
        {name:'edit',search:false,index:'salesPipeLineId',width:60,sortable: false,formatter: editSPLLink},
        {name:'delete',search:false,index:'salesPipeLineId',width:65,sortable: false,formatter: deleteSPLLink},
        {name:'rTUpdate',search:false,index:'salesPipeLineId',width:140,sortable: false,formatter: rTUpdateLink},
        
        
    ],
    rowNum:10,
    rowList:[20,60,100],
    height:360,
    pager: "#pagingDiv2",
    viewrecords: true,
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
			 
				$("#customerName").val("");
				$("#availableFloor").val("");
				$("#availableCarpet").val("");
				$("#estimatedFloorBuiltupArea").val("");
				$("#estimatedFloorCarpetArea").val("");
				$("#estimatedRackBuiltupArea").val("");
				$("#estimatedRackCarpetArea").val("");
				$("#estimatedStartDate").val("");
				$("#allocatedWarehouse").empty();
				//$("#statusWork").empty();
				$("#actualFloorBuiltupArea").val("");
				$("#actualFloorCarpetArea").val("");
				$("#actualRackBuiltupArea").val("");
				$("#actualRackCarpetArea").val("");
				$("#actualStartDate").val("");
				$("#remark").val("");
				var remark = $("#remark").val();
			 
			
			 var posts = JSON.parse(data);
			console.log("SUCCESS: ", posts.salePLId);
			
			$("#sp_Id").val(posts.salePLId);
			$("#customerName").val(posts.customerName);
			$("#estimatedFloorBuiltupArea").val(posts.estimatedFloorBuiltupArea);
			$("#estimatedFloorCarpetArea").val(posts.estimatedFloorCarpetArea);
			$("#estimatedRackBuiltupArea").val(posts.estimatedRackBuiltupArea);
			$("#estimatedRackCarpetArea").val(posts.estimatedRackCarpetArea);
			$("#estimatedStartDate").val(posts.estimatedStartDate);
			$("#estimatedRevenue").val(posts.estimatedRevenue);
			$("#allocatedWarehouse").val(posts.allocatedWarehouse);
			/*alert(posts.statusWork);*/
			$("#statusWork").val(posts.statusWork);
			$("#actualFloorBuiltupArea").val(posts.actualFloorBuiltupArea);
			$("#actualFloorCarpetArea").val(posts.actualFloorCarpetArea);
			$("#actualRackBuiltupArea").val(posts.actualRackBuiltupArea);
			$("#actualRackCarpetArea").val(posts.actualRackCarpetArea);
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
					$("#actualRackCarpetArea").prop('disabled', false);
					$("#actualStartDate").prop('disabled', false);
					$("#actualRevenue").prop('disabled', false);
		
				}
			else
				{
				
				  $("#actualFloorBuiltupArea").attr('disabled','disabled');
					$("#actualFloorCarpetArea").attr('disabled','disabled');
					$("#actualRackBuiltupArea").attr('disabled','disabled');
					$("#actualRackCarpetArea").attr('disabled','disabled');
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
			        	 $("#availableCarpet").val(valueOfFieldCarpet);
			        	
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




function deleteSPLLink(cellValue, options, rowdata, action)  {
    return "<a class='btn btn-danger pull-right fa fa-times' href='javascript:deleteRecordSPL(" + rowdata.salesPipeLineId + ","+rowdata.warehouseId+","+rowdata.actualFloorCarpetArea+")'></a>";
}
function deleteRecordSPL(salesPipeLineId,warehouseId,estimatedFloorCarpetArea){
	
	  $('#alertDiv').show();
	  $('#alertSalesPipeLineId').val(salesPipeLineId);
	  $('#alertWarehousId').val(warehouseId);
	  $('#alertFloorCarpertArea').val(estimatedFloorCarpetArea);
	  
	  $('#doWarehouseOperation').hide();
	  $('#doReadinessOperation').hide();
	  $('#doSalesPipeLineOperation').show();
	
	/* noty({
	        text: 'Do you want to continue?',
	        layout: 'topRight',
	        buttons: [
	                {
	                	addClass: 'btn btn-success btn-clean', 
	                	text: 'Ok', 
	                	onClick: function($noty) 
	                	     {
	                                $noty.close();
	                                noty(
	                                		{
	                                			text: 'You clicked "Ok" button', 
	                                			layout: 'topRight', 
	                                			type: 'success'
	                                		});
	                                $.ajax({
	                            		
	                            		type : "POST",
	                            		encoding : "UTF-8",
	                            		url : "deleteSalesPipeLineById",
	                            		datatype :'json', 
	                            		data : {
	                            			salesPipeLineId : salesPipeLineId,
	                            			warehouseId : warehouseId,
	                            			estimatedFloorCarpetArea : estimatedFloorCarpetArea,
	                            			        },
	                            		success : function(data) {
	                                          console.log("Marked for Deletion");
	                                          $("#grid2").trigger("reloadGrid");
	                            		           },
	                            		error : function(e) {
	                            			console.log("ERROR: ", e);
	                            		
	                            		}
	                            	});
	                                
	                }
	                },
	                {addClass: 'btn btn-danger btn-clean', text: 'Cancel', onClick: function($noty) {
	                    $noty.close();
	                    noty({text: 'You clicked "Cancel" button', layout: 'topRight', type: 'error'});
	                    }
	                }
	            ]
	    })     */                   
}