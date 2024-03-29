 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<title>Save Customer</title>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
<link type ="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	
	
	<link type ="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-form-style.css">
      
	
	
<body>
	<div id= "wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		
		<form:hidden path="id"/>
			<table>
				<tbody>
				<tr>
					<td><label>Registration #:</label></td>
					<td><form:input path="regNumber" /> </td>
					
				</tr>
				<tr>
					<td><label>First name:</label></td>
					<td><form:input path="firstName" /> </td>
					
				</tr>
				<tr>
					<td><label>Last name:</label></td>
					<td><form:input path="lastName" /> </td>
					
				</tr>
				<tr>
					<td><label>Username:</label></td>
					<td><form:input path="username" /> </td>
					
				</tr>
				<tr>
					<td><label>Password:</label></td>
					<td><form:input path="password" /> </td>
					
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td><form:input path="email" /> </td>
					
				</tr>
				<tr>
					<td><label>Phone #:</label></td>
					<td><form:input path="phoneNumber" /> </td>
					
				</tr>
				<tr>
					<td><label>Flagged(1/0 for y/n):</label></td>
					<td><form:input path="flagged" /> </td>
					
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
		<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
	
	</div>

</body>


</html>