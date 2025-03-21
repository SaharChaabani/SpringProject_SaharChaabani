package tn.esprit.projetspring1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetspring1.Entities.Bloc;
import tn.esprit.projetspring1.Entities.Chambre;
import tn.esprit.projetspring1.Entities.TypeChambre;

import java.util.List;

@Repository
public interface IChambreRepository extends JpaRepository<Chambre,Long> {
    @Query("SELECT c FROM Chambre c WHERE c.bloc.foyer.universite.nomUniversite = :nomUniversite AND c.typeC = :type AND c.reservations IS EMPTY")
    List<Chambre> findChambresNonReservees(String nomUniversite, TypeChambre type);

    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> findChambresParBlocEtTypeJPQL(long idBloc, TypeChambre typeC);

    List<Chambre> findByBlocIdBlocAndTypeC(long idBloc, TypeChambre typeC);

    List<Chambre> findByNumeroChambreIn(List<Long> numChambres);
    public List<Chambre> findByBloc(Bloc bloc);

}
