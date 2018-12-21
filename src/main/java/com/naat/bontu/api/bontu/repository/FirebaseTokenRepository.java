package com.naat.bontu.api.bontu.repository;

import com.naat.bontu.api.bontu.model.FirebaseToken;
import com.naat.bontu.api.bontu.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface FirebaseTokenRepository extends CrudRepository<FirebaseToken,Long> {

    FirebaseToken findByToken(String token);

    FirebaseToken findByUser(User user);

    List<FirebaseToken> findAll();
    Long countByToken(String token);

    @Transactional
    @Modifying
    @Query("update FirebaseToken u set u.token= ?1 where u.number= ?2")
    int setTokenByID(String newToken,Long number);
}
