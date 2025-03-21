package tn.esprit.projetspring1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetspring1.Entities.Chambre;
import tn.esprit.projetspring1.Services.IChambreService;
import tn.esprit.projetspring1.Entities.TypeChambre;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")

public class ChambreController {
    @Autowired

    IChambreService iChambreService;

    @PostMapping("/add_chambre")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return iChambreService.addChambre(chambre);
    }


    @PutMapping("/upadate_chambre")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return iChambreService.updateChambre(chambre);
    }

    @GetMapping("/dispalyAllchambres")
    public List<Chambre> displayallchambres() {
        return iChambreService.retrieveAllChambres();
    }

    @GetMapping("/dispalychambre/{id}")
    public Chambre displaychambre(@PathVariable("id") long idChambre) {
        return iChambreService.retrieveChambre(idChambre);
    }

    @GetMapping("/chambres-non-reservees/{nomUniversite}/{typeChambre}")
    public List<Chambre> getChambresNonReservees(@PathVariable String nomUniversite, @PathVariable TypeChambre typeChambre) {
        return iChambreService.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, typeChambre);
    }
    @GetMapping("/chambres-par-bloc/{idBloc}/{typeChambre}")
    public List<Chambre> getChambresParBloc(@PathVariable long idBloc, @PathVariable TypeChambre typeChambre) {
        return iChambreService.getChambresParBlocEtType(idBloc, typeChambre);
    }
}
