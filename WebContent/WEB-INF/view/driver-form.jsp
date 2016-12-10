 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<title>Save Driver</title>

<link type ="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	
	
	<link type ="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-form-style.css">
      
	
	
<body>
	<div id= "wrapper">
		<div id="header">
			<h2>CRM - Driver Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Driver</h3>
		
		<form:form action="saveDriver" modelAttribute="driver" method="POST">
		
		<form:hidden path="id"/>
			<table>
				<tbody>
				<tr>
					<td><label>Picture:</label></td>
					<td><form:input path="picture" /> </td>
					
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
					<td><label>CNIC:</label></td>
					<td><form:input path="cnic" /> </td>
					
				</tr>
				<tr>
					<td><label>License#:</label></td>
					<td><form:input path="licenseNumber" /> </td>
					
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
		<a href="${pageContext.request.contextPath}/driver/list">Back to List</a>
		</p>
	
	</div>

</body>


</html>