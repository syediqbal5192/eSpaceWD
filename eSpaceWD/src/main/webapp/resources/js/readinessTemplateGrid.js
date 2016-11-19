jQuery(document).ready(function () {

jQuery("#grid4").jqGrid({
    url: "listReadinessElements",
    async : false,
    datatype: "json",
    jsonReader: {repeatitems: false, id: "ref"},
    colNames:['Re_Id','Readiness Name','ReadinessQuantity','Start Date','End Date','Owner Name','Element Status','Save'],
    colModel:[
        {name:'re_id',search:false,index:'id',width:40,sortable: false,formatter: readinessIdLink},
        {name:'readiness_element_name',index:'readiness_element_name', width:140},
        {name:'readiness_quantity',search:false,index:'re_id',width:130,sortable: false,formatter: readinessQuantityLink},
        {name:'readiness_start_date',search:false,index:'re_id',width:110,sortable: false,formatter: readinessStartDateLink},
        {name:'readiness_end_date',search:false,index:'re_id',width:110,sortable: false,formatter: readinessEndDateLink},
        {name:'readiness_owner_name',search:false,index:'re_id',width:140,sortable: false,formatter: readinessOwnerNameLink},
        {name:'readiness_element_status',search:false,index:'re_id',width:140,sortable: false,formatter: readinessElementStatusLink},
        {name:'Save',search:false,index:'re_id',width:75,sortable: false,formatter: saveLink},
       
        /*
         {name:'Remove',search:false,index:'re_id',width:75,sortable: false,formatter: removeLink}*/
        
    ],
    search:true,
    pager:'#pager',
    jsonReader: {cell:""},
    rowNum: 10,
    rowList: [5, 10, 20, 50],
    sortname: 'id',
    sortorder: 'asc',
    viewrecords: true,
    height: "100%",
    multiselect:true,
    caption: "Readiness Element List: "
});
});

function editLink(cellValue, options, rowdata, action)  {
    
	var readinessId = rowdata.re_id;
	return "<a href='javascript:editRecord(" + rowdata.re_id + ")'>Edit</a>";

}


function readinessIdLink(cellValue, options, rowdata, action)  {
    
	var readinessId = rowdata.re_id;
	return "<input type='text' class='form-control'value='" + rowdata.re_id + "' id='readinessId_"+readinessId+"' disabled/>";

}



function readinessQuantityLink(cellValue, options, rowdata, action)  {
    
	var readinessId = rowdata.re_id;
	return "<input type='text' class='form-control' value='" + rowdata.re_id + "' id='readinessQuantity_"+readinessId+"' />";

}


function readinessStartDateLink(cellValue, options, rowdata, action)  {
    
	var readinessId = rowdata.re_id;
	return "<input type='text' class='form-control' value='06-06-2014' data-date='06-06-2014' data-date-format='dd-mm-yyyy' data-date-viewmode='years' id='readinessStartDate_"+readinessId+"'/>";
}

function readinessEndDateLink(cellValue, options, rowdata, action)  {
    
	var readinessId = rowdata.re_id;
	return "<input type='text' class='form-control' value='06-06-2014' data-date='06-06-2014' data-date-format='dd-mm-yyyy' data-date-viewmode='years' id='readinessEndDate_"+readinessId+"'/>";
}

function readinessOwnerNameLink(cellValue, options, rowdata, action)  {
    
	var readinessId = rowdata.re_id;
	return "<input type='text' class='form-control' id='readinessOwnerName_"+readinessId+"'/>";
}

function readinessElementStatusLink(cellValue, options, rowdata, action)  {
    
	var readinessId = rowdata.re_id;

	return "<select class='form-control select' id='readinessElementStatus_"+readinessId+"' ><option value='waiting'>Waiting</option><option value='wIP'>Work In Progress</option><option value=readyState'>Ready State</option></select>";
}

