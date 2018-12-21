package com.naat.bontu.api.bontu.controller;

import com.naat.bontu.api.bontu.model.User;
import com.naat.bontu.api.bontu.model.VerifyUserResponse;
import com.naat.bontu.api.bontu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author David
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRpository;
    
    
    
    @GetMapping(value = {"/user",""})
    public Iterable<User> getUsers(){
        return userRpository.findAll();
    }
    
   @GetMapping(value = "/user/verify/{id}")
    public VerifyUserResponse getUserByID(@PathVariable String id){
        return new VerifyUserResponse(userRpository.findById(id).isPresent());
    }
}
