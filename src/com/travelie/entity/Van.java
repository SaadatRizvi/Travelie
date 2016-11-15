package com.travelie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name="category")
	private String category;
	
	@Column(name="flagged")
	private int flagged;	
	
	public Van(){
		
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






	public String getCategory() {
		return category;
	}






	public void setCategory(String category) {
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
