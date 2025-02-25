package tn.esprit.projetspring1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.projetspring1.Services.IReservationService;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")

public class ReservationController {
    IReservationService iReservationService;
}
