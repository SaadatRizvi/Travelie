 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<title>Save Destination</title>

<link type ="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	
	
	<link type ="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-form-style.css">
      
	
	
<body>
	<div id= "wrapper">
		<div id="header">
			<h2>DRM - Destination Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Destination</h3>
		
		<form:form action="saveDestination" modelAttribute="destination" method="POST">
		
		<form:hidden path="id"/>
			<table>
				<tbody>
				<tr>
					<td><label>Destination:</label></td>
					<td><form:input path="location" /> </td>
					
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
		<a href="${pageContext.request.contextPath}/destination/list">Back to List</a>
		</p>
	
	</div>

</body>


</html>