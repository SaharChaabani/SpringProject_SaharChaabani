package tn.esprit.projetspring1.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projetspring1.Entities.Bloc;
import tn.esprit.projetspring1.Entities.Chambre;
import tn.esprit.projetspring1.Repository.IBlocRepository;
import tn.esprit.projetspring1.Repository.IChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class BlocService implements IBlocService{
    @Autowired
    IBlocRepository iBlocRepository;

    @Autowired
    private IChambreRepository iChambreRepository;
    @Override
    public List<Bloc> retrieveBlocs() {
        return (List<Bloc>)iBlocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return iBlocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return iBlocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return iBlocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        iBlocRepository.deleteById(idBloc);

    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambres, long idBloc) {
        // Récupérer le bloc
        Bloc bloc = iBlocRepository.findById(idBloc).orElse(null);
        if (bloc == null) {
            throw new RuntimeException("Bloc avec ID " + idBloc + " introuvable.");
        }

        // Récupérer les chambres à partir des IDs
        List<Chambre> chambres = iChambreRepository.findByNumeroChambreIn(numChambres);
        if (chambres.isEmpty()) {
            throw new RuntimeException("Aucune chambre trouvée avec les IDs fournis.");
        }

        // Affecter le bloc aux chambres et mettre à jour la relation
        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
        }

        // Sauvegarder les chambres mises à jour
        iChambreRepository.saveAll(chambres);

        // Mettre à jour le bloc avec les nouvelles chambres
        bloc.getChambres().addAll(chambres);
        return iBlocRepository.save(bloc);
    }
}


