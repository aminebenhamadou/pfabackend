package com.pfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pfa.model.Beneficiaire;
import com.pfa.service.BeneficiaireService;
import com.pfa.serviceimpl.BeneficiaireServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/beneficiaires")
public class BeneficiaireController {

    private final BeneficiaireService beneficiaireService;

    @Autowired
    public BeneficiaireController(BeneficiaireService beneficiaireService) {
        this.beneficiaireService = beneficiaireService;
    }

    @GetMapping
    public ResponseEntity<List<Beneficiaire>> getAllBeneficiaires() {
        List<Beneficiaire> beneficiaires = beneficiaireService.getAllBeneficiaires();
        return new ResponseEntity<>(beneficiaires, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beneficiaire> getBeneficiaireById(@PathVariable Long id) {
        Beneficiaire beneficiaire = beneficiaireService.getBeneficiaireById(id);
        if (beneficiaire != null) {
            return new ResponseEntity<>(beneficiaire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Beneficiaire> createBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
        Beneficiaire createdBeneficiaire = beneficiaireService.createBeneficiaire(beneficiaire);
        return new ResponseEntity<>(createdBeneficiaire, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Beneficiaire> updateBeneficiaire(@PathVariable Long id, @RequestBody Beneficiaire beneficiaire) {
        Beneficiaire updatedBeneficiaire = beneficiaireService.updateBeneficiaire(id, beneficiaire);
        if (updatedBeneficiaire != null) {
            return new ResponseEntity<>(updatedBeneficiaire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeneficiaire(@PathVariable Long id) {
        beneficiaireService.deleteBeneficiaire(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/{beneficiaireId}/formations/{formationId}")
    public ResponseEntity<Beneficiaire> addFormationToBeneficiaire(
            @PathVariable Long beneficiaireId,
            @PathVariable Long formationId
    ) {
        Beneficiaire updatedBeneficiaire = beneficiaireService.addFormationToBeneficiaire(beneficiaireId, formationId);
        if (updatedBeneficiaire != null) {
            return new ResponseEntity<>(updatedBeneficiaire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{beneficiaireId}/formations/{formationId}")
    public ResponseEntity<Beneficiaire> removeFormationFromBeneficiaire(
            @PathVariable Long beneficiaireId,
            @PathVariable Long formationId
    ) {
        Beneficiaire updatedBeneficiaire = beneficiaireService.removeFormationFromBeneficiaire(beneficiaireId, formationId);
        if (updatedBeneficiaire != null) {
            return new ResponseEntity<>(updatedBeneficiaire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
