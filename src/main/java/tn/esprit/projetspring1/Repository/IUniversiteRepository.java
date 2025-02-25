package tn.esprit.projetspring1.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetspring1.Entities.Universite;

@Repository

public interface IUniversiteRepository extends CrudRepository<Universite,Long>{
}
