jQuery(document).ready(function () {

jQuery("#customerGrid").jqGrid({
    url: "listCustomer",
    async : false,
    datatype: "json",
    jsonReader: {repeatitems: false, id: "ref"},
    colNames:['Id','Customer Name','Contact Name', 'Contact Number' , 'Email Id','Contact Name','Conatct Number','Email Id','Edit','Delete'],
    colModel:[
        {name:'customer_id',index:'customer_id', width:0.5},
        {name:'customer_name',index:'customer_name', width:100},
        {name:'contact_name_1',index:'contact_name_1', width:140},
        {name:'contact_number_1',index:'contact_number_1', width:140},
        {name:'contact_email_1',index:'contact_email_1', width:140},
        {name:'contact_name_2',index:'contact_name_2', width:120},
        {name:'contact_number_2',index:'contact_number_2', width:120},
        {name:'contact_email_1',index:'contact_email_1', width:140},
        {name:'edit',search:false,index:'customer_id',width:55,sortable: false,formatter: editLinkCustomer},
        {name:'delete',search:false,index:'customer_id',width:60,sortable: false,formatter: deleteLinkH},
         
    ],
    rowNum:10,
    rowList:[20,60,100],
    height:460,
    pager: "#pagingDiv",
    viewrecords: true,
    caption: ""
});
});

function editLinkCustomer(cellValue, options, rowdata, action)  {
    
	var warehouseId = rowdata.warehouse_id;
	return "<a class='btn btn-info pull-right fa fa-pencil-square-o' href='javascript:editRecordCustomer(" + rowdata.customer_id + ")'></a>";

	
	
}
function editRecordCustomer(customer_id){
  
	
$.ajax({
		
		type : "POST",
		encoding : "UTF-8",
		url : "getCustomerById",
		datatype :'json', 
		data : {
			customer_id : customer_id,
			        },
		success : function(data) {

			 $("#addCustomerDiv").fadeIn(500);
			 $("#viewCustomerDiv").hide();
			 $('#dashboardDiv').hide();

			 $('#addCustomerTitle').hide();
			 $('#saveCustomerInfo').hide();
			 
			 $('#updateCustomerTitle').fadeIn();
			 $('#updateCustomerInfo').show();
			 $('#cancelCustomerInfo').show();
			 $('#addCustomer').hide();
			 
				$("#customer_name").val("");
				$("#contact_name_1").val("");
				$("#contact_number_1").val("");
				$("#contact_email_id_1").val("");
				$("#contact_name_2").val("");
				$("#contact_number_2").val("");
				$("#contact_email_id_2").val("");
			 
			
			 var posts = JSON.parse(data);
			console.log("SUCCESS: ", posts.warehouse_name);
			
			$("#customer_id").val(posts[0].customer_id);
			$("#customer_name").val(posts[0].customer_name);
			$("#contact_name_1").val(posts[0].contact_name_1);
			$("#contact_number_1").val(posts[0].contact_number_1);
			$("#contact_email_id_1").val(posts[0].contact_email_1);
			$("#contact_name_2").val(posts[0].contact_name_2);
			$("#contact_number_2").val(posts[0].contact_number_2);
			$("#contact_email_id_2").val(posts[0].contact_email_2);
			
          
			
		},
		error : function(e) {
			console.log("ERROR: ", e);
		
		}
	});
	
}




function deleteLinkH(cellValue, options, rowdata, action)  {

	//return "<button class='btn btn-danger pull-right fa fa-times' href='javascript:deleteRecordWH("+rowdata")'></button>"; 
		return "<button class='btn btn-danger pull-right fa fa-times' type='button' onClick='clickEditWarehouse.call(this)'></button>"; 
	
}


/*function deleteRecordWH(warehouseId){*/
	function clickEditWarehouse()
	{
	
    var value1 = $('#grid2').jqGrid('getCol','allocatedWarehouse');
	//alert(value1);

	var rowid = $(this).closest("tr.jqgrow").attr("id");
	var grid = $('#grid');    


	var id = grid.jqGrid('getCell', rowid, 'warehouse_id');	
	var name = grid.jqGrid('getCell', rowid, 'warehouse_name');	
	
	//alert(name);

    for (var i = 0; i < value1.length; i++) 
    {
        // we want to know if a[i] is found in b
        var match = false; // we haven't found it yet
       
            if (value1[i] == name) {
                // we have found a[i] in b, so we can stop searching
                match = true;
                break;
            }
       
    }
        // add a[i] to newArray only if we didn't find a match.
        if (match == true) {
          
        	var warehouseWarning = "Warehouse "+name+" is currently being used in SalesPipeLine Master.Please Verify";
        	$('#warningPara').text(warehouseWarning);
        	$('#warningDiv').show();
            
        }
    
        else
        	{
        	
        	
        	  $('#alertDiv').show();
    		  $('#alertPara').val(id);
    		  $('#doWarehouseOperation').show();
    		  $('#doReadinessOperation').hide();
              $('#doSalesPipeLineOperation').hide();
    	
        	}
    }
           
    
    
    