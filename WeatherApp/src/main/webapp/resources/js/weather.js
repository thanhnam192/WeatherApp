$(document).ready(function() {
	console.log('ready to serve...');
	$("#showMoreBtn").hide();
	/*$("#csvBtn").hide();*/
})

var validCity = '';
var showMode = false;
var currentWeatherId = 0;
var allWeather = [];
function search(){
	currentWeatherId = 0;
	showMode = false;
	allWeather = [];
	var city = $("#searchBox").val().trim();
	if( city == '' ) return;
	var sprinner = '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Searching';
	$("#searchBtn").html(sprinner);
	$.get( "/weatherapp/api/weather?city="+city, function( data ) {
		$("#searchBtn").html('Search');
		console.log(data);
		if( typeof data == 'object' ) {
			var row = '<tr>';
			row += '<td><img src="'+ data.weatherIcon + '" ></td>';
			row += '<td>' +  data.city + '</td>';
			row += '<td>' + data.date + '</td>';
			row += '<td>' + data.temp + '</td>';
			row += '<td>' + data.windSpeed + '</td>';
			row += '<td>' + data.humidity + '</td>';
			row += '<td>' + data.pressure + '</td>';
			row += '<td><button onclick="confirmDelete(' + data.id +')" class="btn btn-warning" data-toggle="modal" data-target="#confirmModal" >Delete</button></td>';
			row += '</tr>';
			
			$("#weatherResultTb tbody").html(row);
			validCity = data.city;

			$("#showMoreBtn").show();
		} else  {
			
			
			$("#weatherResultTb tbody").html('<tr><td colspan="8"><strong>' + data + '</strong></td></tr>');
		}
	});
	
}

function confirmDelete(id){
	currentWeatherId = id;
}

function removeLog(){
	$.ajax({
	    url: '/weatherapp/api/weather/' + currentWeatherId,
	    type: 'DELETE',
	    success: function(result) {
	    	
	    	if(showMode){
	    		removeWeatherLogFromLocal(currentWeatherId);
	    		loadWeatherLogsFromLocal();
	    	} else {
	    		$("#weatherResultTb tbody").html('');
	    	}
	    	
	    	currentWeatherId = 0;
	    }
	});
}

function showMoreWeather(){
	showMode = true;
	currentWeatherId = 0;
	allWeather = [];
	var sprinner = '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Loading';
	$("#showMoreBtn").html(sprinner);

	$.get( "/weatherapp/api/weather/showall?city="+validCity, function( weathers ) {
		$("#showMoreBtn").html('Show More');
		console.log(weathers);
		if( typeof weathers == 'object' ) {
			var row = '';
			for(var i = 0; i < weathers.length; i++){
				
				var data = weathers[i];
				row += '<tr>';
				row += '<td><img src="'+ data.weatherIcon + '" alt="img" ></td>';
				row += '<td>' +  data.city + '</td>';
				row += '<td>' + data.date + '</td>';
				row += '<td>' + data.temp + '</td>';
				row += '<td>' + data.windSpeed + '</td>';
				row += '<td>' + data.humidity + '</td>';
				row += '<td>' + data.pressure + '</td>';
				row += '<td><button onclick="confirmDelete(' + data.id +')" class="btn btn-warning" data-toggle="modal" data-target="#confirmModal" >Delete</button></td>';
				row += '</tr>';
				
				allWeather.push(data);
				
			}
			console.log(allWeather);
			
			$("#weatherResultTb tbody").html(row);
			$("#csvBtn").attr("href", "/weatherapp/api/weather/downloadCSV?city=" + validCity);
			$("#csvBtn").show();

		} else  {
			$("#weatherResultTb tbody").html('<tr><td colspan="8"><strong>' + data + '</strong></td></tr>');
		}
	});
	
}

function removeWeatherLogFromLocal(id){
	var index = allWeather.findIndex( w => w.id === id);
	if( index != -1) {
		allWeather.splice(index,1);
	}
}

function loadWeatherLogsFromLocal(){
	if( allWeather.length == 0 ) return;
	
	console.log('load from local');
	console.log(allWeather);
	var row = '';
	for(var i = 0; i < allWeather.length; i++){
		var data = allWeather[i];
		row += '<tr>';
		row += '<td><img src="'+ data.weatherIcon + '" alt="img" ></td>';
		row += '<td>' +  data.city + '</td>';
		row += '<td>' + data.date + '</td>';
		row += '<td>' + data.temp + '</td>';
		row += '<td>' + data.windSpeed + '</td>';
		row += '<td>' + data.humidity + '</td>';
		row += '<td>' + data.pressure + '</td>';
		row += '<td><button onclick="confirmDelete(' + data.id +')" class="btn btn-warning" data-toggle="modal" data-target="#confirmModal" >Delete</button></td>';
		row += '</tr>';
		
	}

	$("#weatherResultTb tbody").html(row);
}