 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<title>Save Van</title>
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
			<h2>VRM - Van Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Van</h3>
		
		<form:form action="saveVan" modelAttribute="van" method="POST">
		
		<form:hidden path="id"/>
			<table>
				<tbody>
				<tr>
					<td><label>Vehicle Reg#:</label></td>
					<td><form:input path="vehicleRegistration" />
					<form:errors path="vehicleRegistration"/> </td>
					
				</tr>
				<tr>
					<td><label>Type:</label></td>
					<td><form:input path="vehicleType" /> </td>
					
				</tr>
				<tr>
					<td><label>Total Seats:</label></td>
					<td><form:input path="totalSeats" /> </td>
					
				</tr>
				<tr>
					<td><label>Category:</label></td>
					<td><form:input path="vanTypeCategory" /> </td>
					
				</tr>
				
				<tr>
					<td><label>Flagged (1/0 for y/n):</label></td>
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
		<a href="${pageContext.request.contextPath}/van/list">Back to List</a>
		</p>
	
	</div>

</body>


</html>