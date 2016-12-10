<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Destinations</title>

	


<link type="text/css" rel="stylesheet"
 href="${pageContext.request.contextPath}/resources/css/style.css"/>
 

</head>
<body>

		<div id ="wrapper">
			<div id ="header">
				<h2>DRM - Destination Relationship Manager</h2>
			</div>
		</div>
		
		<div id ="container">
		
			<div id = "content">
			
			<input type="button" value="Add Destination"
			onclick="window.location.href='showFormForAdd';return false;"
			class="add-button"			/>
			
			
			<table>
			   <tr>
			   		<th>ID</th>
			   		<th>Destination</th>
			   		<th>Action</th>
			  </tr>
			
			  
			   
			   <c:forEach var="tempDestination" items="${destinations}">
			   
			   
			 <c:url var = "updateLink" value="/destination/showFormForUpdate">
			   <c:param name="destinationId" value="${tempDestination.id}"></c:param>
			   
			   </c:url>
			   
			    <c:url var = "deleteLink" value="/destination/delete">
			   <c:param name="destinationId" value="${tempDestination.id}"></c:param>
			   
			   </c:url>
			   
				 <tr>
				 	<td> ${tempDestination.id} </td>
				 	<td> ${tempDestination.location} </td>
					
					
					
					
					<td><a href="${updateLink}">Update</a> 
						| 
						<a href="${deleteLink}" 
						onClick="if (!(confirm('Are you sure you want to delete this destination?'))) return false">Delete</a> 
					</td>
					
					
			   </c:forEach>
			   
			</table>
			
			
			</div>
		
		</div>

</body>
</html>