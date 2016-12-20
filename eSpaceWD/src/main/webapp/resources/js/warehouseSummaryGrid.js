jQuery(document).ready(function () {

jQuery("#warehouseSummaryGrid").jqGrid({
    url: "listWarehouseSummary",
    async : false,
    datatype: "json",
    jsonReader: {repeatitems: false, id: "ref"},
    colNames:['Id','Warehouse Name','Total Sellable Area', 'Utilized Space' , 'Vacant Space','Revenue'],
    colModel:[
        {name:'name',index:'name', width:0.5},
        {name:'name',index:'name', width:150},
        {name:'totalSellableArea',index:'totalSellableArea', width:150},
        {name:'totalUtilizedSpace',index:'totalUtilizedSpace', width:150},
        {name:'avialableSpace',index:'avialableSpace', width:150},
        {name:'perWarehouseRevenue',index:'perWarehouseRevenue', width:150},
    ],
    rowNum:10,
    rowList:[20,60,100],
    height:260,
    pager: "#pagingDivWarehouse",
    viewrecords: true,
    caption: ""
});
});


    
    