package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import galerie.entity.Exposition;
import org.springframework.data.jpa.repository.Query;

// This will be AUTO IMPLEMENTED by Spring

public interface ExpositionRepository extends JpaRepository<Exposition, Integer> {


    @Query("select sum(v.prixVente) from Exposition e inner join e.ventes v where e.id = ?1")
    float chiffreAffairePour(Integer id);
}