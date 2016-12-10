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
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="regnumber")
	private int regNumber;
	
	@Column(name="phonenumber")
	private int phoneNumber;
	
	@Column(name="flagged")
	private int flagged;
	
	
	//Ticket.java   reference
		 @OneToMany(mappedBy="customer",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
		 private Set<Ticket> tickets;
	
		 
		 
		 
		 
		 
	public Set<Ticket> getTickets() {
			return tickets;
		}


		public void setTickets(Set<Ticket> tickets) {
			this.tickets = tickets;
		}


	public Customer(){
		
	}


	public int getRegNumber() {
		return regNumber;
	}


	public void setRegNumber(int regNumber) {
		this.regNumber = regNumber;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getFlagged() {
		return flagged;
	}


	public void setFlagged(int flagged) {
		this.flagged = flagged;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", regNumber=" + regNumber + ", phoneNumber=" + phoneNumber + ", flagged=" + flagged + "]";
	}





	
	
	
	
}
