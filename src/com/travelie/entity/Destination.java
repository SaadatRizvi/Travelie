package com.travelie.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="destination")
public class Destination {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="location", unique = true, nullable = false)
	private String location;
	
	
	@OneToMany(mappedBy="destination",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private Set<Route> routes;
	
	
	




	public Set<Route> getRoutes() {
		return routes;
	}




	public void setRoutes(Set<Route> routes) {
		this.routes = routes;
	}




	public Destination(){
		
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	@Override
	public String toString() {
		return "Destination [id=" + id + ", location=" + location + "]";
	}


	



	
	
	
	
}
