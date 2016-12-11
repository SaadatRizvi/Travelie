 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<title>Save Route</title>

<link type ="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	
	
	<link type ="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-form-style.css">
      
	
	
<body>
	<div id= "wrapper">
		<div id="header">
			<h2>RRM - Route Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Route</h3>
		
		<form:form action="saveRoute" modelAttribute="route" method="POST">
		
		<form:hidden path="id"/>
			<table>
				<tbody>
				<tr>
					<td><label>Source:</label></td>
					<td><form:input path="source" /> </td>
					
				</tr>
				<tr>
					<td><label>Destination:</label></td>
					<td><form:input path="destination_location" /> </td>
					
				</tr>
				<tr>
					<td><label>Expected Travel Time:</label></td>
					<td><form:input path="expectedTravelTime" /> </td>
					
				</tr>
				<tr>
					<td><label>Economy Fare:</label></td>
					<td><form:input path="economyFare" /> </td>
					
				</tr>
				<tr>
					<td><label>AC Fare:</label></td>
					<td><form:input path="acFare" /> </td>
					
				</tr>
				<tr>
					<td><label>State:</label></td>
					<td><form:input path="state" /> </td>
					
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save" /> </td>
					
				</tr>
				
				</tbody>
			
			</table>
		
		
		</form:form>
		
		<div style ="clear;both;"></div>
		
		<p>
		<a href="${pageContext.request.contextPath}/route/list">Back to List</a>
		</p>
	
	</div>

</body>


</html>