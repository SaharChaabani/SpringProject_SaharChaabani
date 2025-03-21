package tn.esprit.projetspring1.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projetspring1.Entities.Bloc;
import tn.esprit.projetspring1.Entities.Foyer;
import tn.esprit.projetspring1.Entities.Universite;
import tn.esprit.projetspring1.Repository.IBlocRepository;
import tn.esprit.projetspring1.Repository.IFoyerRepository;
import tn.esprit.projetspring1.Repository.IUniversiteRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor


public class UniversiteService implements IUniversiteService{
    @Autowired
    IUniversiteRepository iUniversiteRepository;
    @Autowired
    IFoyerRepository iFoyerRepository;
    @Autowired
    IBlocRepository iBlocRepository;


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
    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        // Récupérer l'université par son ID
        Universite universite = iUniversiteRepository.findById(idUniversite).orElse(null);

        if (universite == null) {
            throw new RuntimeException("Université avec ID " + idUniversite + " introuvable.");
        }

        // Vérifier si l'université a un foyer affecté
        if (universite.getFoyer() == null) {
            throw new RuntimeException("Cette université n'a pas de foyer affecté.");
        }

//        // Récupérer le foyer associé
//        Foyer foyer = universite.getFoyer();

        // Supprimer l'association entre le foyer et l'université
        universite.setFoyer(null);
//        foyer.setUniversite(null);

        // Sauvegarder les modifications dans la base de données
//        iFoyerRepository.save(foyer); // Mise à jour du foyer
        return iUniversiteRepository.save(universite); // Mise à jour de l'université
    }
    @Override
    public Universite ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = iUniversiteRepository.findById(idUniversite).orElse(null);
        Foyer savedFoyer = iFoyerRepository.save(foyer);

        universite.setFoyer(savedFoyer);
        iUniversiteRepository.save(universite);
        Set<Bloc> blocs = foyer.getBlocs();
        if (blocs != null) {
            for (Bloc bloc : blocs) {
                bloc.setFoyer(savedFoyer);
                iBlocRepository.save(bloc);
            }
        }

        savedFoyer.setBlocs(blocs);
        iFoyerRepository.save(savedFoyer);

        return universite;

    }

}
