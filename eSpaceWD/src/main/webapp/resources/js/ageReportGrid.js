jQuery(document).ready(function () {

jQuery("#grid5").jqGrid({
    url: "ageReportController",
    async : false,
    datatype: "json",
    jsonReader: {repeatitems: false, id: "ref"},
    colNames:['ID','Customer Name', 'Warehouse ','Status Work','Floor Built-up Area', 'Date of Creation','Age(In Days)'],
    colModel:[
        {
        	name:'salesPipeLineId',
        	index:'salesPipeLineId', 
        	width:60
        }, 
        {
        	name:'customerName',
        	index:'customerName', 
        	width:150
        },
        {
        		name:'allocatedWarehouse',
        		index:'allocatedWarehouse', 
        		width:120
        	},
        {
        			name:'statusWork',
        			index:'statusWork', 
        			width:120
                
        		},
        {
        				name:'estimatedFloorBuiltupArea',
        				index:'estimatedFloorBuiltupArea', 
        				width:150
        			},
        {
        					name:'estimatedStartDate',
        					index:'estimatedStartDate', 
        					width:150

        				},
        {
        					
        					name:'age',
        						index:'age', 
        						width:140
        					},
    ],
    rowNum:5,
    rowList:[20,60,100],
    height:160,
    pager: "#pagingDiv5",
    viewrecords: true,
    loadonce: true,
    sortable: true,
    sortname: "salesPipeLineId",
    sortorder: "desc",
    viewrecords: true,
    gridview: true,
    autoencode: true,
    ignoreCase: true,   //  Make the "Search" popup search case-insensitive 
    caption: ""
   
});
// activate the toolbar searching
/*$('#grid5').jqGrid('filterToolbar',{
   
    stringResult: true,
   
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
    var fileName = "MyReport_";
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


$('#excelPort').click(function() {
    console.log('test');
   JSONToCSVConvertor(JSON.stringify($('#grid5').jqGrid('getRowData')), 'Title', true);
});



});

