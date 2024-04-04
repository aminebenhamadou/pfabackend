package com.pfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfa.model.Beneficiaire;

@Repository
public interface BeneficiaireRepository extends JpaRepository<Beneficiaire, Long> {
  
}