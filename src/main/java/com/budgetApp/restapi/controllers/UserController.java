package com.budgetApp.restapi.controllers;

import com.budgetApp.restapi.model.RegisterRequest;
import com.budgetApp.restapi.model.User;
import com.budgetApp.restapi.repositories.UserRepository;
import com.budgetApp.restapi.services.UserService;
import com.budgetApp.restapi.model.ChangePasswordRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService service;



    @PatchMapping
    public ResponseEntity<?> changePassword(
          @RequestBody ChangePasswordRequest request,
          Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{id}")
    public Optional<User> getId(@PathVariable("id") Integer id){
        System.out.println("ovdjeeee " + id);
        return service.findNameid(id);
    }
    @GetMapping("/getAlal")
    public List<User> getAlla() {
        return service.find();
    }



}
