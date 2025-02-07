package com.EnzoBonatoPersonal.MyLittleLibrary.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String name) {
        super("Utilisateur non trouvé : " + name);
    }
}
