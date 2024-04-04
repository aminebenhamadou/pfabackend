package com.pfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pfa.model.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
    
}