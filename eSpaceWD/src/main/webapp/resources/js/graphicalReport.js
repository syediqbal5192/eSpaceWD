

var chart; 

	$(function () {

	    $.getJSON('listWarehouseByActive', function (data) {
	        // Create the chart
	        $('#container').highcharts({
      
	        	chart: {
	                type: 'pie',
	                events: {
	                    drilldown: function (e) {
	                    	chart = this;
	                        if (!e.seriesOptions) {
	                            // e.point.name is info which bar was clicked
	                            chart.showLoading('Simulating Ajax ...');
	                            $.getJSON("listWarehouseDrillDown",{ warehouseName : e.point.name}, function(data) {
	                                /***
	                                where data is this format:
	                                data = {
	                                    name: 'Cars',
	                                    data: [
	                                        ['Toyota', 1],
	                                        ['Volkswagen', 2],
	                                        ['Opel', 5]
	                                    ]
	                                }
	                                
	                                ***/
	                               chart.hideLoading();
	                               
	                                chart.addSeriesAsDrilldown({
	                                	name: e.point.name,
	                                	id: e.point.name,
	                                	data: [
	                                           ['v11.0', 24.13]
	                                           
	                                       ]
	                                    
	                                	
	                                });
	                            });
	                        }
	                    }
	                }
	            },
	            title: {
	                text: 'Total Area of Warehouses with Available Area Drill Down'
	            },
	            subtitle: {
	                text: 'Click the slices to avialable spaces'
	            },
	            plotOptions: {
	                series: {
	                    dataLabels: {
	                        enabled: true,
	                        format: '{point.name}: {point.y:.1f}sqft'
	                    }
	                }
	            },

	            tooltip: {
	                headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
	                pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
	            },
	            series: [{
	                name: 'AAPL',
	                data: data
	                
	            }],   drilldown: {
	                series: [
	                         
	                         ]
	            },
	            
	            credits : 
	         	{
	         	
	         	enabled:false,
	         	}
	        });
	    });

	});


	 
     


