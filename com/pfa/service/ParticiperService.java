package com.pfa.service;

public interface ParticiperService {
    void addBeneficiaireToFormation(Long beneficiaireId, Long formationId);
    void removeBeneficiaireFromFormation(Long beneficiaireId, Long formationId);
}
