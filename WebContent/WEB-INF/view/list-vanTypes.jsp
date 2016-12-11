<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List VanTypes</title>

	


<link type="text/css" rel="stylesheet"
 href="${pageContext.request.contextPath}/resources/css/style.css"/>
 

</head>
<body>

		<div id ="wrapper">
			<div id ="header">
				<h2>VRM - VanType Relationship Manager</h2>
			</div>
		</div>
		
		<div id ="container">
		
			<div id = "content">
			
			<input type="button" value="Add VanType"
			onclick="window.location.href='showFormForAdd';return false;"
			class="add-button"			/>
			
			
			<table>
			   <tr>
			   		<th>Van ID</th>
			   		<th>Type</th>
			   		<th>Action</th>
			  </tr>
			
			  
			   
			   <c:forEach var="tempVanType" items="${vanTypes}">
			   
			   
			 <c:url var = "updateLink" value="/vanType/showFormForUpdate">
			   <c:param name="vanTypeId" value="${tempVanType.id}"></c:param>
			   
			   </c:url>
			   
			    <c:url var = "deleteLink" value="/vanType/delete">
			   <c:param name="vanTypeId" value="${tempVanType.id}"></c:param>
			   
			   </c:url>
			   
				 <tr>
				 	<td> ${tempVanType.id} </td>
				 	<td> ${tempVanType.type} </td>
					
					
					
					
					<td><a href="${updateLink}">Update</a> 
						| 
						<a href="${deleteLink}" 
						onClick="if (!(confirm('Are you sure you want to delete this vanType?'))) return false">Delete</a> 
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