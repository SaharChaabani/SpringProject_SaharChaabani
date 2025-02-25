package tn.esprit.projetspring1.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetspring1.Entities.Etudiant;

@Repository

public interface IEtudiantRepository extends CrudRepository<Etudiant,Long> {
}
