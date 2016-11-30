jQuery(document).ready(function () {

jQuery("#grid3").jqGrid({
    url: "listReadinessElements",
    async : false,
    datatype: "json",
    jsonReader: {repeatitems: false, id: "ref"},
    colNames:['Readiness Id','Readiness Name','Edit','Delete'],
    colModel:[
        {name:'re_id',index:'re_id', width:0.5},
        {name:'readiness_element_name',index:'readiness_element_name', width:310},
         {name:'edit',search:false,index:'re_id',width:150,sortable: false,formatter: editRELink},
        {name:'delete',search:false,index:'re_id',width:155,sortable: false,formatter: deleteRELink},
         
    ],
    rowNum:10,
    rowList:[5,10,20],
    height:360,
    pager: "#pagingDiv3",
    viewrecords: true,
    caption: ""
});
});

function editRELink(cellValue, options, rowdata, action)  {
    
	var readinessId = rowdata.re_id;
	return "<a class='btn btn-info pull-right fa fa-pencil-square-o' href='javascript:editRERecord(" + rowdata.re_id + ")'></a>";

}
function editRERecord(readinessId){
  
	//alert(readinessId);
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
			 $('#updateReadinessInfo').show();
			 
			 $('#cancelReadinessInfo').show();
			 $('#addReadiness').hide();
			 
			 
			 
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




function deleteRELink(cellValue, options, rowdata, action)  {
   
	// return "<a class='btn btn-danger pull-right fa fa-times' href='javascript:deleteRecordRE(" + rowdata.re_id + ")'></a>";
    
	return "<button class='btn btn-danger pull-right fa fa-times' type='button' onClick='clickDeleteReadiness.call(this)'></button>"; 
	
}
function clickDeleteReadiness(){

	var rowid = $(this).closest("tr.jqgrow").attr("id");
	var grid = $('#grid3');    


	var id = grid.jqGrid('getCell', rowid, 're_id');	
	var name = grid.jqGrid('getCell', rowid, 'readiness_element_name');	

	
	for (var i = 0; i < readinessTemplateValues.length; i++) 
    {
       // alert(readinessTemplateValues[i]);
       
        // we want to know if a[i] is found in b
        var match = false; // we haven't found it yet
       
            if (readinessTemplateValues[i] == name) {
                // we have found a[i] in b, so we can stop searching
                match = true;
                break;
            }
        
    }
	
	  if (match == true) {
          
	        	var readinessWarning = "Readiness Element "+name+" is currently being used in ReadinessTemplate Master.Please Verify";
	        	$('#warningPara').text(readinessWarning);
	        	$('#warningDiv').show();
	            
	        }
	  else
		  {
	  
		 
		  $('#alertDiv').show();
		  $('#alertPara').val(id);
		  $('#doWarehouseOperation').hide();
		  $('#doReadinessOperation').show();
		  $('#doSalesPipeLineOperation').hide();
		  
		/*  
    noty({
       text: 'Do you want to continue?',
       layout: 'topRight',
       buttons: [
               {
               	addClass: 'btn btn-success btn-clean', 
               	text: 'Ok', 
               	onClick: function($noty) 
               	     {
                               $noty.close();
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
   });*/
		  }
}