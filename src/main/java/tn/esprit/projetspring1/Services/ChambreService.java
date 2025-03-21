package tn.esprit.projetspring1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetspring1.Entities.Chambre;
import tn.esprit.projetspring1.Entities.TypeChambre;
import tn.esprit.projetspring1.Repository.IChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor


public class ChambreService implements IChambreService {

    IChambreRepository iChambreRepository;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return (List<Chambre>)iChambreRepository.findAll() ;
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return iChambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return iChambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return iChambreRepository.findById(idChambre).orElse(null);
    }
    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        return iChambreRepository.findChambresNonReservees(nomUniversite, type);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return iChambreRepository.findByBlocIdBlocAndTypeC(idBloc, typeC);
    }
}
