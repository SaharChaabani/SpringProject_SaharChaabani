package tn.esprit.projetspring1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.projetspring1.Services.IChambreService;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")

public class ChambreController {
    IChambreService iChambreService;
}
