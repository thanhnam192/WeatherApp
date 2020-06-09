$(document).ready(function() {
	console.log('ready to serve...');
	$("#showMoreBtn").hide();
	$("#csvBtn").hide();
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
	$("#csvBtn").hide();
	$.get( path + "/api/weather?city="+city, function( data ) {
		$("#searchBtn").html('Search');
		console.log(data);
		if( typeof data == 'object' ) {
			$("#resultArea").html(createCard(data));
			validCity = data.city;
			
			$("#showMoreBtn").show();
		} else  {
			
			console.log('asdasdas');
			$("#resultArea").html('<tr><td colspan="8"><strong>' + data + '</strong></td></tr>');
		}
	});
	
}

function confirmDelete(id){
	currentWeatherId = id;
}

function removeLog(){
	$.ajax({
	    url: path + '/api/weather/' + currentWeatherId,
	    type: 'DELETE',
	    success: function(result) {
	    	
	    	if(showMode){
	    		removeWeatherLogFromLocal(currentWeatherId);
	    		loadWeatherLogsFromLocal();
	    	} else {
	    		$("#resultArea").html('');
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

	$.get( path + "/api/weather/showall?city="+validCity, function( weathers ) {
		$("#showMoreBtn").html('Show More');
		console.log(weathers);
		if( typeof weathers == 'object' ) {
			var card = '';
			for(var i = 0; i < weathers.length; i++){
				
				var data = weathers[i];
				card += createCard(data);
				allWeather.push(data);
				
			}
			console.log(allWeather);
			
			$("#resultArea").html(card);
			$("#csvBtn").attr("href", path + "/api/weather/downloadCSV?city=" + validCity);
			$("#csvBtn").show();

		} else  {
			$("#resultArea").html('<tr><td colspan="8"><strong>' + data + '</strong></td></tr>');
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
	if( allWeather.length == 0 ) {
		$("#resultArea").html('');
		$("#csvBtn").hide();
		$("#showMoreBtn").hide();
		return;
	}
	
	console.log('load from local');
	console.log(allWeather);
	var card = '';
	for(var i = 0; i < allWeather.length; i++){
		var data = allWeather[i];
		card += createCard(data);
		
	}

	$("#resultArea").html(card);
}

function calculateCloud(cloudPercent){
	return cloudPercent >= 40 ? 'Clouds' : '';
}

function createCard(data){
	var cloud = calculateCloud(data.cloud);
	var card = '<div class="col-sm-12"><div class="card" style="width: 35rem;"><div class="card-body"><div class="row">';
	card += '<div class="col-sm-2"><img src="' + data.weatherIcon + '" alt="Card image cap"></div>';
	card += '<div class="col-sm-3">' 
			+'<p class="text-md-left">' + data.city + '</p>' 
			+'<p class="font-weight-light">' + data.date + '</p>' 
			+'</div>';
	card += '<div class="col-sm-5">'
				+ '<p><span class="badge badge-secondary">' + data.temp.toFixed(1) + ' &#8451;</span> ' + cloud + '</p>'
				+ '<p class="text-sm-left"> ' + data.windSpeed + ' m/s, ' + data.humidity + '%, ' + data.pressure + 'hpa</p>'
				+ '</div>';
	card += '<div class="col-sm-2 align-items-center"><button onclick="confirmDelete(' + data.id +')" class="btn btn-danger" data-toggle="modal" data-target="#confirmModal" >Delete</button></div>';
	card += '</div></div></div></div>';
	
	return card;
	
}