package com.pfa.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity

public class Formateur extends Personne {

    private String domain;
    

    
    public Formateur() {
		super();
	}

	public Formateur(Long id, @NotBlank String firstName, @NotBlank String lastName, @Size(min = 8, max = 8) String cin,
            @Size(min = 8, max = 8) String phoneNumber, @Email String email, String address, String domain, String image) {
        super(id, firstName, lastName, cin, phoneNumber, email, address, image);
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
