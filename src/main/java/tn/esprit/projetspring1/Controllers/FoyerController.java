package tn.esprit.projetspring1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetspring1.Entities.Foyer;
import tn.esprit.projetspring1.Services.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")

public class FoyerController {
    @Autowired
    IFoyerService iFoyerService;

    @PostMapping("/add_foyer")
    public Foyer addfoyer(@RequestBody Foyer foyer) {
        return iFoyerService.addFoyer(foyer);
    }


    @PutMapping("/upadate_foyer")
    public Foyer updatefoyer(@RequestBody Foyer foyer) {
        return iFoyerService.updateFoyer(foyer);
    }

    @GetMapping("/dispalyAllfoyers")
    public List<Foyer> displayallfoyers() {
        return iFoyerService.retrieveAllFoyers();
    }

    @GetMapping("/dispalyfoyer/{id}")
    public Foyer displayfoyer(@PathVariable("id") long idfoyer) {
        return iFoyerService.retrieveFoyer(idfoyer);
    }

    @DeleteMapping("/delete/{id}")
    public void deletefoyer(@PathVariable("id") long idfoyer) {
        iFoyerService.removeFoyer(idfoyer);
    }
}

