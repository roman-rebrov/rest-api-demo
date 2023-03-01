package com.domain.restapidemo.exceprions;

public class UnauthorizedUser extends RuntimeException{
    public UnauthorizedUser(String message){
        super(message);
    }
}
