jQuery(document).ready(function () {

	
	
$("#inlineGrid").jqGrid({
	 url: "listReadinessElements",
	 datatype: "json",
	 jsonReader: {repeatitems: false, id: "ref"},
	 colNames:['Readiness Name','ReadinessQuantity','Start Date','End Date','Owner Name','Element Status','Delete'],
	    colModel: [ {
        name: 'readiness_element_name',
        index: 'readiness_element_name'
        
    }, {
        name: 'readinessElementQuantity',
        index: 'readinessElementQuantity',
        editable: true,
        editrules:{required:true,}
    },
    {
        name: 'taskStartDate',
        index: 'taskStartDate',
        editable: true,
        editoptions: { 
        	dataInit: function (element) {
                $(element).datepicker({
                    id: 'taskStartDate',
                    dateFormat: 'yy-mm-dd',
                    //minDate: new Date(2010, 0, 1),
                    maxDate: new Date(2020, 0, 1),
                    showOn: 'focus'
                });
            }
        	} 
    }, {
        name: 'taskEndDate',
        index: 'taskEndDate',
        editable: true,
        editoptions: { 
        	dataInit: function (element) {
                $(element).datepicker({
                    id: 'taskEndDate',
                    dateFormat: 'yy-mm-dd',
                    //minDate: new Date(2010, 0, 1),
                    maxDate: new Date(2020, 0, 1),
                    showOn: 'focus'
                });
            }
        	} 
    }, {
        name: 'ownerName',
        index: 'ownerName',
        editable: true,
    },{
        name: 'readinessElementStatus',
        index: 'readinessElementStatus',
        editable: true,
        edittype:"select",
        formatter:'select', 
        editoptions:{value:"WIP:InProgress;COMP:Complete"}
    },
    { name: "Delete", formatter: buttonFormatter, width: 51,
	    search: false, sortable: false, hidedlg: true, resizable: false,
		editable: false, viewable: false}],
    pager: '#pager',
    'cellEdit': true,
    'cellsubmit' : 'clientArray',
    editurl: 'clientArray'
});


});

function buttonFormatter() {
	/*return "<a class='btn btn-danger pull-right fa fa-times' href='javascript:deleteRecordRT()'></a>";
	*/return "<button class='btn btn-danger pull-right fa fa-times' type='button' onClick='clickFunction1.call(this)'></button>";
}

function clickFunction1()
{
	

    
	var grid = $('#inlineGrid'), rowid = $(this).closest("tr.jqgrow").attr("id");
	var myCellData = grid.jqGrid('getCell', rowid, 'Name');
	alert("Selected  Name: " + myCellData);
	$('#inlineGrid').jqGrid('delRowData',rowid);
	
	
}
