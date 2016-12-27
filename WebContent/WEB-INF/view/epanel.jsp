<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Travelie EPanel</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style_epanel.css">
  <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
  
</head>

<body>
  <h1>Travelie EPanel</h1>

<div>
  <a href="${pageContext.request.contextPath}/customer" class="button">Customer</a>  
  </div>

<div>
  <a href="${pageContext.request.contextPath}/driver" class="button">Driver</a>  
  </div>

<div>
  <a href="${pageContext.request.contextPath}/vanType" class="button">Van Type</a>  
  </div>

<div>
  <a href="${pageContext.request.contextPath}/van" class="button">Van</a>  
  </div>

<div>
  <a href="${pageContext.request.contextPath}/destination" class="button">Destination</a>  
  </div>

<div>
  <a href="${pageContext.request.contextPath}/route" class="button">Route</a>  
  </div>

<div>
  <a href="${pageContext.request.contextPath}/booking" class="button">Booking</a>  
  </div>

<div>
  <a href="${pageContext.request.contextPath}/ticket" class="button">Ticket</a>  
  </div>

<div>
  <a href="${pageContext.request.contextPath}/admin" class="button">Admin</a>  
  </div>

</body>
</html>