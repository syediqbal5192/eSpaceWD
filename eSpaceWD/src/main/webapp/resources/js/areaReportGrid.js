jQuery(document).ready(function () {

	var clientStatusFilter = "confirmed";
	
jQuery("#areaGrid").jqGrid({
    url: "areaReportController",
    postData: {
    	clientStatusFilter: clientStatusFilter,
    },
    async : false,
    datatype: "json",
    jsonReader: {repeatitems: false, id: "ref"},
    colNames:['Customer Name','Customer Name', 'Status Work','Sellable Area','Est.Floor Built-up Area', 'Actual Floor Built-up Area','Est.Floor Carpet Area', 'Actual Floor Carpet Area','Date of Creation'],
    colModel:[
{
	name:'customerName',
	index:'customerName', 
	width:0.1
},
        {
        	name:'customerName',
        	index:'customerName', 
        	width:150
        },
        {
        			name:'statusNew',
        			index:'statusNew', 
        			width:120,
      		},
      		{
				name:'totalSellableArea',
				index:'totalSellableArea', 
				width:110
				
			},
        {
        				name:'estimatedFloorBuiltupArea',
        				index:'estimatedFloorBuiltupArea', 
        				width:150
        			},
        {
        				name:'actualFloorBuiltupArea',
        				index:'actualFloorBuiltupArea', 
        				width:150
        			},
        {
        				name:'estimatedFloorCarpetArea',
        				index:'estimatedFloorCarpetArea', 
        				width:150
        			},
        {
        				name:'actualFloorCarpetArea',
        				index:'actualFloorCarpetArea', 
        				width:150
        			},
        {
        					name:'dateOfCreation',
        					index:'dateOfCreation', 
        					width:150,
        					

        				}
        /*{name:'ageingDays',index:'ageingDays', width:100},*/
    ],
    rowNum:10,
    rowList:[5,10,20],
    height:360,
    pager: "#pagingDiv5",
    viewrecords: true,
    sortable: true,
    sortname: "customerName",
    sortorder: "desc",
    viewrecords: true,
    loadonce: false,
    gridview: true,
    autoencode: true,
    ignoreCase: true,   //  Make the "Search" popup search case-insensitive 
    footerrow: true,
    loadComplete : function(){
    	var $grid = $("#areaGrid");
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
    	
    	 
    },
    caption: ""
   
});
// activate the toolbar searching
/*$('#areaGrid').jqGrid('filterToolbar',{
    // JSON stringify all data from search, including search toolbar operators
    stringResult: true,
    // instuct the grid toolbar to show the search options
    searchOperators: true
});*/



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
    var fileName = "Area_Report_";
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


$('#excelAreaPort').click(function() {
    console.log('test');
   JSONToCSVConvertor(JSON.stringify($('#areaGrid').jqGrid('getRowData')), 'Title', true);
});



});

