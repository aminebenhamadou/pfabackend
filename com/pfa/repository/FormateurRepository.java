package com.pfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfa.model.Formateur;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long> {
    
}