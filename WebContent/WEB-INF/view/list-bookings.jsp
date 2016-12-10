<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Bookings</title>

	


<link type="text/css" rel="stylesheet"
 href="${pageContext.request.contextPath}/resources/css/style.css"/>
 

</head>
<body>

		<div id ="wrapper">
			<div id ="header">
				<h2>BRM - Booking Relationship Manager</h2>
			</div>
		</div>
		
		<div id ="container">
		
			<div id = "content">
			
			<input type="button" value="Add Booking"
			onclick="window.location.href='showFormForAdd';return false;"
			class="add-button"			/>
			
			
			<table>
			   <tr>
			   		<th>Van ID</th>
			   		<th>Driver ID</th>
			   		<th>Route ID</th>
			   		<th>Registered Seats</th>
			   		<th>Departure Date</th>
			   		<th>Departure Time</th>
			   		<th>Arrival Time</th>
			   		<th>Expected Price</th>
			   		<th>Action</th>
			  </tr>
			
			  
			   
			   <c:forEach var="tempBooking" items="${bookings}">
			   
			   
			 <c:url var = "updateLink" value="/booking/showFormForUpdate">
			   <c:param name="bookingId" value="${tempBooking.id}"></c:param>
			   
			   </c:url>
			   
			    <c:url var = "deleteLink" value="/booking/delete">
			   <c:param name="bookingId" value="${tempBooking.id}"></c:param>
			   
			   </c:url>
			   
				 <tr>
				 	<td> ${tempBooking.van.id} </td>
				 	<td> ${tempBooking.driver.id} </td>
				 	<td> ${tempBooking.route.id} </td>	
					<td> ${tempBooking.registeredSeats} </td>
					<td> ${tempBooking.departureDate} </td>
					<td> ${tempBooking.departureTime} </td>
					<td> ${tempBooking.arrivalTime} </td>
					<td> ${tempBooking.expectedPrice} </td>
					
					
					
					
					<td><a href="${updateLink}">Update</a> 
						| 
						<a href="${deleteLink}" 
						onClick="if (!(confirm('Are you sure you want to delete this booking?'))) return false">Delete</a> 
					</td>
					
					
			   </c:forEach>
			   
			</table>
			
			
			</div>
		
		</div>

</body>
</html>