package com.pfa.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.model.Beneficiaire;
import com.pfa.model.Formation;
import com.pfa.repository.BeneficiaireRepository;
import com.pfa.repository.FormationRepository;
import com.pfa.service.BeneficiaireService;

@Service
public class BeneficiaireServiceImpl implements BeneficiaireService {

    private final BeneficiaireRepository beneficiaireRepository;
    private final FormationRepository formationRepository;

    @Autowired
    public BeneficiaireServiceImpl(BeneficiaireRepository beneficiaireRepository, FormationRepository formationRepository) {
        this.beneficiaireRepository = beneficiaireRepository;
        this.formationRepository = formationRepository;
    }

    @Override
    public List<Beneficiaire> getAllBeneficiaires() {
        return beneficiaireRepository.findAll();
    }

    @Override
    public Beneficiaire getBeneficiaireById(Long id) {
        Optional<Beneficiaire> optionalBeneficiaire = beneficiaireRepository.findById(id);
        return optionalBeneficiaire.orElse(null);
    }

    @Override
    public Beneficiaire createBeneficiaire(Beneficiaire beneficiaire) {
        return beneficiaireRepository.save(beneficiaire);
    }

    @Override
    public Beneficiaire updateBeneficiaire(Long id, Beneficiaire updatedBeneficiaire) {
        Optional<Beneficiaire> optionalBeneficiaire = beneficiaireRepository.findById(id);
        if (optionalBeneficiaire.isPresent()) {
            Beneficiaire existingBeneficiaire = optionalBeneficiaire.get();
            existingBeneficiaire.setFirstName(updatedBeneficiaire.getFirstName());
            existingBeneficiaire.setLastName(updatedBeneficiaire.getLastName());
            existingBeneficiaire.setCin(updatedBeneficiaire.getCin());
            existingBeneficiaire.setPhoneNumber(updatedBeneficiaire.getPhoneNumber());
            existingBeneficiaire.setEmail(updatedBeneficiaire.getEmail());
            existingBeneficiaire.setAdress(updatedBeneficiaire.getAdress());
            existingBeneficiaire.setEducationLevel(updatedBeneficiaire.getEducationLevel());
            existingBeneficiaire.setImage(updatedBeneficiaire.getImage());
            return beneficiaireRepository.save(existingBeneficiaire);
        }
        return null;
    }

    @Override
    public void deleteBeneficiaire(Long id) {
        beneficiaireRepository.deleteById(id);
    }

    @Override
    public Beneficiaire addFormationToBeneficiaire(Long beneficiaireId, Long formationId) {
        Optional<Beneficiaire> optionalBeneficiaire = beneficiaireRepository.findById(beneficiaireId);
        Optional<Formation> optionalFormation = formationRepository.findById(formationId);

        if (optionalBeneficiaire.isPresent() && optionalFormation.isPresent()) {
            Beneficiaire beneficiaire = optionalBeneficiaire.get();
            Formation formation = optionalFormation.get();
            beneficiaire.getFormations().add(formation);
            return beneficiaireRepository.save(beneficiaire);
        }
        return null;
    }

    @Override
    public Beneficiaire removeFormationFromBeneficiaire(Long beneficiaireId, Long formationId) {
        Optional<Beneficiaire> optionalBeneficiaire = beneficiaireRepository.findById(beneficiaireId);
        if (optionalBeneficiaire.isPresent()) {
            Beneficiaire beneficiaire = optionalBeneficiaire.get();
            beneficiaire.getFormations().removeIf(formation -> formation.getId().equals(formationId));
            return beneficiaireRepository.save(beneficiaire);
        }
        return null;
    }
}
