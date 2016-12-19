jQuery(document).ready(function () {

jQuery("#warehouseSummaryGrid").jqGrid({
    url: "listWarehouseSummary",
    async : false,
    datatype: "json",
    jsonReader: {repeatitems: false, id: "ref"},
    colNames:['Id','Warehouse Name','Total Sellable Area', 'Utilized Space' , 'Vacant Space'],
    colModel:[
        {name:'name',index:'name', width:0.5},
        {name:'name',index:'name', width:140},
        {name:'totalSellableArea',index:'totalSellableArea', width:140},
        {name:'totalUtilizedSpace',index:'totalUtilizedSpace', width:140},
        {name:'avialableSpace',index:'avialableSpace', width:120},
         
    ],
    rowNum:10,
    rowList:[20,60,100],
    height:460,
    pager: "#pagingDivWarehouse",
    viewrecords: true,
    caption: ""
});
});


    
    