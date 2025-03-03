package tn.esprit.projetspring1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetspring1.Entities.Universite;
import tn.esprit.projetspring1.Services.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {
    @Autowired
    IUniversiteService iUniversiteService;
    @PostMapping("/add_universite")
    public Universite addUniversite(@RequestBody Universite universite) {
        return iUniversiteService.addUniversite(universite);
    }


    @PutMapping("/upadate_universite")
    public Universite updateUniversite(@RequestBody Universite universite) {
        return iUniversiteService.updateUniversite(universite);
    }

    @GetMapping("/dispalyAlluniversites")
    public List<Universite> displayalluniversites() {
        return iUniversiteService.retrieveAllUniversities();
    }

    @GetMapping("/dispalyuniversite/{id}")
    public Universite displayuniversite(@PathVariable("id") long inUniversite) {
        return iUniversiteService.retrieveUniversite(inUniversite);
    }


}
