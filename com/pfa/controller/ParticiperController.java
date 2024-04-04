package com.pfa.controller;

import com.pfa.service.ParticiperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/participer")
public class ParticiperController {

    private final ParticiperService participerService;

    @Autowired
    public ParticiperController(ParticiperService participerService) {
        this.participerService = participerService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBeneficiaireToFormation(@RequestParam Long beneficiaireId, @RequestParam Long formationId) {
        participerService.addBeneficiaireToFormation(beneficiaireId, formationId);
        return ResponseEntity.status(HttpStatus.OK).body("Beneficiaire added to formation successfully.");
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeBeneficiaireFromFormation(@RequestParam Long beneficiaireId, @RequestParam Long formationId) {
        participerService.removeBeneficiaireFromFormation(beneficiaireId, formationId);
        return ResponseEntity.status(HttpStatus.OK).body("Beneficiaire removed from formation successfully.");
    }
}
