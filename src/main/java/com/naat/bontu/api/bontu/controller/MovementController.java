package com.naat.bontu.api.bontu.controller;

import com.naat.bontu.api.bontu.model.CreditDetailResponse;
import com.naat.bontu.api.bontu.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author David
 */
@RestController
public class MovementController {

    @Autowired
    private MovementRepository movementRepository;
    
    
    @GetMapping(value = "/movement/{creditId}")
    public CreditDetailResponse getMovementsByCredit(@PathVariable Long creditId) {
        return new CreditDetailResponse(movementRepository.findByCreditId(creditId));
    }
}
