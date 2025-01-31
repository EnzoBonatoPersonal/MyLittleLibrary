package com.EnzoBonatoPersonal.MyLittleLibrary.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String title) {
        super("Livre non trouvé : " + title);
    }
}
