package com.pfa.service;

import java.util.List;
import com.pfa.model.Formateur;

public interface FormateurService {
    List<Formateur> getAllFormateurs();
    Formateur getFormateurById(Long id);
    Formateur createFormateur(Formateur formateur);
    Formateur updateFormateur(Long id, Formateur formateur);
    void deleteFormateur(Long id);
}
