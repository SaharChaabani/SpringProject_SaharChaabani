package tn.esprit.projetspring1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetspring1.Entities.Bloc;
import tn.esprit.projetspring1.Repository.IBlocRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class BlocService implements IBlocService{

    IBlocRepository iBlocRepository;
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
}
