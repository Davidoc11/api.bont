package com.naat.bontu.api.bontu.repository;

import com.naat.bontu.api.bontu.model.Movement;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository
public interface MovementRepository extends CrudRepository<Movement,Long>{
    
    @Query("from Movement where credit_id=:creditId")
    List<Movement> findByCreditId(@Param("creditId") Long creditId);
}
