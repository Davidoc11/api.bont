package com.naat.bontu.api.bontu.repository;

import com.naat.bontu.api.bontu.model.Credit;
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
public interface CreditRepository extends CrudRepository<Credit, Long> {

    @Query("from Credit where user_id=:userId")
    List<Credit> findByUserId(@Param("userId") String userId);

    @Query("from Credit where user_id=:userId and id=:id")
    Credit findByUserIdAndId(@Param("userId") String userId, @Param("id") Long id);

    @Query("from Credit where number=:id")
    Credit findByNumber(@Param("id") Long id);

    List<Credit> findAll();
}
