package com.domain.restapidemo.repository;

import com.domain.restapidemo.Authorities;
import com.domain.restapidemo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private final Map<String, Person> userStorage = new HashMap<>();
    {
        Person p = new Person();
        p.setPassword("1234");
        userStorage.put("@U12", p);
    }

    private boolean userHandle(String user, String pass){
        if (userStorage.containsKey(user)){
            final Person person = userStorage.get(user);
            if (person.getPassword().equals(pass)){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }


    public List<Authorities> getUserAuthorities(Person person) {
        return this.userHandle(person.getUser(), person.getPassword())? Arrays.asList(Authorities.values()) : null;
    }
}
