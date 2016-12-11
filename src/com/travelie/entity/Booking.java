package com.travelie.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="van_id")
	private Van van;
	
	@ManyToOne
	@JoinColumn(name="driver_id")
	private Driver driver;
	
	@ManyToOne
	@JoinColumn(name="route_id")
	private Route route;
	
	@Column(name="registered_seats")
	private int registeredSeats;
	
	@Column(name="departure_time")
	private String departureTime;
	@Column(name="arival_time")
	private String arrivalTime;
	@Column(name="departure_date")
	private String departureDate;
	
	
	
	@Column(name="expected_price")
	private int expectedPrice;
	
	//Ticket.java   reference
	 @OneToMany(mappedBy="booking",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	 private Set<Ticket> tickets;
	 
	 
	//Webdata.java   reference
		 @OneToMany(mappedBy="bookingWebdata",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
		    private Set<Webdata> webdata;
	
		 
		 
		 
	public Set<Webdata> getWebdata() {
			return webdata;
		}



		public void setWebdata(Set<Webdata> webdata) {
			this.webdata = webdata;
		}



	public Set<Ticket> getTickets() {
		return tickets;
	}



	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}



	public Booking(){
		        
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Van getVan() {
		return van;
	}



	public void setVan(Van van) {
		this.van = van;
	}



	public Driver getDriver() {
		return driver;
	}



	public void setDriver(Driver driver) {
		this.driver = driver;
	}



	public Route getRoute() {
		return route;
	}



	public void setRoute(Route route) {
		this.route = route;
	}



	public int getRegisteredSeats() {
		return registeredSeats;
	}



	public void setRegisteredSeats(int registeredSeats) {
		this.registeredSeats = registeredSeats;
	}



	public String getDepartureTime() {
		return departureTime;
	}



	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}



	public String getArrivalTime() {
		return arrivalTime;
	}



	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}



	public String getDepartureDate() {
		return departureDate;
	}



	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}



	public int getExpectedPrice() {
		return expectedPrice;
	}



	public void setExpectedPrice(int expectedPrice) {
		this.expectedPrice = expectedPrice;
	}

	
	
}
