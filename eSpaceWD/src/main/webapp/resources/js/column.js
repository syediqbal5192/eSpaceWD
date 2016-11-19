

var chart; 

	$(function () {

	    $.getJSON('chartSalesPipeLine', function (data) {
	        
	    	
	    	// Create the chart
	        $('#container3').highcharts({
      
	        	chart: {
	                type: 'column',
	               
	            },
	            title: {
	                text: 'OverView'
	            },
	            subtitle: {
	                text: 'Warehouse,Sales Overview'
	            },
	            xAxis: {
	                categories: data,
	                crosshair: true
	            },
	            
	            yAxis: {
	                min: 0,
	                title: {
	                    text: 'Area (sql.ft)'
	                }
	            },

	            tooltip: {
	                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	                    '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
	                footerFormat: '</table>',
	                shared: true,
	                useHTML: true
	            },
	            plotOptions: {
	                column: {
	                    pointPadding: 0.2,
	                    borderWidth: 0
	                }
	            },
	            
	            series: [{
	                name: 'Amazon',
	                data: [49.9, 71.5,20.5]

	            }, {
	                name: 'Shoperstop',
	                data: [83.6, 78.8, 98.5]

	            }, {
	                name: 'Relaince',
	                data: [48.9, 38.8, 39.3 ]

	            }, {
	                name: 'Britania',
	                data: [42.4, 33.2, 34.5]

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


	 
     


