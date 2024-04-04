package com.pfa.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.pfa.model.Formateur;
import com.pfa.repository.FormateurRepository;
import com.pfa.service.FormateurService;

@Service
public class FormateurServiceImpl implements FormateurService {

    private final FormateurRepository formateurRepository;

    @Autowired
    public FormateurServiceImpl(FormateurRepository formateurRepository) {
        this.formateurRepository = formateurRepository;
    }

    @Override
    public List<Formateur> getAllFormateurs() {
        return formateurRepository.findAll();
    }

    @Override
    public Formateur getFormateurById(Long id) {
        Optional<Formateur> optionalFormateur = formateurRepository.findById(id);
        return optionalFormateur.orElse(null);
    }

    @Override
    public Formateur createFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    @Override
    public Formateur updateFormateur(Long id, Formateur updatedFormateur) {
        Optional<Formateur> optionalFormateur = formateurRepository.findById(id);
        if (optionalFormateur.isPresent()) {
            Formateur existingFormateur = optionalFormateur.get();
            existingFormateur.setFirstName(updatedFormateur.getFirstName());
            existingFormateur.setLastName(updatedFormateur.getLastName());
            existingFormateur.setCin(updatedFormateur.getCin());
            existingFormateur.setPhoneNumber(updatedFormateur.getPhoneNumber());
            existingFormateur.setEmail(updatedFormateur.getEmail());
            existingFormateur.setAdress(updatedFormateur.getAdress());
            existingFormateur.setDomain(updatedFormateur.getDomain());
            existingFormateur.setImage(updatedFormateur.getImage());
            return formateurRepository.save(existingFormateur);
        }
        return null;
    }

    @Override
    public void deleteFormateur(Long id) {
        formateurRepository.deleteById(id);
    }
}
