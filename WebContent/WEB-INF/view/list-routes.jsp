<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Routes</title>

	


<link type="text/css" rel="stylesheet"
 href="${pageContext.request.contextPath}/resources/css/style.css"/>
 

</head>
<body>

		<div id ="wrapper">
			<div id ="header">
				<h2>RRM - Route Relationship Manager</h2>
			</div>
		</div>
		
		<div id ="container">
		
			<div id = "content">
			
			<input type="button" value="Add Route"
			onclick="window.location.href='showFormForAdd';return false;"
			class="add-button"			/>
			
			
			<table>
			   <tr>
			   		<th>Route ID</th>
			   		<th>Source</th>
			   		<th>Destination</th>
			   		<th>Expected Travel Time</th>
			   		<th>Economy Fare</th>
			   		<th>AC Fare</th>
			   		<th>State</th>
			   		<th>Action</th>
			  </tr>
			
			  
			   
			   <c:forEach var="tempRoute" items="${routes}">
			   
			   
			 <c:url var = "updateLink" value="/route/showFormForUpdate">
			   <c:param name="routeId" value="${tempRoute.id}"></c:param>
			   
			   </c:url>
			   
			    <c:url var = "deleteLink" value="/route/delete">
			   <c:param name="routeId" value="${tempRoute.id}"></c:param>
			   
			   </c:url>
			   
				 <tr>
				 	<td> ${tempRoute.id} </td>
				 	<td> ${tempRoute.source} </td>
				 	<td> ${tempRoute.destination_location} </td>	
					<td> ${tempRoute.expectedTravelTime} </td>
					<td> ${tempRoute.economyFare} </td>
					<td> ${tempRoute.acFare} </td>
					<td> ${tempRoute.state} </td>
					
					
					
					
					<td><a href="${updateLink}">Update</a> 
						| 
						<a href="${deleteLink}" 
						onClick="if (!(confirm('Are you sure you want to delete this route?'))) return false">Delete</a> 
					</td>
					
					
			   </c:forEach>
			   
			</table>
			
			
			</div>
		
		</div>

</body>
</html>