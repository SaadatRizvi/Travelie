package com.travelie.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.travelie.entity.Booking;
import com.travelie.entity.Customer;
import com.travelie.entity.Destination;
import com.travelie.entity.Driver;
import com.travelie.entity.LoginDetails;
import com.travelie.entity.Route;
import com.travelie.entity.Ticket;
import com.travelie.entity.TicketDetail;
import com.travelie.entity.Van;
import com.travelie.entity.VanType;
import com.travelie.entity.Webdata;
import com.travelie.service.BookingService;
import com.travelie.service.CustomerService;
import com.travelie.service.DestinationService;
import com.travelie.service.DriverService;
import com.travelie.service.RouteService;
import com.travelie.service.TicketService;
import com.travelie.service.VanService;
import com.travelie.service.VanTypeService;
import com.travelie.service.WebdataService;


@Controller
@RequestMapping(value = "/")
@SessionAttributes(value = { "destinationList", "newWebdata",
"customer","loginDetails","booking" })
public class HomepageController {
	private static Logger logger = Logger
			.getLogger(HomepageController.class);
	@Autowired
	WebdataService webdataService;
	
	@Autowired
	VanTypeService vanTypeService;
	
	@Autowired
	TicketService ticketService;
	
	@Autowired
	DestinationService destinationService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	VanService vanService;  
	
	@Autowired
	DriverService driverService;  
	
	@Autowired
	RouteService routeService;
	
	@Autowired
	BookingService bookingService;
	
	
	
	
	
	boolean loggedin = false;

	boolean newWebDataSubmit = false;
	
	@RequestMapping("/homepage")
	public String showHomepage(@ModelAttribute(value = "newWebdata") Webdata webdata,Model model){
		
		List<Webdata> webdatas = webdataService.getWebdatas();
		
			ArrayList<Integer> webdatasID = new ArrayList<Integer>();
			
			for (Webdata temp: webdatas){
				webdatasID.add(temp.getBookingWebdata().getId());
			}
			

			model.addAttribute("webdatasID", webdatasID);
		model.addAttribute("webdatas", webdatas);
		
		logger.info("newWebdata: id: "+ webdata.getId());
		logger.info("newWebdata: Type: "+ webdata.getType());
		logger.info("newWebdata: Time: "+ webdata.getDepartureTime());
		logger.info("newWebdata: Date: "+ webdata.getDepartureDate());
		logger.info("newWebdata: Destinaton: "+ webdata.getDestination());
		
		
		
		return "index";
		
		
	}
	
	
	
	@GetMapping(value="/homepage", params="bId")
	public String  setWebDataDetails(@RequestParam(value = "bId") int id, @ModelAttribute(value = "newWebdata") Webdata webdata,
			Model model, @ModelAttribute(value = "customer") Customer customer,
			@ModelAttribute(value = "loginDetails")LoginDetails loginDetails){
		
		
		logger.info("bId ="+id);
		
		
		Booking booking = bookingService.getBooking(id);
		
		logger.info("G1");
		
		webdata =  booking.getWebdata();
		 logger.info("webdata: "+webdata);
		 logger.info("Gaaaa1");
		 model.addAttribute("newWebdata", webdata);
		 
		 logger.info("G221");
		
		/* Webdata webdata2 = booking.getWebdata();
		 logger.info("bId ="+id);
		 webdata.setId(webdata2.getId());
		*/
	/*	
		webdata.setBookingWebdata(booking);
		
		webdata.setType(booking.getVan().getCategory().getType());
		webdata.setDepartureDate(booking.getDepartureDate());
		webdata.setDepartureTime(booking.getDepartureTime());
		webdata.setDestination(booking.getRoute().getDestination().getLocation());
		*/
		
		
		if (!loggedin){
			model.addAttribute("customer", customer);
			model.addAttribute("loginDetails", loginDetails);
			
			 return "login-form";
		}
		

		 logger.info("G4444");
		return "redirect:/registerCustomerBooking";
	}
	
	
	
	
	@PostMapping(value = "/homepage", params = "tAction=create")
	public String verifyWebData(@ModelAttribute(value = "newWebdata") Webdata webdata,
			Model model, @ModelAttribute(value = "customer") Customer customer,
			@ModelAttribute(value = "loginDetails")LoginDetails loginDetails){
		
		String type = webdata.getType();
		String time = webdata.getDepartureTime();
		String date = webdata.getDepartureDate();
		String destination = webdata.getDestination();
		
		logger.info(" Time:"+ time +"s");
		logger.info(" Date:"+ date +"s");
		
		if (type.equals("Type") || time.equals("") || date.equals("")) return "redirect:/homepage";
		if(destination.equals("Destination")) return "redirect:/homepage";
		
		newWebDataSubmit = true;
		if (!loggedin){
			model.addAttribute("customer", customer);
			model.addAttribute("loginDetails", loginDetails);
			
			 return "login-form";
		}
		
		
		return "redirect:/addNewBooking";
		
	}
	
	
	
