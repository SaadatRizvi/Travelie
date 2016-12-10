package com.travelie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="bookings_id")
	private Van booking;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Driver customer;
	
	@Column(name="seat_no")
	private int seatNumber;
	
	
	
	public Ticket(){
		        
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Van getBooking() {
		return booking;
	}



	public void setBooking(Van booking) {
		this.booking = booking;
	}



	public Driver getCustomer() {
		return customer;
	}



	public void setCustomer(Driver customer) {
		this.customer = customer;
	}



	public int getSeatNumber() {
		return seatNumber;
	}



	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}


	
	
}
