 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<title>Save Ticket</title>

<link type ="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	
	
	<link type ="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-form-style.css">
      
	
	
<body>
	<div id= "wrapper">
		<div id="header">
			<h2>TRM - Ticket Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Ticket</h3>
		
		<form:form action="saveTicket" modelAttribute="ticket" method="POST">
		
		<form:hidden path="id"/>
			<table>
				<tbody>
				<tr>
					<td><label>Booking ID:</label></td>
					<td><form:input path="booking.id" /> </td>
					
				</tr>
				<tr>
					<td><label>Customer ID:</label></td>
					<td><form:input path="customer.id" /> </td>
					
				</tr>
				<tr>
					<td><label>Seat Number:</label></td>
					<td><form:input path="seatNumber" /> </td>
					
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
		<a href="${pageContext.request.contextPath}/ticket/list">Back to List</a>
		</p>
	
	</div>

</body>


</html>