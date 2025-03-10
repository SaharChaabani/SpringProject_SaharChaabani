package tn.esprit.projetspring1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetspring1.Entities.Foyer;
import tn.esprit.projetspring1.Entities.Reservation;
import tn.esprit.projetspring1.Services.IReservationService;

import java.util.List;
import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")

public class ReservationController {
    @Autowired
    IReservationService iReservationService;

    @PutMapping("/upadate_reservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return iReservationService.updateReservation(reservation);
    }

    @GetMapping("/dispalyAllreservations")
    public List<Reservation> displayallReservations() {
        return iReservationService.retrieveAllReservation();
    }

    @GetMapping("/dispalyreservation/{id}")
    public Reservation displayReservation(@PathVariable("id") String idReservation) {
        return iReservationService.retrieveReservation(idReservation);
    }

    @GetMapping("/reservations/{anneeUniversitaire}/{nomUniversite}")
    public List<Reservation> getReservationsParAnneeUniversitaire(@PathVariable Date anneeUniversitaire, @PathVariable String nomUniversite) {
        return iReservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversitaire, nomUniversite);
    }
}
