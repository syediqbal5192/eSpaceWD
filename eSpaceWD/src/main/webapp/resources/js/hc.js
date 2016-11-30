

var chart; 

	$(function () {

	    $.getJSON('listWarehouseByActive', function (data) {
	        // Create the chart
	        $('#container2').highcharts({
      
	        	chart: {
	                type: 'pie',
	                events: {
	                    drilldown: function (e) {
	                    	chart = this;
	                        if (!e.seriesOptions) {
	                            // e.point.name is info which bar was clicked
	                            chart.showLoading('Simulating Ajax ...');
	                            $.getJSON("listWarehouseDrillDown",{ warehouseName : e.point.name}, function(data) {
	                               
	                               chart.hideLoading();
	                               data = {  
	                                       name: e.point.name,  
	                                       data: data  
	                                   }
	                               
	                               setTimeout(function () {  
	                                   chart.hideLoading();  
	                                   chart.addSeriesAsDrilldown(e.point, data);  
	                               }, 1000); 
	                               
	                               
	       	                            // e.point.name is info which bar was clicked
	       	                        /*    chart.showLoading('Simulating Ajax ...');
	       	                            $.getJSON("listReadinessDrillDown",{ customerName : e.point.name}, function(data) {
	       	                               
	       	                               chart.hideLoading();
	       	                               data = {  
	       	                                       name: e.point.name,  
	       	                                       data: data  
	       	                                   }
	       	                               
	       	                               setTimeout(function () {  
	       	                                   chart.hideLoading();  
	       	                                   chart.addSeriesAsDrilldown(e.point, data);  
	       	                               }, 1000); 
	       	                               
	       	                               
	       	                              
	       	                            });
	       	                       */
	                                /*chart.addSeriesAsDrilldown({
	                                	name: e.point.name,
	                                	id: e.point.name,
	                                	data: data
	                                });*/
	                            });
	                        }
	                    }
	                }
	            },
	            title: {
	                text: 'Total Area of Warehouses with Available Area Drill Down'
	            },
	            subtitle: {
	                text: ''
	            },
	            plotOptions: {
	                series: {
	                    dataLabels: {
	                        enabled: true,
	                        format: '{point.name}: {point.y} sqft'
	                    }
	                }
	            },

	            tooltip: {
	                headerFormat: '<span style="font-size:16px">{series.name}</span><br>',
	                pointFormat: '<span style="font-size:16px;color:{point.color}">{point.name}: <b>{point.y}</b> of total</span><br/>'
	            },
	            series: [{
	                name: 'Status',
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

	  function CallChild(name) {  
	      var Drilldowndata = [];  
	      $.ajax({  
	          type: "POST",  
	          url: "listWarehouseDrillDown",  
	          data: { warehouseName : name },  
	          dataType: "json",  
	          success: function (Result) {  
	              Result = Result.d;  
	              for (var i in Result) {  
	                  var serie = { name: Result[i].year, y: Result[i].amount };  
	                  Drilldowndata.push(serie);  
	              }  
	          },  
	          error: function (Result) {  
	              alert("Error");  
	          }  
	      })  
	      return Drilldowndata;  
	  }
	 
     


