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
    <title>Weather App</title>

  </head>
  <body>
  	<div class="container">
  		<div class="searchArea">
  			<input type="text" id="searchBox">
  			<button onclick="search()">Search</button>
  			<div class="result">
  				
  			</div>
  		</div>

  		
  	</div>

	<script src="<c:url value="/resources/js/jquery-3.5.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/weather.js" />"></script>
  </body>
</html>
