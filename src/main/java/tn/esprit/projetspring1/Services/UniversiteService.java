package tn.esprit.projetspring1.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projetspring1.Entities.Foyer;
import tn.esprit.projetspring1.Entities.Universite;
import tn.esprit.projetspring1.Repository.IFoyerRepository;
import tn.esprit.projetspring1.Repository.IUniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor


public class UniversiteService implements IUniversiteService{
    @Autowired
    IUniversiteRepository iUniversiteRepository;
    @Autowired
    IFoyerRepository iFoyerRepository;
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

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = iFoyerRepository.findById(idFoyer).get();

        if (foyer == null) {
            throw new RuntimeException("Foyer avec ID " + idFoyer + " introuvable.");
        }

        // Vérifier si l'université existe
        Universite universite = iUniversiteRepository.findByNomUniversite(nomUniversite);
        if (universite == null) {
            throw new RuntimeException("Université avec nom " + nomUniversite + " introuvable.");
        }

        universite.setFoyer(foyer);
        foyer.setUniversite(universite);

        return iUniversiteRepository.save(universite);
    }


}
