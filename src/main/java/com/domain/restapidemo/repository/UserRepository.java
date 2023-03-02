package com.domain.restapidemo.repository;

import com.domain.restapidemo.exceprions.InvalidCredentials;
import com.domain.restapidemo.exceprions.UnauthorizedUser;
import com.domain.restapidemo.model.Authorities;
import com.domain.restapidemo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private final List<Person> userStorage = new ArrayList<>();


    {
        Person p1 = new Person("user", "1234", List.of(Authorities.READ, Authorities.WRITE));
        Person p2 = new Person("admin", "4567", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        Person p3 = new Person("@user3", "1234", new ArrayList<>());

        this.userStorage.add(p1);
        this.userStorage.add(p2);
        this.userStorage.add(p3);
    }

    public List<Authorities> getUserAuthorities(String username, String pass) throws InvalidCredentials, UnauthorizedUser {
        for (Person person : this.userStorage) {
            if (person.getUser().equals(username)) {
                if (person.getPassword().equals(pass)) {
                    return person.getAccesses();
                }
            }
        }
        return new ArrayList<>();
    }

}
