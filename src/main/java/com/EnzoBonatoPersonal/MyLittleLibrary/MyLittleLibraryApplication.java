package com.EnzoBonatoPersonal.MyLittleLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.EnzoBonatoPersonal.MyLittleLibrary")
public class MyLittleLibraryApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyLittleLibraryApplication.class, args);
    }
}
