jQuery(document).ready(function () {

	jQuery("#gridRT").jqGrid({
		 url: "listReadinessTemplate",
	    async : false,
	    datatype: "json",
	    postData: {
	    	salesPipeLineId: 3,
	    },
	    jsonReader: {repeatitems: false, id: "ref"},
	    colNames:['readinessTemplateId','Company Name','Readiness Name','readinessElementQuantity','Owner Name','Element Status','Start Date','End Date'],
	    colModel:[
	        {name:'readinessTemplateId',index:'readinessTemplateId',width:40},
	        {name:'companyName',index:'companyName', width:140},
	        {name:'readinessName',index:'readinessName', width:140},
	        {name:'readinessElementQuantity',index:'readinessElementQuantity',width:40},
	        {name:'ownerName',index:'ownerName', width:140},
	        {name:'readinessElementStatus',index:'readinessElementStatus',width:40},
	        {name:'taskStartDate',index:'taskStartDate', width:140},
	        {name:'taskEndDate',index:'taskEndDate', width:140},
	         
	    ],
	    rowNum:5,
	    rowList:[5,10,20],
	    viewrecords: true, 
	    sortname: 'num',
        sortorder: "asc", 
        height: '100%',
	    caption: "Readiness Element List: "
	});
	});

	
