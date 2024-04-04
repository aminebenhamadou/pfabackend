package com.pfa.service;

import java.util.List;
import com.pfa.model.Beneficiaire;
import com.pfa.model.Formation;

public interface BeneficiaireService {
    List<Beneficiaire> getAllBeneficiaires();
    Beneficiaire getBeneficiaireById(Long id);
    Beneficiaire createBeneficiaire(Beneficiaire beneficiaire);
    Beneficiaire updateBeneficiaire(Long id, Beneficiaire beneficiaire);
    void deleteBeneficiaire(Long id);
    Beneficiaire addFormationToBeneficiaire(Long beneficiaireId, Long formationId);
    Beneficiaire removeFormationFromBeneficiaire(Long beneficiaireId, Long formationId);
    
    
}
