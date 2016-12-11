<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>

	


<link type="text/css" rel="stylesheet"
 href="${pageContext.request.contextPath}/resources/css/style.css"/>
 

</head>
<body>

		<div id ="wrapper">
			<div id ="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		
		<div id ="container">
		
			<div id = "content">
			
			<input type="button" value="Add Customer"
			onclick="window.location.href='showFormForAdd';return false;"
			class="add-button"			/>
			
			
			<table>
			   <tr>
			   		<th>Customer ID</th>
			   		<th>Registration Number</th>
			   		<th>First Name</th>
			   		<th>Last Name</th>
			   		<th>Username</th>
			   		<th>Password</th>
			   		<th>Email</th>
			   		<th>Phone Number</th>
			   		<th>Flagged</th>
			   		<th>Action</th>
			  </tr>
			
			  
			   
			   <c:forEach var="tempCustomer" items="${customers}">
			   
			   
			 <c:url var = "updateLink" value="/customer/showFormForUpdate">
			   <c:param name="customerId" value="${tempCustomer.id}"></c:param>
			   
			   </c:url>
			   
			    <c:url var = "deleteLink" value="/customer/delete">
			   <c:param name="customerId" value="${tempCustomer.id}"></c:param>
			   
			   </c:url>
			   
				 <tr>	
					<td> ${tempCustomer.id} </td>
				 	<td> ${tempCustomer.regNumber} </td>
				 	<td> ${tempCustomer.firstName} </td>
				 	<td> ${tempCustomer.lastName} </td>
				 	<td> ${tempCustomer.username} </td>	
				 	<td> ${tempCustomer.password} </td>		
					<td> ${tempCustomer.email} </td>
					<td> ${tempCustomer.phoneNumber} </td>
					<td> ${tempCustomer.flagged} </td>
					
					
					
					
					<td><a href="${updateLink}">Update</a> 
						| 
						<a href="${deleteLink}" 
						onClick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a> 
					</td>
					
					
			   </c:forEach>
			   
			</table>
			
			
			</div>
			
			<p>
			<a href="${pageContext.request.contextPath}/epanel/control">Back to EPanel</a>
			</p>
		
		</div>

</body>
</html>