package tn.esprit.projetspring1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetspring1.Entities.Bloc;
import tn.esprit.projetspring1.Entities.Etudiant;
import tn.esprit.projetspring1.Services.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")

public class EtudiantController {
    @Autowired
    IEtudiantService iEtudiantService;
    @PostMapping("/add_etudiant")
    public  List<Etudiant>  addEtudiants(@RequestBody  List<Etudiant>  etudiants) {
        return iEtudiantService.addEtudiants(etudiants);
    }


    @PutMapping("/upadate_etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return iEtudiantService.updateEtudiant(etudiant);
    }

    @GetMapping("/dispalyAllEtudiants")
    public List<Etudiant> displayalletudiants() {
        return iEtudiantService.retrieveAllEtudiants();
    }

    @GetMapping("/dispalyetudiant/{id}")
    public Etudiant displayEtudiant(@PathVariable("id") long idEtudiant) {
        return iEtudiantService.retrieveEtudiant(idEtudiant);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable("id") long idEtudiant) {
        iEtudiantService.removeEtudiant(idEtudiant);
    }
}