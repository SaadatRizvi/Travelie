 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<title>Save VanType</title>
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
			<h2>VRM - VanType Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save VanType</h3>
		
		<form:form action="saveVanType" modelAttribute="vanType" method="POST">
		
		<form:hidden path="id"/>
			<table>
				<tbody>
				<tr>
					<td><label>Type:</label></td>
					<td><form:input path="type" /> </td>
					
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
		<a href="${pageContext.request.contextPath}/vanType/list">Back to List</a>
		</p>
	
	</div>

</body>


</html>