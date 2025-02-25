package tn.esprit.projetspring1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetspring1.Entities.Universite;
import tn.esprit.projetspring1.Repository.IUniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor


public class UniversiteService implements IUniversiteService{


    IUniversiteRepository iUniversiteRepository;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return (List<Universite>) iUniversiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return iUniversiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return iUniversiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return iUniversiteRepository.findById(idUniversite).orElse(null);
    }
}