	@PostMapping(value = "authenticateUser")
	public String authenticateUser(@ModelAttribute(value = "loginDetails")LoginDetails loginDetails,
			Model model){
		
		
		boolean validCustomer = false;  // username registered
		boolean loggedIn = false;   //username and password match
		String username = loginDetails.getUserName();
		String password = loginDetails.getPassword();
		
		List<Customer> customers = customerService.getCustomers();
		
		for (Customer temp: customers){
			
			if(username.equals(temp.getUsername())){
				
				validCustomer = true;
				
				if (password.equals(temp.getPassword())){
					
					model.addAttribute("customer", temp);
					loggedIn = true;
				}
			}
			
		}
		
		
		if (!validCustomer){
			
			loginDetails.setUserName("incorrect username" );
			loginDetails.setPassword(null);
			return "login-form";
		}
		
		if (!loggedIn){
			
			loginDetails.setUserName("incorrect password"); 
			loginDetails.setPassword(null);
			return "login-form";
		}
		
		
		
		
		if(newWebDataSubmit){
		return "redirect:/addNewBooking";
		}
		
		return "redirect:/registerCustomerBooking";
		
		
	}
	
	
	@GetMapping(value="generateTicket")
	public String generateTicket(@ModelAttribute(value = "newWebdata") Webdata webdata,
			@ModelAttribute(value = "booking") Booking booking,
			@ModelAttribute(value = "loginDetails")LoginDetails loginDetails,
			@ModelAttribute(value = "customer")Customer customer, Model model
			,SessionStatus sessionStatus){
		
		Ticket newTicket = new Ticket();
		
		newTicket.setBooking(booking);
		newTicket.setCustomer(customer);
		newTicket.setSeatNumber(booking.getRegisteredSeats());
		
		logger.info("newTicket: "+newTicket);
		
		TicketDetail ticketDetail = new TicketDetail();
		
		
	  ticketDetail.setId(newTicket.getId());
	  ticketDetail.setTicketId(newTicket.getId());
	  ticketDetail.setVanId(booking.getVan().getId());
	  ticketDetail.setDriverId(booking.getDriver().getId());
	  ticketDetail.setBookingId(newTicket.getBooking().getId());
	  ticketDetail.setCustomerId(customer.getId());
	  ticketDetail.setName(customer.getFirstName() +" "+ customer.getLastName());
	  ticketDetail.setSource(booking.getRoute().getSource());
	  ticketDetail.setDestination(booking.getRoute().getDestination().getLocation());
	  ticketDetail.setDepartureDate(booking.getDepartureDate());
	  ticketDetail.setDepartureTime(booking.getDepartureTime());
	  ticketDetail.setSeatNumber(newTicket.getSeatNumber());
	  
	  logger.info("ticketDetail: "+ticketDetail);
		logger.info("webdata: "+webdata);
		logger.info("booking: "+booking);
		
		model.addAttribute("ticketDetail", ticketDetail);
		 
		//bookingService.saveDestination(theDestination);
		ticketService.saveTicket(newTicket);
		
		sessionStatus.setComplete();
		
		
		return null;
		
	}
	
	
	
	
	
