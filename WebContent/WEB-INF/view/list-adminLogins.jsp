<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List AdminLogins</title>

	


<link type="text/css" rel="stylesheet"
 href="${pageContext.request.contextPath}/resources/css/style.css"/>
 

</head>
<body>

		<div id ="wrapper">
			<div id ="header">
				<h2>ARM - AdminLogin Relationship Manager</h2>
			</div>
		</div>
		
		<div id ="container">
		
			<div id = "content">
			
			<input type="button" value="Add AdminLogin"
			onclick="window.location.href='showFormForAdd';return false;"
			class="add-button"			/>
			
			
			<table>
			   <tr>
			   		<th>Admin ID</th>
			   		<th>Username</th>
			   		<th>Password</th>
			   		<th>Action</th>
			  </tr>
			
			  
			   
			   <c:forEach var="tempAdminLogin" items="${adminLogins}">
			   
			   
			 <c:url var = "updateLink" value="/admin/showFormForUpdate">
			   <c:param name="adminLoginId" value="${tempAdminLogin.id}"></c:param>
			   
			   </c:url>
			   
			    <c:url var = "deleteLink" value="/admin/delete">
			   <c:param name="adminLoginId" value="${tempAdminLogin.id}"></c:param>
			   
			   </c:url>
			   
				 <tr>
				 	<td> ${tempAdminLogin.id} </td>
				 	<td> ${tempAdminLogin.userName} </td>
				 	<td> ${tempAdminLogin.password} </td>
					
					
					
					
					<td><a href="${updateLink}">Update</a> 
						| 
						<a href="${deleteLink}" 
						onClick="if (!(confirm('Are you sure you want to delete this adminLogin?'))) return false">Delete</a> 
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