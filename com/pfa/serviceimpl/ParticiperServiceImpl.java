package com.pfa.serviceimpl;

import com.pfa.model.Formation;
import com.pfa.model.Beneficiaire;
import com.pfa.repository.BeneficiaireRepository;
import com.pfa.repository.FormationRepository;
import com.pfa.service.ParticiperService;
import com.pfa.exception.BeneficiaireNotFoundException;
import com.pfa.exception.FormationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticiperServiceImpl implements ParticiperService {

    private final BeneficiaireRepository beneficiaireRepository;
    private final FormationRepository formationRepository;

    @Autowired
    public ParticiperServiceImpl(BeneficiaireRepository beneficiaireRepository, FormationRepository formationRepository) {
        this.beneficiaireRepository = beneficiaireRepository;
        this.formationRepository = formationRepository;
    }

    public void addBeneficiaireToFormation(Long beneficiaireId, Long formationId) {
        Beneficiaire beneficiaire = beneficiaireRepository.findById(beneficiaireId).orElse(null);
        Formation formation = formationRepository.findById(formationId).orElse(null);
        if (beneficiaire == null) {
            throw new BeneficiaireNotFoundException("Beneficiaire not found with ID: " + beneficiaireId);
        }
        if (formation == null) {
            throw new FormationNotFoundException("Formation not found with ID: " + formationId);
        }
        beneficiaire.getFormations().add(formation);
        beneficiaireRepository.save(beneficiaire);
    }

    public void removeBeneficiaireFromFormation(Long beneficiaireId, Long formationId) {
        Beneficiaire beneficiaire = beneficiaireRepository.findById(beneficiaireId).orElse(null);
        Formation formation = formationRepository.findById(formationId).orElse(null);
        if (beneficiaire == null) {
            throw new BeneficiaireNotFoundException("Beneficiaire not found with ID: " + beneficiaireId);
        }
        if (formation == null) {
            throw new FormationNotFoundException("Formation not found with ID: " + formationId);
        }
        beneficiaire.getFormations().remove(formation);
        beneficiaireRepository.save(beneficiaire);
    }
}
