package tn.esprit.projetspring1.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projetspring1.Entities.*;
import tn.esprit.projetspring1.Repository.IBlocRepository;
import tn.esprit.projetspring1.Repository.IChambreRepository;
import tn.esprit.projetspring1.Repository.IEtudiantRepository;
import tn.esprit.projetspring1.Repository.IReservationRepository;

import java.util.*;

@Service
@AllArgsConstructor


public class ReservationService implements IReservationService {
    @Autowired
    IReservationRepository iReservationRepository;
    @Autowired
    IChambreRepository iChambreRepository;

    @Autowired
    IEtudiantRepository iEtudiantRepository;

    @Autowired
    IBlocRepository blocRepository;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return (List<Reservation>) iReservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return iReservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return iReservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite) {
        return iReservationRepository.findReservationsByAnneeUniversitaire(anneeUniversitaire);
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        // Vérifier si l'étudiant existe
        Etudiant etudiant = iEtudiantRepository.findByCin(cinEtudiant);
        if (etudiant == null) {
            throw new RuntimeException("Étudiant non trouvé avec CIN : " + cinEtudiant);
        }

        // Vérifier si le bloc existe
        Optional<Bloc> blocOpt = blocRepository.findById(idBloc);
        if (!blocOpt.isPresent()) {
            throw new RuntimeException("Bloc non trouvé avec ID : " + idBloc);
        }
        Bloc bloc = blocOpt.get();

        // Vérifier la capacité des chambres dans le bloc
        Set<Chambre> chambres = bloc.getChambres();
        int totalPlacesDisponibles = 0;
        for (Chambre chambre : chambres) {
            // Calculez les places disponibles en fonction du type de chambre
            int placesDisponibles = 0;
            switch (chambre.getTypeC()) {
                case SIMPLE:
                    placesDisponibles = 1; // 1 place pour une chambre simple
                    break;
                case DOUBLE:
                    placesDisponibles = 2; // 2 places pour une chambre double
                    break;
                case TRIPLE:
                    placesDisponibles = 3; // 3 places pour une chambre triple
                    break;
            }

            // Vérifier combien de réservations existent déjà
            int placesReservees = chambre.getReservations().size();
            int placesRestantes = placesDisponibles - placesReservees;

            totalPlacesDisponibles += placesRestantes;
        }

        // Si les places disponibles sont insuffisantes, lancer une exception
        if (totalPlacesDisponibles <= 0) {
            throw new RuntimeException("Aucune place disponible dans ce bloc.");
        }

        // Générer le numéro de réservation (numChambre-nomBloc-anneeUniversitaire)
        String numReservation = String.format("%d-%s-%tY",
                idBloc,
                bloc.getNomBloc(),
                new Date());

        // Créer la réservation
        Reservation reservation = new Reservation();
        reservation.setIdReservation(numReservation);
        reservation.setAnneeUniversitaire(new Date()); // Date actuelle
        reservation.setEstValide(true);  // L'ajout de la réservation est valide par défaut
        reservation.setEtudiants(new HashSet<>());  // Créer un ensemble d'étudiants

        // Ajouter l'étudiant à la réservation
        reservation.getEtudiants().add(etudiant);

        // Sauvegarder la réservation
        return iReservationRepository.save(reservation);
    }


}