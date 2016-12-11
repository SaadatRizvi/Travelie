package com.travelie.entity;

public class TicketDetail {

	int id;
	int ticketId;
	int vanId;
	int driverId;
	int bookingId;
	int customerId;
	String name;
	String source;
	String destination;
	String departureDate;
	String departureTime;
	int seatNumber;
	
	public TicketDetail(){
		
	}

	@Override
	public String toString() {
		return "TicketDetail [id=" + id + ", ticketId=" + ticketId + ", vanId=" + vanId + ", driverId=" + driverId
				+ ", bookingId=" + bookingId + ", customerId=" + customerId + ", name=" + name + ", source=" + source
				+ ", destination=" + destination + ", departureDate=" + departureDate + ", departureTime="
				+ departureTime + ", seatNumber=" + seatNumber + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getVanId() {
		return vanId;
	}

	public void setVanId(int vanId) {
		this.vanId = vanId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	
	
	
	
	
	
	
}
