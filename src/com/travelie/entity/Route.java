package com.travelie.entity;

<<<<<<< HEAD
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
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
>>>>>>> 424fd1e6157860ef2e165a28127f81496fc34fc3

@Entity
@Table(name="route")
public class Route {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="source")
	private String source;
	
<<<<<<< HEAD
	
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
=======
	@Column(name="destination")
	private String destination;
	
	@Column(name="exp_t_time")
	private String extTTime;
	
	@Column(name="eco_fare")
	private int ecoFare;
	
	@Column(name="ac_fare")
	private int acFare;
>>>>>>> 424fd1e6157860ef2e165a28127f81496fc34fc3
	
	@Column(name="state")
	private String state;
	
<<<<<<< HEAD
	//Booking.java   reference
	 @OneToMany(mappedBy="route",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	 private Set<Booking> bookings;
	
=======
>>>>>>> 424fd1e6157860ef2e165a28127f81496fc34fc3
	
	public Route(){
		
	}


<<<<<<< HEAD


=======
>>>>>>> 424fd1e6157860ef2e165a28127f81496fc34fc3
	public int getId() {
		return id;
	}


<<<<<<< HEAD


=======
>>>>>>> 424fd1e6157860ef2e165a28127f81496fc34fc3
	public void setId(int id) {
		this.id = id;
	}


<<<<<<< HEAD


=======
>>>>>>> 424fd1e6157860ef2e165a28127f81496fc34fc3
	public String getSource() {
		return source;
	}


<<<<<<< HEAD


=======
>>>>>>> 424fd1e6157860ef2e165a28127f81496fc34fc3
	public void setSource(String source) {
		this.source = source;
	}


<<<<<<< HEAD


	public Destination getDestination() {
=======
	public String getDestination() {
>>>>>>> 424fd1e6157860ef2e165a28127f81496fc34fc3
		return destination;
	}


<<<<<<< HEAD


	public void setDestination(Destination destination) {
=======
	public void setDestination(String destination) {
>>>>>>> 424fd1e6157860ef2e165a28127f81496fc34fc3
		this.destination = destination;
	}


<<<<<<< HEAD


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




=======
	public String getExtTTime() {
		return extTTime;
	}


	public void setExtTTime(String extTTime) {
		this.extTTime = extTTime;
	}


	public int getEcoFare() {
		return ecoFare;
	}


	public void setEcoFare(int ecoFare) {
		this.ecoFare = ecoFare;
	}


>>>>>>> 424fd1e6157860ef2e165a28127f81496fc34fc3
	public int getAcFare() {
		return acFare;
	}


<<<<<<< HEAD


=======
>>>>>>> 424fd1e6157860ef2e165a28127f81496fc34fc3
	public void setAcFare(int acFare) {
		this.acFare = acFare;
	}


<<<<<<< HEAD


=======
>>>>>>> 424fd1e6157860ef2e165a28127f81496fc34fc3
	public String getState() {
		return state;
	}


<<<<<<< HEAD


	public void setState(String state) {
		this.state = state;
	}
	
	

	public String getDestination_location() {
		return destination_location;
	}


	public void setDestination_location(String destination_location) {
		this.destination_location = destination_location;
	}

	
}
=======
	public void setState(String state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return "Route [id=" + id + ", source=" + source + ", destination=" + destination + ", extTTime=" + extTTime
				+ ", ecoFare=" + ecoFare + ", acFare=" + acFare + ", state=" + state + "]";
	}
	
}


>>>>>>> 424fd1e6157860ef2e165a28127f81496fc34fc3
