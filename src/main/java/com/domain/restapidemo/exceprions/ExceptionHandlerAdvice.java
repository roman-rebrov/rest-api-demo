package com.domain.restapidemo.exceprions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {


    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandle(InvalidCredentials ex){
        System.out.println(ex.getMessage());
        return new ResponseEntity<>("User name or password is empty", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandle(UnauthorizedUser ex){
        System.out.println(ex.getMessage());
        return new ResponseEntity<>("Unknown user" , HttpStatus.UNAUTHORIZED);
    }
}