function editRecord(readinessId){
  
	
$.ajax({
		
		type : "POST",
		encoding : "UTF-8",
		url : "getReadinessDetailsById",
		datatype :'json', 
		data : {
			readinessId : readinessId,
			        },
		success : function(data) {

			 $("#addReadinessDiv").fadeIn(500);
			 $("#viewReadinessDiv").hide();
			 $('#dashboardDiv').hide();

			 $('#addRETitle').hide();
			 $('#saveReadinessInfo').hide();
			 
			 $('#updateRETitle').fadeIn();
			 $('#updateReadinessInfo').fadeIn(500);
			 
			 
				$("#readinessElementName").val("");
			 
			
			 var posts = JSON.parse(data);
			console.log("SUCCESS: ", posts.warehouse_name);
			
			$("#readinessId").val(posts.re_id);
			$("#readinessElementName").val(posts.readiness_element_name);
			
          
			
		},
		error : function(e) {
			console.log("ERROR: ", e);
		
		}
	});
	
}




function saveLink(cellValue, options, rowdata, action)  {
    
    return "<a class='btn btn-primary pull-right fa fa-file-text-o' href='javascript:saveRecord(" + rowdata.re_id + ")'></a>";

}
function saveRecord(id){
	
	
	
	
	var readinessEndDate = "readinessEndDate_"+id;
	var readinessStartDate = "readinessStartDate_"+id;
	var readinessQuantity = "readinessQuantity_"+id;
	var readinessId = "readinessId_"+id;
	var readinessOwnerName = "readinessOwnerName_"+id;
	var readinessElementStatus = "readinessElementStatus_"+id;
	
	var valueOfReadinessId = $('#'+readinessId).val();
	var valueOfReadinessQuantity = $('#'+readinessQuantity).val();
	var valueOfReadinessStartDate = $('#'+readinessStartDate).val();
	var valueOfReadinessEndDate = $('#'+readinessEndDate).val();
	var valueOfReadinessOwnerName = $('#'+readinessOwnerName).val();
	var valueOfReadinessElementStatus = $('#'+readinessElementStatus).val();
	var valueOfReadinessCompanyName = $('#readinessTemplateCompanyName').val();
	var valueOfReadinessSalesPipeLineId = $('#readinessSalesPipeLineId').val();
	
	
	$.ajax({
		
		type : "POST",
		encoding : "UTF-8",
		url : "addReadinessTemplate",
		datatype :'json', 
		data : {
			valueOfReadinessCompanyName : valueOfReadinessCompanyName,
			valueOfReadinessSalesPipeLineId : valueOfReadinessSalesPipeLineId,
			valueOfReadinessId : valueOfReadinessId,
			valueOfReadinessQuantity : valueOfReadinessQuantity,
			valueOfReadinessOwnerName : valueOfReadinessOwnerName,
			valueOfReadinessElementStatus : valueOfReadinessElementStatus,
			valueOfReadinessStartDate : valueOfReadinessStartDate,
			valueOfReadinessEndDate : valueOfReadinessEndDate,
            },
		success : function(data) {
			console.log("SUCCESS: ", data);
			$("#grid2").trigger("reloadGrid");
			//$("#grid4").trigger("reloadGrid");
			alert("Added Readiness");
			var ids=$('#grid4').getGridParam('selarrrow');
			$('#grid4').delRowData(ids);
			
			for( var i=ids.length-1;i>=0;i--)
				{

				$('#grid4').delRowData(ids[i]);
				
				}
			
			$('#readinessOwnerName_'+readinessId).val(valueOfReadinessOwnerName);
		},
		error : function(e) {
			console.log("ERROR: ", e);
		
		}
	});		
	
	
	
}

function removeLink(cellValue, options, rowdata, action)  {
    
	return "<a class='btn btn-danger pull-right fa fa-times' href='javascript:removeRecord(" + rowdata.re_id + ","+rowdata.id+")'></a>";

}

function removeRecord(readinessElementId,id)
{
	var ids=$('#grid4').getGridParam('selarrrow');
	alert(ids);
	$('#grid4').delRowData(ids);
	
	for( var i=ids.length-1;i>=0;i--)
		{

		$('#grid4').delRowData(ids[i]);
		
		}
	
	/*$("#"+readinessElementId).hide()
	var salesPipeLineId = $('#readinessSalesPipeLineId').val();
	
	alert(salesPipeLineId+"values");
	*/
	/*noty({
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
	                           		url : "deleteReadinessTemplateById",
	                           		datatype :'json', 
	                           		data : {
	                           			readinessElementId : readinessElementId,
	                           			salesPipeLineId : salesPipeLineId
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
	   }) 
*/	
}
