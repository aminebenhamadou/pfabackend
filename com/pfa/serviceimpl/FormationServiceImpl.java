package com.pfa.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.exception.FormateurNotFoundException;
import com.pfa.exception.FormationNotFoundException;
import com.pfa.model.Formation;
import com.pfa.model.Status;
import com.pfa.repository.FormateurRepository;
import com.pfa.repository.FormationRepository;
import com.pfa.service.FormationService;

@Service
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;
    private final FormateurRepository formateurRepository;

    @Autowired
    public FormationServiceImpl(FormationRepository formationRepository, FormateurRepository formateurRepository) {
        this.formationRepository = formationRepository;
        this.formateurRepository = formateurRepository;
    }

    @Override
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    @Override
    public Formation getFormationById(Long id) {
        Optional<Formation> optionalFormation = formationRepository.findById(id);
        return optionalFormation.orElse(null);
    }

    @Override
    public Formation createFormation(Formation formation) throws FormateurNotFoundException {
        if (formation.getFormateur() != null && formateurRepository.existsById(formation.getFormateur().getId())) {
            // Set status to PLANNED by default
            formation.setStatus(Status.PLANNED);
            return formationRepository.save(formation);
        } else {
            throw new FormateurNotFoundException("Formateur not found");
        }
    }

    @Override
    public Formation updateFormation(Long id, Formation updatedFormation) {
        // Vérifier l'existence de la formation
        if (formationRepository.existsById(id)) {
            // Vérifier l'existence du formateur
            if (updatedFormation.getFormateur() != null && formateurRepository.existsById(updatedFormation.getFormateur().getId())) {
                updatedFormation.setId(id);
                return formationRepository.save(updatedFormation);
            } else {
                throw new FormateurNotFoundException("Formateur not found");
            }
        } else {
            throw new FormationNotFoundException("Formation not found");
        }
    }

    @Override
    public void deleteFormation(Long id) {
        formationRepository.deleteById(id);
    }
}
