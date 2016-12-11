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
@Table(name="webdata")
public class Webdata {

	public Booking getBookingWebdata() {
		return bookingWebdata;
	}


	public void setBookingWebdata(Booking bookingWebdata) {
		this.bookingWebdata = bookingWebdata;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="departure_time")
	private String departureTime;
	
	@Column(name="departure_date")
	private String departureDate;
	
	@Column(name="destination")
	private String destination;
	
	@ManyToOne
	@JoinColumn(name="booking_id")
	private Booking bookingWebdata;
	



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}


	public String getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public int getAvailableSeats() {
		return availableSeats;
	}


	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}


	@Column(name="available_seats")
	private int availableSeats;
	
		
	public Webdata(){
		
	}


	@Override
	public String toString() {
		return "Webdata [id=" + id + ", type=" + type + ", departureTime=" + departureTime + ", departureDate="
				+ departureDate + ", destination=" + destination + ", bookingWebdata=" + bookingWebdata
				+ ", availableSeats=" + availableSeats + "]";
	}







	
	
	
	
}
