package com.pfa.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
public class Beneficiaire extends Personne {
	private String educationLevel;

	public Beneficiaire(Long id, String firstName, String lastName, @Size(min = 8, max = 8) String cin,
			@Size(min = 8, max = 8) String phoneNumber, @Email String email, String adress, String educationLevel, String image) {
		super(id, firstName, lastName, cin, phoneNumber, email, adress, image);
		this.educationLevel = educationLevel;
	}

	public Beneficiaire() {
		super();
	}

	@ManyToMany
	@JoinTable(name = "Participer", joinColumns = @JoinColumn(name = "beneficiere_id"), inverseJoinColumns = @JoinColumn(name = "formation_id"))
	private List<Formation> formations;

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

}
