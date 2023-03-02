package com.domain.restapidemo.controllers;

import com.domain.restapidemo.model.Authorities;
import com.domain.restapidemo.model.Person;
import com.domain.restapidemo.service.AuthService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/")
public class AuthController {

    private AuthService service;

    public AuthController(AuthService s){
        this.service = s;
    }

    @GetMapping("authorize")
    public List<Authorities> getAuthorities(Person person){
        return service.getAuthorities(person);
    }


}
