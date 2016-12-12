 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Travelie Login Form</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style_login.css">

  
</head>

<body>
  
<!-- Mixins-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>Travelie Login Form</h1><span> 
</div>
<div class="rerun"><a >Please enter your details</a></div>
<div class="container">
  <div class="card"></div>
  <div class="card">
    <h1 class="title">Login</h1>
    <form:form action="authenticateUser" modelAttribute="loginDetails" method="POST">
    
      <div class="input-container">
     <!--    <input type="text" id="Username" required="required"/> --> 
        <form:input path="userName" id="Username" required="required" /> 
        <label for="Username">Username</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
      <!--    <input type="password" id="Password" required="required"/> --> 
         <form:input type="password" path="password" id="Username" required="required" /> 
        <label for="Password">Password</label>
        <div class="bar"></div>
      </div>
      <div class="button-container">
        <button><span>Go</span></button>
      </div>
      <!--<div class="footer"><a href="#">Forgot your password?</a></div>-->
    
    </form:form>
  </div>
  <div class="card alt">
    <div class="toggle"></div>
    <h1 class="title">Register
      <div class="close"></div>
    </h1>
    <form:form action="registerNewCustomer" modelAttribute="customer" method="POST">
    
      <div class="input-container">  
      
        <form:input path="firstName" id="First Name" required="required"/> 
        <label for="First Name">First Name</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
       
        <form:input path="lastName"  id="Last Name" required="required"/>
        <label for="Last Name">Last Name</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
       
        <form:input path="username" id="Username" required="required"/>
        <label for="Username">Username</label>
        <div class="bar"></div>
      </div>
        <div class="input-container">
        
        <form:input  path="password" id="Password" required="required"/>
        <label for="Password">Password</label>
        <div class="bar"></div>
      </div>
      
      <div class="input-container">
        
        <form:input path="regNumber" id="GIKI ID" required="required"/> 
        <label for="GIKI ID">GIKI ID</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
       
        <form:input path="email" id="Email" required="required"/>
        <label for="Email">Email</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        
        <form:input path="phoneNumber" id="Phone number" required="required"/>
        <label for="Phone number">Phone number</label>
        <div class="bar"></div>
      </div>
    
      
      <div class="button-container">
       <button><span>Go</span></button>
   <!--      <input type="submit" value="Save"  /> --> 
      </div>
    
    </form:form>
  </div>
</div>
<!-- Portfolio--><a id="portfolio" href="http://andytran.me/" title="View my portfolio!"><i class="fa fa-link"></i></a>
<!-- CodePen--><a id="codepen" href="http://codepen.io/andytran/" title="Follow me!"><i class="fa fa-codepen"></i></a>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="${pageContext.request.contextPath}/resources/js/index_login.js"></script>

</body>
</html>
