$(document).ready(function() {
	console.log('ready to serve...')
})


function search(pageNo){
	var city = $("#searchBox").val();
	
	$.getJSON("/weatherapp/api/weather?city="+city, function(data){
		console.log(data);
	});
}