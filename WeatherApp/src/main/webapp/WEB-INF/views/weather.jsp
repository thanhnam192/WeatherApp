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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<title>Weather Application</title>
 	 <c:set var="path" value="${pageContext.request.contextPath}"></c:set>
  </head>
  <body>
  	<nav class="navbar navbar-light bg-light">
	  <a class="navbar-brand" href="#">
	    Weather Application - Nam Nguyen
	  </a>
	</nav>
	<br/>

  	<div class="container">
  		<div class="row">
			<form class="form-inline">
				<div class="form-group mx-sm-3 mb-2">
			    	<input type="text" class="form-control" id="searchBox" placeholder="Your City">
			  	</div>
	
			  	<button type="button" onclick="search()" class="btn btn-primary mb-2" id="searchBtn">Search</button>
			</form>	
  		</div>
  		
  		<div class="row mt-1 mb-1">
			<div class="col-sm">
				<button id="showMoreBtn" class="btn btn-secondary float-left" onclick="showMoreWeather()">Show More</button>
				<a href="#"  target="_blank" class="btn btn-primary float-left" id="csvBtn" style="margin-left: 10px;"><i class="fa fa-download"></i></a>
			</div>
			
		</div>
  		
	
		<div class="result row" id="resultArea">
			<p><b>Let do a Search to get current weather</b></p>	
		</div>

  	</div>
  	
  	<div class="modal" tabindex="-1" role="dialog" id="confirmModal">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Confirm</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <p>Are you sure to delete this weather log?</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="removeLog()">Yes</button>
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
	      </div>
	    </div>
	  </div>
	</div>
	

  	
  	<script>
		var path = '<c:out value="${path}"/>';
		console.log(path);
  	</script>
	<script src="<c:url value="/resources/js/jquery-3.5.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/weather.js" />"></script>
	<script src="<c:url value="/resources/js/waiting.js" />"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
  </body>
</html>
