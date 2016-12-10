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
@Table(name="van")
public class Van {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="vehicle_registration")
	private String vehicleRegistration;
	
	@Column(name="vehicle_type")
	private String vehicleType;
	
	@Column(name="total_seats")
	private int totalSeats;
	
	@ManyToOne
	@JoinColumn(name="vancategory_id")
	private VanType category;
	
	@Transient
	private String vanTypeCategory;
	
	@Column(name="flagged")
	private int flagged;	
	
	//Booking.java   reference
	 @OneToMany(mappedBy="van",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	    private Set<Booking> bookings;
	
	 	 
	
	public Set<Booking> getBookings() {
		return bookings;
	}


	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}


	public Van(){
		//vanTypeCategory = category.getType();        
	}


	public String getVanTypeCategory() {
		return vanTypeCategory;
	}


	public void setVanTypeCategory(String vanTypeCategory) {
		this.vanTypeCategory = vanTypeCategory;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}



	public String getVehicleRegistration() {
		return vehicleRegistration;
	}






	public void setVehicleRegistration(String vehicleRegistration) {
		this.vehicleRegistration = vehicleRegistration;
	}






	public String getVehicleType() {
		return vehicleType;
	}






	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}






	public int getTotalSeats() {
		return totalSeats;
	}






	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}


	public VanType getCategory() {
		return category;
	}


	public void setCategory(VanType category) {
		this.category = category;
	}


	public int getFlagged() {
		return flagged;
	}


	public void setFlagged(int flagged) {
		this.flagged = flagged;
	}


	@Override
	public String toString() {
		return "Van [id=" + id + ", vehicleRegistration=" + vehicleRegistration + ", vehicleType=" + vehicleType
				+ ", totalSeats=" + totalSeats + ", category=" + category + ", flagged=" + flagged + "]";
	}








	





	
	
	
	
}
