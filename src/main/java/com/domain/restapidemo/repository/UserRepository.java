package com.domain.restapidemo.repository;

import com.domain.restapidemo.exceprions.InvalidCredentials;
import com.domain.restapidemo.exceprions.UnauthorizedUser;
import com.domain.restapidemo.model.Authorities;
import com.domain.restapidemo.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@Repository
public class UserRepository {
    private final Map<String, Person> userStorage = new HashMap<>();

    {
        Person p1 = new Person("@user1", "1234");
        Person p2 = new Person("@user2", "1234");
        Person p3 = new Person("@user3", "1234");
        p1.setAccesses(Authorities.READ);
        p1.setAccesses(Authorities.WRITE);
        p2.setAccesses(Authorities.READ);
        p2.setAccesses(Authorities.WRITE);
        p2.setAccesses(Authorities.DELETE);
        this.userStorage.put(p1.getUser(), p1);
        this.userStorage.put(p2.getUser(), p2);
        this.userStorage.put(p3.getUser(), p3);
    }

    @ExceptionHandler()
    public List<Authorities> getUserAuthorities(Person incPerson)throws InvalidCredentials, UnauthorizedUser {
        if (this.userStorage.containsKey(incPerson.getUser())) {
            Person person = this.userStorage.get(incPerson.getUser());

            final String username = person.getUser();
            if (username != null && username.equals(incPerson.getUser())){
                final String pass = person.getPassword();
                if (pass != null && pass.equals(incPerson.getPassword())){
                    return person.getAccesses();
                }else{
                    System.out.println("Incorrect name or password");
                    throw new InvalidCredentials("Incorrect name or password");
                }
            }else{
                System.out.println("Incorrect name or password");
                throw new InvalidCredentials("Incorrect name or password");
            }

        }else {
            return new ArrayList<>();
        }
    }

    @ExceptionHandler(InvalidCredentials.class)
    public String incorrectHandle(InvalidCredentials ex){
        return ex.getMessage();
    }
}
