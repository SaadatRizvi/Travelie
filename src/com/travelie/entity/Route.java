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
import javax.persistence.Transient;

@Entity
@Table(name="route")
public class Route {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="source")
	private String source;
	
	
	@ManyToOne
	@JoinColumn(name="destination_id")
	private Destination destination;
	
	@Transient
	private String destination_location;
	
	@Column(name="exp_t_time")
	private String expectedTravelTime;
	
	
	@Column(name="eco_fare")
	private int economyFare;

	
	@Column(name="ac_fare")
	private int acFare;	
	
	@Column(name="state")
	private String state;
	
	//Booking.java   reference
	 @OneToMany(mappedBy="route",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	 private Set<Booking> bookings;
	
	
	public Route(){
		
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getSource() {
		return source;
	}




	public void setSource(String source) {
		this.source = source;
	}




	public Destination getDestination() {
		return destination;
	}




	public void setDestination(Destination destination) {
		this.destination = destination;
	}




	public String getExpectedTravelTime() {
		return expectedTravelTime;
	}




	public void setExpectedTravelTime(String expectedTravelTime) {
		this.expectedTravelTime = expectedTravelTime;
	}




	public int getEconomyFare() {
		return economyFare;
	}




	public void setEconomyFare(int economyFare) {
		this.economyFare = economyFare;
	}




	public int getAcFare() {
		return acFare;
	}




	public void setAcFare(int acFare) {
		this.acFare = acFare;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}

	
}
