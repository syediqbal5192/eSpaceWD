jQuery(document).ready(function () {

	var salesPipeLineId = "14";
 
	$("#readinessTemplateReportGrid").jqGrid({
		url: "listReadinessTemplate",
	    postData: {
	    	salesPipeLineId: salesPipeLineId,
	    },
		 datatype: "json",
		 jsonReader: {repeatitems: false, id: "ref"},
		 colNames:['Company Name','Readiness Name','Owner Name','Element Status','ReadinessQuantity','Start Date','End Date'],
		    colModel: [ {
		    	name:'companyName',
		    	index:'companyName',
		    	width: 90
		    },{
	        name: 'readiness_element_name',
	        index: 'readiness_element_name',
	        width: 90
	        
	    }, {
	        name: 'ownerName',
	        index: 'ownerName',
	        width:80
	      
	    },{
	        name: 'readinessElementStatus',
	        index: 'readinessElementStatus',
	        width:80
	    }, {
	        name: 'readinessElementQuantity',
	        index: 'readinessElementQuantity',
	        width:80
	    },
	    {
	        name: 'taskStartDate',
	        index: 'taskStartDate',
	        width:80
	         
	    }, {
	        name: 'taskEndDate',
	        index: 'taskEndDate',
	        width:120 
	    }],
	    pager: '#pager',
	    height:500,
	    width:950
	    
	});
	
});
