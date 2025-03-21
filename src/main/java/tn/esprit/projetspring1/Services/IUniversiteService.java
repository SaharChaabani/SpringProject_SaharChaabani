package tn.esprit.projetspring1.Services;

import tn.esprit.projetspring1.Entities.Foyer;
import tn.esprit.projetspring1.Entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (long idUniversite);

    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);
    Universite desaffecterFoyerAUniversite (long idUniversite) ;
    Universite ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);

}
