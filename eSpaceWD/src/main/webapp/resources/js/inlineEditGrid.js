jQuery(document).ready(function () {

	var salesPipeLineId = "14";
 
	$("#inlineEditGrid").jqGrid({
		url: "listReadinessTemplate",
	    postData: {
	    	salesPipeLineId: salesPipeLineId,
	    },
		 datatype: "json",
		 jsonReader: {repeatitems: false, id: "ref"},
		 colNames:['id','Readiness Name','ReadinessQuantity','Start Date','End Date','Owner Name','Element Status','Edit','Delete','isDeleted','actualStartDate','actualEndDate'],
		    colModel: [ {
		    	name:'readinessTemplateId',
		    	index:'readinessTemplateId',
		    	width: 0.5
		    },{
	        name: 'readiness_element_name',
	        index: 'readiness_element_name',
	        width: 130
	        
	    }, {
	        name: 'readinessElementQuantity',
	        index: 'readinessElementQuantity',
	        width:100
	    },
	    {
	        name: 'taskStartDate',
	        index: 'taskStartDate',
	        width:120
	    }, {
	        name: 'taskEndDate',
	        index: 'taskEndDate',
	        width:120
	    }, {
	        name: 'ownerName',
	        index: 'ownerName',
	        width:100
	    },{
	        name: 'readinessElementStatus',
	        index: 'readinessElementStatus',
	        width:80
	    },
	    { name: "Edit", formatter: editFormatter, width: 51,
		    search: false, sortable: false, hidedlg: true, resizable: false,
			editable: false, viewable: false},
	    { name: "Delete", formatter: buttonFormatter, width: 51,
		    search: false, sortable: false, hidedlg: true, resizable: false,
			editable: false, viewable: false},
			{
		        name: 'isDeleted',
		        index: 'isDeleted',
		        width:80,
		        editable: true,
		        editrules:{required:true,}
		    },
		    {
		        name: 'taskStartDateAct',
		        index: 'taskStartDateAct',
		        width:10
		    }, {
		        name: 'taskEndDateAct',
		        index: 'taskEndDateAct',
		        width:20
		    }, 
			],
	    pager: '#inlineEditPaging',
	    rowNum:5,
	    rowList:[5,10,0],
	    height:400,
	    width:1000,
	    loadComplete : function(){
         // $(this).jqGrid('hideCol',["readinessTemplateId"]);
          $(this).jqGrid('hideCol',["isDeleted"]);
          $(this).jqGrid('hideCol',["taskStartDateAct"]);
          $(this).jqGrid('hideCol',["taskEndDateAct"]);
        }
	});

});




function buttonFormatter()
{
	return "<button class='btn btn-danger pull-right fa fa-times' type='button' onClick='clickFunction1.call(this)'></button>";
}

function clickFunction1()
{
	

    
	var grid = $('#inlineEditGrid'), rowid = $(this).closest("tr.jqgrow").attr("id");
	var myCellData = grid.jqGrid('getCell', rowid, 'Name');
	//alert("Selected  Name: " + myCellData);
	var isDeleted = 'Yes';
	$('#inlineEditGrid').jqGrid('setCell', rowid, 'isDeleted', isDeleted);
	var trElement = jQuery("#"+rowid,jQuery('#inlineEditGrid'));
	trElement.addClass('displayNone');
	
	
	//$('#inlineEditGrid').jqGrid('delRowData',rowid);
	
	
}



function editFormatter()
{
	return "<button class='btn btn-warning pull-right fa fa-pencil-square-o' type='button' onClick='clickEdit.call(this)'></button>";
}

function clickEdit()
{
	$("#addReadinessTemplateButton").hide();
	$("#readinessTemplateEditButton").show();
var rowid = $(this).closest("tr.jqgrow").attr("id");
var grid = $('#inlineEditGrid');    


var id = grid.jqGrid('getCell', rowid, 'readinessTemplateId');	
var name = grid.jqGrid('getCell', rowid, 'readiness_element_name');	
var quantity = grid.jqGrid('getCell', rowid, 'readinessElementQuantity');	
var taskStart = grid.jqGrid('getCell', rowid, 'taskStartDate');	
var taskEndDate = grid.jqGrid('getCell', rowid, 'taskEndDate');	
var ownerName = grid.jqGrid('getCell', rowid, 'ownerName');	
var readinessElementStatus = grid.jqGrid('getCell', rowid, 'readinessElementStatus');	

//alert(name);

$("#rowNumber").val(rowid);
$("#readinessTemplateEditId").val(id);
$("#readinessTemplateEditCustomerName").val(name);
$("#readinessTemplateEditQuantity").val(quantity);
$("#readinessTemplateEditOwnerName").val(ownerName);
$("#readinessTemplateEditElementStatus").val(readinessElementStatus);
$("#readinessTemplateEditStartDate").val(taskStart);
$("#readinessTemplateEditEndDate").val(taskEndDate);
$("#editReadinessTemplateDiv").show();

}
