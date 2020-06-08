<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Weather App</title>

  </head>
  <body>
  	<nav class="navbar navbar-light bg-light">
	  <a class="navbar-brand" href="#">
	    Weather Application
	  </a>
	</nav>
	<br/>
  	<div class="container">
  		<div class="row">
			<form class="form-inline">
				<div class="form-group mx-sm-3 mb-2">
			    	<input type="text" class="form-control" id="searchBox" placeholder="Your City">
			  	</div>
	
			  	<button type="button" onclick="search()" class="btn btn-primary mb-2">Search</button>
			</form>	
  		</div>
	
		<div class="result row">
  				<table id="weatherResultTb" class="table table-striped">
  					<thead>
  						<tr>
	  						<th scope="col">#</th>
	 						<th scope="col">City</th>
						    <th scope="col">Date</th>
						    <th scope="col">Degree</th>
						     <th scope="col">Wind Speed</th>
						     <th scope="col">Humidity</th>
						     <th scope="col">Pressure</th>
						     <th></th>
				     	</tr>
  					</thead>
  					<tbody>
  						<tr c><td colspan="8">Have no data</td></tr>
  					</tbody>
  				</table>
  				
		</div>
		
		<div class="row mt-1">
			<button id="showMoreBtn" class="btn btn-secondary" onClick="showMoreWeather()">Show More</button>
		</div>
			
		
  		
  	</div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="<c:url value="/resources/js/jquery-3.5.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/weather.js" />"></script>
  </body>
</html>
