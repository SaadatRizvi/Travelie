<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Tickets</title>

	


<link type="text/css" rel="stylesheet"
 href="${pageContext.request.contextPath}/resources/css/style.css"/>
 

</head>
<body>

		<div id ="wrapper">
			<div id ="header">
				<h2>TRM - Ticket Relationship Manager</h2>
			</div>
		</div>
		
		<div id ="container">
		
			<div id = "content">
			
			<input type="button" value="Add Ticket"
			onclick="window.location.href='showFormForAdd';return false;"
			class="add-button"			/>
			
			
			<table>
			   <tr>
			   		<th>Ticket ID</th>
			   		<th>Booking ID</th>
			   		<th>Customer ID</th>
			   		<th>Seat Number</th>
			   		<th>Action</th>
			  </tr>
			
			  
			   
			   <c:forEach var="tempTicket" items="${tickets}">
			   
			   
			 <c:url var = "updateLink" value="/ticket/showFormForUpdate">
			   <c:param name="ticketId" value="${tempTicket.id}"></c:param>
			   
			   </c:url>
			   
			    <c:url var = "deleteLink" value="/ticket/delete">
			   <c:param name="ticketId" value="${tempTicket.id}"></c:param>
			   
			   </c:url>
			   
				 <tr>
				 	<td> ${tempTicket.id} </td>
				 	<td> ${tempTicket.booking} </td>
				 	<td> ${tempTicket.customer} </td>	
					<td> ${tempTicket.seatNumber} </td>
					
					
					
					
					<td><a href="${updateLink}">Update</a> 
						| 
						<a href="${deleteLink}" 
						onClick="if (!(confirm('Are you sure you want to delete this ticket?'))) return false">Delete</a> 
					</td>
					
					
			   </c:forEach>
			   
			</table>
			
			
			</div>
		
		</div>

</body>
</html>