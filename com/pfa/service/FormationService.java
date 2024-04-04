package com.pfa.service;

import java.util.List;
import com.pfa.model.Formation;

public interface FormationService {
    List<Formation> getAllFormations();
    Formation getFormationById(Long id);
    Formation createFormation(Formation formation);
    Formation updateFormation(Long id, Formation formation);
    void deleteFormation(Long id);
}
