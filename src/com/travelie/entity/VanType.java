package com.travelie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vantype")
public class VanType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	private String type;
	
	
	
		
	public VanType(){
		
	}




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




	@Override
	public String toString() {
		return "VanType [id=" + id + ", type=" + type + "]";
	}






	



	
	
	
	
}
