package com.EnzoBonatoPersonal.MyLittleLibrary.exceptions;

public class GenreNotFoundException extends RuntimeException {
    public GenreNotFoundException(String genre) {
        super("Genre non trouvé : " + genre);
    }
}
