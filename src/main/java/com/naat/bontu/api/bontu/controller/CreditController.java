package com.naat.bontu.api.bontu.controller;

import com.naat.bontu.api.bontu.model.CreditDetailResponse;
import com.naat.bontu.api.bontu.model.CreditsResponse;
import com.naat.bontu.api.bontu.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author David
 */
@RestController

public class CreditController {

    @Autowired
    private CreditRepository creditRepository;

    @GetMapping(name = "123", value = "/credits/{id}")
    public CreditsResponse getCreditsByID(@PathVariable String id) throws InterruptedException {
        return new CreditsResponse(creditRepository.findByUserId(id));

    }

    @GetMapping(value = {"/credits", "/credits/"})
    public CreditsResponse getCredits() {
        return new CreditsResponse(creditRepository.findAll());
    }

    @GetMapping("/credits/{id}/movements")
    public CreditDetailResponse getCreditMovements(@PathVariable(name = "id") Long id   ) {
        return new CreditDetailResponse(creditRepository.findByNumber(id).getMovements());
    }
    
    
    @GetMapping(value = "/searchUser", params = "userID")
    public String searchUserById(@RequestParam long userID) {
        return "1";
    }

}
