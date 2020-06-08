$(document).ready(function() {
	console.log('ready to serve...');
	$("#showMoreBtn").hide();
})

var validCity = '';
var showMode = false;
function search(pageNo){
	showMode = false;
	var city = $("#searchBox").val().trim();
	if( city == '' ) return;
	
	$.get( "/weatherapp/api/weather?city="+city, function( data ) {
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
			row += '<td><button onClick="removeLog(' + data.id +')" class="btn btn-warning" >Delete</button></td>';
			row += '</tr>';
			
			$("#weatherResultTb tbody").html(row);
			validCity = data.city;

			$("#showMoreBtn").show();
		} else  {
			
			
			$("#weatherResultTb tbody").html('<tr><td colspan="8"><strong>' + data + '</strong></td></tr>');
		}
	});
	
}

function removeLog(id){
	alert('remove log ' + id);
}

function showMoreWeather(){
	showMode = true;
	alert(123123);
}