jQuery(document).ready(function () {

jQuery("#salesPipeLineSummaryGrid").jqGrid({
    url: "listSalesPipeLineSummary",
    async : false,
    datatype: "json",
    jsonReader: {repeatitems: false, id: "ref"},
    colNames:['Id','Customer Name','Total Sellable Area', 'Proposed Warehouse'],
    colModel:[
        {name:'customerName',index:'customerName', width:0.5},
        {name:'customerName',index:'customerName', width:140},
        {name:'totalSaleArea',index:'totalSaleArea', width:140},
        {name:'allocatedWarehouse',index:'allocatedWarehouse', width:140},
         
    ],
    rowNum:10,
    rowList:[20,60,100],
    height:460,
    pager: "#pagingDivSalesPipeLineSummary",
    viewrecords: true,
    caption: ""
});
});


    
    