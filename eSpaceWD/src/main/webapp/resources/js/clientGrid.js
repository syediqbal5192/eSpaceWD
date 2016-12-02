jQuery(document).ready(function () {

	var clientWarehouseFilter = "1";
	
jQuery("#clientGrid").jqGrid({
    url: "clientReportController",
    postData: {
    	clientWarehouseFilter: clientWarehouseFilter,
    },
    async : false,
    datatype: "json",
    jsonReader: {repeatitems: false, id: "ref"},
    colNames:['Customer Name','Customer Name', 'Status Work','Est.Floor Built-up Area', 'Actual Floor Built-up Area','Est.Floor Carpet Area', 'Actual Floor Carpet Area','Expected Revenue','Actual Revenue','Sellable Area','Active','Deleted'],
    colModel:[
{
	name:'customerName',
	index:'customerName', 
	width:0.3
}, 
        {
        	name:'customerName',
        	index:'customerName', 
        	width:120
        },
        {
        			name:'statusNew',
        			index:'statusNew', 
        			width:80
        		},
        {
        				name:'estimatedFloorBuiltupArea',
        				index:'estimatedFloorBuiltupArea', 
        				width:110
        			},
        {
        				name:'actualFloorBuiltupArea',
        				index:'actualFloorBuiltupArea', 
        				width:110
        			},
        {
        				name:'estimatedFloorCarpetArea',
        				index:'estimatedFloorCarpetArea', 
        				width:110
        			},
        {
        				name:'actualFloorCarpetArea',
        				index:'actualFloorCarpetArea', 
        				width:110
        			},
        			{
        				name:'expectedRevenue',
        				index:'expectedRevenue', 
        				width:110
        				
        			},
        			{
        				name:'actualRevenue',
        				index:'actualRevenue', 
        				width:110
        				
        			},

        			{
        				name:'totalSellableArea',
        				index:'totalSellableArea', 
        				width:110
        				
        			},
        {
        					name:'isActive',
                			index:'isActive', 
                			width:50,
                		    // stype defines the search type control - in this case HTML select (dropdownlist)
                            //stype: "select",
                            // searchoptions value - name values pairs for the dropdown - they will appear as options
                           // searchoptions: {value:"Yes:Yes;No:No"} 							
        						},
        				        {
                					name:'isDeleted',
                        			index:'isDeleted', 
                        			width:50
                        		    // stype defines the search type control - in this case HTML select (dropdownlist)
                                    //stype: "select",
                                    // searchoptions value - name values pairs for the dropdown - they will appear as options
                                   // searchoptions: {value:"Yes:Yes;No:No"} 							
                						}
        					
      
    ],
    rowNum:10,
    rowList:[5,10,20],
    height:300,
    pager: "#pagingDiv5",
    viewrecords: true,
    sortable: true,
    sortname: "salesPipeLineId",
    sortorder: "desc",
    viewrecords: true,
    gridview: true,
    autoencode: true,
    ignoreCase: true,   //  Make the "Search" popup search case-insensitive 
    footerrow: true,
    
    loadComplete : function(){
    	var $grid = $("#clientGrid");
    	var total = 'Total : '
        	$grid.jqGrid('footerData','set',{statusWork : total});
        
    	var colSum = $grid.jqGrid('getCol','estimatedFloorBuiltupArea',false,'sum');
    	$grid.jqGrid('footerData','set',{estimatedFloorBuiltupArea : colSum});
    	
    	var colSum = $grid.jqGrid('getCol','actualFloorBuiltupArea',false,'sum');
    	$grid.jqGrid('footerData','set',{actualFloorBuiltupArea : colSum});
    	
    	var colSum = $grid.jqGrid('getCol','estimatedFloorCarpetArea',false,'sum');
    	$grid.jqGrid('footerData','set',{estimatedFloorCarpetArea : colSum});
    	
    	var colSum = $grid.jqGrid('getCol','actualFloorCarpetArea',false,'sum');
    	$grid.jqGrid('footerData','set',{actualFloorCarpetArea : colSum});
    	
    	var colSum = $grid.jqGrid('getCol','expectedRevenue',false,'sum');
    	$grid.jqGrid('footerData','set',{expectedRevenue : colSum});
    	
    	var colSum = $grid.jqGrid('getCol','actualRevenue',false,'sum');
    	$grid.jqGrid('footerData','set',{actualRevenue : colSum});
    	
    	$(this).jqGrid('hideCol',["ID"]);
    },
    caption: ""
   
});
// activate the toolbar searching
/*$('#clientGrid').jqGrid('filterToolbar',{
    // JSON stringify all data from search, including search toolbar operators
    stringResult: true,
    // instuct the grid toolbar to show the search options
    searchOperators: true
});
*/


function JSONToCSVConvertor(JSONData, ReportTitle, ShowLabel) {
    //If JSONData is not an object then JSON.parse will parse the JSON string in an Object
    var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;
    
    var CSV = '';    
    //Set Report title in first row or line
    
    CSV += ReportTitle + '\r\n\n';

    //This condition will generate the Label/Header
    if (ShowLabel) {
        var row = "";
        
        //This loop will extract the label from 1st index of on array
        for (var index in arrData[0]) {
            
            //Now convert each value to string and comma-seprated
            row += index + ',';
        }

        row = row.slice(0, -1);
        
        //append Label row with line break
        CSV += row + '\r\n';
    }
    
    //1st loop is to extract each row
    for (var i = 0; i < arrData.length; i++) {
        var row = "";
        
        //2nd loop will extract each column and convert it in string comma-seprated
        for (var index in arrData[i]) {
            row += '"' + arrData[i][index] + '",';
        }

        row.slice(0, row.length - 1);
        
        //add a line break after each row
        CSV += row + '\r\n';
    }

    if (CSV == '') {        
        alert("Invalid data");
        return;
    }   
    
    //Generate a file name
    var fileName = "Client_Report_";
    //this will remove the blank-spaces from the title and replace it with an underscore
    fileName += ReportTitle.replace(/ /g,"_");   
    
    //Initialize file format you want csv or xls
    var uri = 'data:text/csv;charset=utf-8,' + escape(CSV);
    
    // Now the little tricky part.
    // you can use either>> window.open(uri);
    // but this will not work in some browsers
    // or you will not get the correct file extension    
    
    //this trick will generate a temp <a /> tag
    var link = document.createElement("a");    
    link.href = uri;
    
    //set the visibility hidden so it will not effect on your web-layout
    link.style = "visibility:hidden";
    link.download = fileName + ".csv";
    
    //this part will append the anchor tag and remove it after automatic click
    console.log(document.body);
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
}


$('#excelClientPort').click(function() {
    console.log('test');
   JSONToCSVConvertor(JSON.stringify($('#clientGrid').jqGrid('getRowData')), 'Title', true);
});



});

