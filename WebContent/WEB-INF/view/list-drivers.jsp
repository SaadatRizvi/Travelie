<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Drivers</title>

	
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />

<link type="text/css" rel="stylesheet"
 href="${pageContext.request.contextPath}/resources/css/style.css"/>
 

</head>
<body>

		<div id ="wrapper">
			<div id ="header">
				<h2>DRM - Driver Relationship Manager</h2>
			</div>
		</div>
		
		<div id ="container">
		
			<div id = "content">
			
			<input type="button" value="Add Driver"
			onclick="window.location.href='showFormForAdd';return false;"
			class="add-button"			/>
			
			
			<table>
			   <tr>
			   		<th>ID</th>
			   		<th>Picture</th>
			   		<th>First Name</th>
			   		<th>Last Name</th>
			   		<th>CNIC#</th>
			   		<th>License#</th>
			   		<th>Phone Number</th>
			   		<th>Flagged</th>
			   		<th>Action</th>
			  </tr>
			
			  
			   
			   <c:forEach var="tempDriver" items="${drivers}">
			   
			   
			 <c:url var = "updateLink" value="/driver/showFormForUpdate">
			   <c:param name="driverId" value="${tempDriver.id}"></c:param>
			   
			   </c:url>
			   
			    <c:url var = "deleteLink" value="/driver/delete">
			   <c:param name="driverId" value="${tempDriver.id}"></c:param>
			   
			   </c:url>
			   
				 <tr>
				 	<td> ${tempDriver.id} </td>
				 	<td> ${tempDriver.picture} </td>
				 	<td> ${tempDriver.firstName} </td>
				 	<td> ${tempDriver.lastName} </td>	
					<td> ${tempDriver.cnic} </td>
					<td> ${tempDriver.licenseNumber} </td>
					<td> ${tempDriver.phoneNumber} </td>
					<td> ${tempDriver.flagged} </td>
					
					
					
					
					<td><a href="${updateLink}">Update</a> 
						| 
						<a href="${deleteLink}" 
						onClick="if (!(confirm('Are you sure you want to delete this driver?'))) return false">Delete</a> 
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