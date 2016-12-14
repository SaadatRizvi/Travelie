<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

  <title>Travelie Ticket</title>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
    <style>
.cardWrap {
  width: 27em;
  margin: 3em auto;
  color: #fff;
  font-family: sans-serif;
}

.card {
  background: linear-gradient(to bottom, #007ea3 0%, #007ea3 17%, #ecedef 17%, #ecedef 100%);
  height: 11em;
  float: left;
  position: relative;
  padding: 1em;
}

.cardLeft {
  border-top-left-radius: 8px;
  border-bottom-left-radius: 8px;
  width: 16em;
  height: 20em;   
}

.cardRight {
  width: 6.5em;
  border-left: .18em dashed #fff;
  border-top-right-radius: 8px;
  border-bottom-right-radius: 8px;
  height: 20em;         
}
.cardRight:before, .cardRight:after {
  content: "";
  position: absolute;
  display: block;
  width: .9em;
  height: .9em;
  background: #fff;
  border-radius: 50%;
  left: -.5em;
}
.cardRight:before {
  top: -.4em;
}
.cardRight:after {
  bottom: -.4em;
}

h1 {
  font-size: 1.1em;
  margin-top: 0;
}
h1 span {
  font-weight: normal;
}

.title, .name, .seat, .time {
  text-transform: uppercase;
  font-weight: normal;
}
.title h2, .name h2, .seat h2, .time h2 {
  font-size: .9em;
  color: #525252;
  margin: 0;
}
.title span, .name span, .seat span, .time span {
  font-size: .7em;
  color: #a2aeae;
  
}

.title {
  margin: 2em 0 0 0;
}

.name, .seat {
  margin: .7em 0 0 0;
}

.time {
  margin: .7em 0 0 1em;
}

.seat, .time {
  float: left;
}

.eye {
  position: relative;
  width: 2em;
  height: 1.5em;
  background: #fff;
  margin: 0 auto;
  border-radius: 1em/0.6em;
  z-index: 1;
}
.eye:before, .eye:after {
  content: "";
  display: block;
  position: absolute;
  border-radius: 50%;
}
.eye:before {
  width: 1em;
  height: 1em;
  background: #007ea3;
  z-index: 2;
  left: 8px;
  top: 4px;
}
.eye:after {
  width: .5em;
  height: .5em;
  background: #fff;
  z-index: 3;
  left: 12px;
  top: 8px;
}

.number {
  text-align: center;
  text-transform: uppercase;
}
.number h3 {
  color: #007ea3;
  margin: .9em 0 0 0;
  font-size: 2.5em;
}
.number span {
  display: block;
  color: #a2aeae;
}

.barcode {
  height: 2em;
  width: 0;
  margin: 1.2em 0 0 .8em;
  box-shadow: 1px 0 0 1px #343434, 5px 0 0 1px #343434, 10px 0 0 1px #343434, 11px 0 0 1px #343434, 15px 0 0 1px #343434, 18px 0 0 1px #343434, 22px 0 0 1px #343434, 23px 0 0 1px #343434, 26px 0 0 1px #343434, 30px 0 0 1px #343434, 35px 0 0 1px #343434, 37px 0 0 1px #343434, 41px 0 0 1px #343434, 44px 0 0 1px #343434, 47px 0 0 1px #343434, 51px 0 0 1px #343434, 56px 0 0 1px #343434, 59px 0 0 1px #343434, 64px 0 0 1px #343434, 68px 0 0 1px #343434, 72px 0 0 1px #343434, 74px 0 0 1px #343434, 77px 0 0 1px #343434, 81px 0 0 1px #343434;
}


.button
{

  letter-spacing: 1px;
  text-align: center;
  color: #007ea3;
  font-size: 24px;
  font-family: "Nunito", sans-serif;
  font-weight: 300;
  
  margin: auto;
  display:block;     /*to make all blocks of same size and centre them*/ /*within div*/
  padding: 20px 10px;
  width: 220px;
  height:30px;
  
  background: #007ea3;
  border: 1px solid #007ea3;
  color: #FFF;
  overflow: hidden;
  
  transition: all 0.5s;
}

.button:hover, .button:active 
{
  text-decoration: none;
  color: #007ea3;
  border-color: #007ea3;
  background: #e9e9e9;
}


</style>

    <script src="${pageContext.request.contextPath}/resources/js/prefixfree_ticket.min.js"></script>

</head>

<body>


 <div class="cardWrap">
  <div class="card cardLeft">
    <h1>Travelie <span>Ticket</span></h1>
    <div class="title">
    
      <h2><c:out value='${tempTicket.name}' /></h2>
      <span>Name</span>
    </div>
    <div class="name">
      <h2>${tempTicket.source}</h2>
      <span>Source</span>
    </div>
    <div class="name">
      <h2>${tempTicket.destination}</h2>
      <span>Destination</span>
    </div>
    <div class="time">
      <h2>${tempTicket.bookingId}</h2>
      <span>Booking ID</span>
    </div>
    <div class="time">
      <h2>${tempTicket.id}</h2>
      <span>Ticket ID</span>
    </div>
    <div class="time">
      <h2>${tempTicket.driverId}</h2>
      <span>Driver ID</span>
    </div>
    <div class="time">
      <h2>${tempTicket.customerId}</h2>
      <span>Customer ID</span>
    </div>
    <div class="time">
      <h2>${tempTicket.vanId}</h2>
      <span>Van ID</span>
    </div>
    <div class="time">
      <h2>${tempTicket.seatNumber}</h2>
      <span>Seat</span>
    </div>
    <div class="time">
      <h2>${tempTicket.departureDate}</h2>
      <span>Dep. Date</span>
    </div>
    <div class="time">
      <h2>${tempTicket.departureTime}</h2>
      <span>Dep. Time</span>
    </div>
    
    
  </div>
  <div class="card cardRight">
    <div class="eye"></div>
    <div class="number">
      <h3>${tempTicket.seatNumber}</h3>
      <span>seat</span>
    </div>
    <div class="seat">
      <h2>${tempTicket.customerId}</h2>
      <span>Customer ID</span>
    </div>
    <div class="seat">
      <h2>${tempTicket.id}</h2>
      <span>Ticket ID</span>
    </div>
    <div class="seat">
      <h2>${tempTicket.bookingId}</h2>
      <span>Booking ID</span>
    </div>
    <br></br>
    <br></br>
    <br></br>  
    <br style="line-height:35px;" />
    <div class="barcode"></div>
  </div>

</div>
<br style="line-height:400px;" /> 
 <a href="/Travelie-main/homepage" class="button">Go back </a>  
  
 
</body>
</html>