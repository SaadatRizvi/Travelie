package com.travelie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="route")
public class Route {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="exp_t_time")
	private String extTTime;
	
	@Column(name="eco_fare")
	private int ecoFare;
	
	@Column(name="ac_fare")
	private int acFare;
	
	@Column(name="state")
	private String state;
	
	
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


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


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


	@Override
	public String toString() {
		return "Route [id=" + id + ", source=" + source + ", destination=" + destination + ", extTTime=" + extTTime
				+ ", ecoFare=" + ecoFare + ", acFare=" + acFare + ", state=" + state + "]";
	}
	
}


