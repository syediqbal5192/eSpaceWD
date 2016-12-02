jQuery(document).ready(function () {

jQuery("#grid").jqGrid({
    url: "listWarehouse",
    async : false,
    datatype: "json",
    jsonReader: {repeatitems: false, id: "ref"},
    colNames:['Id','Warehouse Name','Floor Built-up Area', 'Floor Carpet Area' , 'Rack Built-up Area','No. of Palette Postion','Total Shutters','Edit','Delete'],
    colModel:[
        {name:'warehouse_id',index:'warehouse_id', width:0.5},
        {name:'warehouse_name',index:'warehouse_name', width:140},
        {name:'floor_builtup_area',index:'floor_builtup_area', width:140},
        {name:'floor_carpet_area',index:'floor_carpet_area', width:140},
        {name:'rack_builtup_area',index:'rack_builtup_area', width:120},
        {name:'palette_positions',index:'palette_positions', width:120},
        {name:'total_docks',index:'total_docks', width:120},
        {name:'edit',search:false,index:'warehouse_id',width:55,sortable: false,formatter: editLinkH},
        {name:'delete',search:false,index:'warehouse_id',width:60,sortable: false,formatter: deleteLinkH},
         
    ],
    rowNum:10,
    rowList:[20,60,100],
    height:460,
    pager: "#pagingDiv",
    viewrecords: true,
    caption: ""
});
});

function editLinkH(cellValue, options, rowdata, action)  {
    
	var warehouseId = rowdata.warehouse_id;
	return "<a class='btn btn-info pull-right fa fa-pencil-square-o' href='javascript:editRecordWH(" + rowdata.warehouse_id + ")'></a>";

	
	
}
function editRecordWH(warehouseId){
  
	
$.ajax({
		
		type : "POST",
		encoding : "UTF-8",
		url : "getWarehouseDetailsById",
		datatype :'json', 
		data : {
			warehouseId : warehouseId,
			        },
		success : function(data) {

			 $("#addWarehouseDiv").fadeIn(500);
			 $("#viewWarehouseDiv").hide();
			 $('#dashboardDiv').hide();

			 $('#addTitle').hide();
			 $('#saveWarehouseInfo').hide();
			 
			 $('#updateTitle').fadeIn();
			 $('#updateWarehouseInfo').show();
			 $('#cancelWarehouseInfo').show();
			 $('#addWarehouse').hide();
			 
				$("#warehouseName").val("");
				$("#floorBuiltupArea").val("");
				$("#floorCarpetArea").val("");
				$("#rackBuiltupArea").val("");
				$("#rackCarpetArea").val("");
				$("#totalNumberOfDocks").val("");
				$("#numberOfDocksAvailable").val("");
			 
			
			 var posts = JSON.parse(data);
			console.log("SUCCESS: ", posts.warehouse_name);
			
			$("#warehouseId").val(posts.warehouse_id);
			$("#warehouseName").val(posts.warehouse_name);
			$("#floorBuiltupArea").val(posts.floor_builtup_area);
			$("#floorCarpetArea").val(posts.floor_carpet_area);
			$("#rackBuiltupArea").val(posts.rack_builtup_area);
			$("#palette_positions").val(posts.palette_positions);
			$("#totalNumberOfDocks").val(posts.total_docks);
			$("#numberOfDocksAvailable").val(posts.availabe_docks);
			
          
			
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
           
    
    
    