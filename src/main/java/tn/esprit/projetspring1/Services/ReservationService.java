package tn.esprit.projetspring1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetspring1.Entities.Reservation;
import tn.esprit.projetspring1.Repository.IReservationRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor


public class ReservationService implements IReservationService{

    IReservationRepository iReservationRepository;
    @Override
    public List<Reservation> retrieveAllReservation() {
        return (List<Reservation>)iReservationRepository.findAll();
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
}
