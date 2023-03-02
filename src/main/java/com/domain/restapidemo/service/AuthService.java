package com.domain.restapidemo.service;

import com.domain.restapidemo.model.Authorities;
import com.domain.restapidemo.exceprions.InvalidCredentials;
import com.domain.restapidemo.exceprions.UnauthorizedUser;
import com.domain.restapidemo.model.Person;
import com.domain.restapidemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    public UserRepository repository;

    public AuthService(UserRepository repo){
        this.repository = repo;
    }


    public List<Authorities> getAuthorities(Person person) throws InvalidCredentials, UnauthorizedUser {
        if(this.isEmpty(person.getUser()) || this.isEmpty(person.getPassword())){
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = this.repository.getUserAuthorities(person.getUser(), person.getPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user" + person.getUser());
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> list){
        return  list == null || list.isEmpty();
    }
    private boolean isEmpty(String str){
        return str == null || str.isEmpty();
    }
}
