<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Vans</title>

	


<link type="text/css" rel="stylesheet"
 href="${pageContext.request.contextPath}/resources/css/style.css"/>
 

</head>
<body>

		<div id ="wrapper">
			<div id ="header">
				<h2>CRM - Van Relationship Manager</h2>
			</div>
		</div>
		
		<div id ="container">
		
			<div id = "content">
			
			<input type="button" value="Add Van"
			onclick="window.location.href='showFormForAdd';return false;"
			class="add-button"			/>
			
			
			<table>
			   <tr>
			   		<th>ID</th>
			   		<th>Vehicle_reg#</th>
			   		<th>Type</th>
			   		<th>Total Seats</th>
			   		<th>Category</th>
			   		<th>Flagged</th>
			   		<th>Action</th>
			  </tr>
			
			  
			   
			   <c:forEach var="tempVan" items="${vans}">
			   
			   
			 <c:url var = "updateLink" value="/van/showFormForUpdate">
			   <c:param name="vanId" value="${tempVan.id}"></c:param>
			   
			   </c:url>
			   
			    <c:url var = "deleteLink" value="/van/delete">
			   <c:param name="vanId" value="${tempVan.id}"></c:param>
			   
			   </c:url>
			   
				 <tr>
				 	<td> ${tempVan.id} </td>
				 	<td> ${tempVan.vehicleRegistration} </td>
				 	<td> ${tempVan.vehicleType} </td>
				 	<td> ${tempVan.totalSeats} </td>	
					<td> ${tempVan.category} </td>
					<td> ${tempVan.flagged} </td>
					
					
					
					
					<td><a href="${updateLink}">Update</a> 
						| 
						<a href="${deleteLink}" 
						onClick="if (!(confirm('Are you sure you want to delete this van?'))) return false">Delete</a> 
					</td>
					
					
			   </c:forEach>
			   
			</table>
			
			
			</div>
		
		</div>

</body>
</html>