 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<title>Save Booking</title>

<link type ="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	
	
	<link type ="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-form-style.css">
      
	
	
<body>
	<div id= "wrapper">
		<div id="header">
			<h2>BRM - Booking Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Booking</h3>
		
		<form:form action="saveBooking" modelAttribute="booking" method="POST">
		
		<form:hidden path="id"/>
			<table>
				<tbody>
				<tr>
					<td><label>Van ID:</label></td>
					<td><form:input path="van" /> </td>
					
				</tr>
				<tr>
					<td><label>Driver ID:</label></td>
					<td><form:input path="driver" /> </td>
					
				</tr>
				<tr>
					<td><label>Route ID:</label></td>
					<td><form:input path="route" /> </td>
					
				</tr>
				<tr>
					<td><label>Registered Seats #:</label></td>
					<td><form:input path="registeredSeats" /> </td>
					
				</tr>
				<tr>
					<td><label>Departure Date:</label></td>
					<td><form:input path="departureDate" /> </td>
					
				</tr>
				<tr>
					<td><label>Departure Time:</label></td>
					<td><form:input path="departureTime" /> </td>
					
				</tr>
				<tr>
					<td><label>Arrival Time:</label></td>
					<td><form:input path="arrivalTime" /> </td>
					
				</tr>
				<tr>
					<td><label>Expected Price:</label></td>
					<td><form:input path="expectedPrice" /> </td>
					
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
		<a href="${pageContext.request.contextPath}/booking/list">Back to List</a>
		</p>
	
	</div>

</body>


</html>