	@GetMapping(value="registerCustomerBooking")
	public String registerCustomerBooking(@ModelAttribute(value = "newWebdata") Webdata webdata, SessionStatus sessionStatus,
			Model model){
		
		logger.info("registerCustomerBooking(): S1");
		logger.info("registerCustomerBooking()  webdata:" + webdata);
		int id =webdata.getBookingWebdata().getId();
		logger.info("registerCustomerBooking()  id:" + id);
		
	//	List<Customer> customers = ticketService.getCustomersBooking(id);
		logger.info("registerCustomerBooking(): S2");
		Booking booking = webdata.getBookingWebdata();
		
		int i = booking.getRegisteredSeats();
		i++;
		booking.setRegisteredSeats(i);
		
		
		
		int availableSeats =booking.getVan().getTotalSeats()-booking.getRegisteredSeats();
		
		webdata.setAvailableSeats(availableSeats);
		
		 model.addAttribute("booking", booking);
		 model.addAttribute("newWebdata", webdata);
		 
		//bookingService.saveDestination(theDestination);
		bookingService.saveBooking(booking);
		webdataService.saveWebdata(webdata);
	//	sessionStatus.setComplete();
		newWebDataSubmit = false;
		return "redirect:/generateTicket";
		
	}
	
	
	
	
	@GetMapping(value="addNewBooking")
	public String addNewBooking(@ModelAttribute(value = "newWebdata") Webdata webdata, SessionStatus sessionStatus,
			Model model){
		
		Booking newBooking = new Booking();
		
		String type = webdata.getType();
		logger.info("type: "+ type);
		String departureDate = webdata.getDepartureDate();
		logger.info("departureDate: "+ departureDate);
		String departureTime = webdata.getDepartureTime();
		logger.info("departureTime: "+ departureTime);
		String destination = webdata.getDestination();
		logger.info("destination : "+ destination);
		//logger.info("addNewBooking method(): 1 ");
		List<Van> availableVans = vanService.getAvailableVans();
	//	logger.info("addNewBooking method(): 2 ");
		Random rn = new Random();
		int iVan = rn.nextInt( availableVans.size());
		Van van=availableVans.get(iVan);
		
		//logger.info("addNewBooking method(): 3 ");
		newBooking.setVan(van);
	//	logger.info("addNewBooking method(): 4 ");
		List<Driver> availableDrivers = driverService.getAvailableDrivers();
	//	logger.info("addNewBooking method(): 5 ");
		int iDriver = rn.nextInt( availableDrivers.size());
		Driver driver=availableDrivers.get(iDriver);
	//	logger.info("addNewBooking method(): 6 ");
		newBooking.setDriver(driver);
		
		List<Route> routes = routeService.getRoutes();
		
		int iRoute = 0;
		
		for (Route tempRoute : routes){
			logger.info("FOR LOOP: "+tempRoute.getId() + " "+tempRoute.getDestination());
			if (tempRoute.getDestination().getLocation().equals(destination)){
			
				iRoute = tempRoute.getId();
				logger.info("INSIDE IF route ki ID: "+iRoute);
			}
		}
		logger.info("routeID: "+iRoute);
		newBooking.setRoute(routeService.getRoute(iRoute));
		
		newBooking.setRegisteredSeats(1);
		logger.info("departureDate: "+ departureDate);
		newBooking.setDepartureDate(departureDate);
		logger.info("departureTime: "+ departureTime);
		newBooking.setDepartureTime(departureTime);
		newBooking.setArrivalTime("unknown");
		newBooking.setExpectedPrice(5000);
		
		int availableSeats =newBooking.getVan().getTotalSeats()-newBooking.getRegisteredSeats();
		webdata.setBookingWebdata(newBooking);
		webdata.setAvailableSeats(availableSeats);
		model.addAttribute("booking", newBooking);
		
		 model.addAttribute("newWebdata", webdata);
		//bookingService.saveDestination(theDestination);
		bookingService.saveBooking(newBooking);
		webdataService.saveWebdata(webdata);
	//	sessionStatus.setComplete();
		newWebDataSubmit = false;
		return "redirect:/generateTicket";
		
		}
		
	
	@ModelAttribute(value = "destinationList")
	public List<String> listDestinations() {
	//	logger.info("listDestinations() method: Getting list of destinations");
		List<Destination> listDestination= destinationService.getDestinations();
		
		List<String> listLocation = new ArrayList<String>();
		for(Destination a : listDestination){
			listLocation.add(a.getLocation());	
		}
		
		return listLocation;
		
	}
	
	@ModelAttribute(value = "vanTypeList")
	public List<String> listVanType() {
	
		List<VanType> listVanType= vanTypeService.getVanTypes();
		
		List<String> listType = new ArrayList<String>();
		for(VanType a : listVanType){
			listType.add(a.getType());	
		}
		logger.info("listDestinations() method: Getting list of destinations");
		return listType;
		
	}
	
	
	
	@ModelAttribute(value = "newWebdata")
	public Webdata getNewWebdata() {
		Webdata webdata = new Webdata();
		webdata.setDestination("Destination");
		webdata.setType("Type");
		logger.info("getNewWebdata() method: Returning a new instance of Webdata");
		return webdata;
	}
	
	
	// used for getting booking information to select booking from the homepage
	@ModelAttribute(value = "booking")
	public Booking getNewBooking() {
		Booking booking = new Booking();
		
		logger.info("getNewBooking() method: Returning a new instance of Booking");
		
		return booking;
	}
	
	
	
	@ModelAttribute(value = "customer")
	public Customer getCustomer() {
		Customer customer = new Customer();
		
		logger.info("getCustomer() method: Returning a new instance of Customer");
		return customer;
	}
	
	
	@ModelAttribute(value = "loginDetails")
	public LoginDetails getloginDetails() {
		LoginDetails loginDetails = new LoginDetails();
		
		logger.info("getLoginDetails() method: Returning a new instance of LoginDetails");
		return loginDetails;
	}
	
	
	
	@InitBinder(value = "newWebdata")
	public void initBinder_newWebData(WebDataBinder webDataBinder){
		
		// Change departureDate in webdata to 'Date' type instead of String for improvement
		
		/*webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(
			new SimpleDateFormat("MM-dd-yyyy"), false));
		*/
		
		webDataBinder.setDisallowedFields("id");
		
	}
	
	
	
}
