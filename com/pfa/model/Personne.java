package com.pfa.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	protected String firstName;

	protected String lastName;

	@Size(min = 8, max = 8)
	protected String cin;

	@Size(min = 8, max = 8)
	protected String phoneNumber;

	@Email
	protected String email;

	protected String Adress;
	
	protected String image;

	public Personne() {
		super();
	}

	public Personne(Long id, String firstName, String lastName, @Size(min = 8, max = 8) String cin,
			@Size(min = 8, max = 8) String phoneNumber, @Email String email, String adress, String image) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cin = cin;
		this.phoneNumber = phoneNumber;
		this.email = email;
		Adress = adress;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	

	// Constructors, getters, and setters
}