package tn.esprit.projetspring1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetspring1.Entities.Bloc;
import tn.esprit.projetspring1.Services.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")

public class BlocController {
    @Autowired

    IBlocService iBlocService;


    @PostMapping("/add_bloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return iBlocService.addBloc(bloc);
    }


    @PutMapping("/upadate_bloc")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return iBlocService.updateBloc(bloc);
    }

    @GetMapping("/dispalyAllBlocs")
    public List<Bloc> displayallbloc() {
        return iBlocService.retrieveBlocs();
    }

    @GetMapping("/dispalybloc/{id}")
    public Bloc displaybloc(@PathVariable("id") long idBloc) {
        return iBlocService.retrieveBloc(idBloc);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBloc(@PathVariable("id") long idBloc) {
        iBlocService.removeBloc(idBloc);
    }

    @PutMapping("/affecterChambres/{idBloc}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambres, @PathVariable long idBloc) {
        return iBlocService.affecterChambresABloc(numChambres, idBloc);
    }
}