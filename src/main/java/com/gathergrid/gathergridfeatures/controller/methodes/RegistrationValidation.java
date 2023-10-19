package com.gathergrid.gathergridfeatures.controller.methodes;



import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class RegistrationValidation {
    public static  List<String> registreValidation(String firstName ,String lastName , String email , String password){
        // Validate the data
        List<String> validationErrors = new ArrayList<>();

        if (firstName == null || firstName.isBlank()) {
            validationErrors.add("First name is required.");
        }

        if (lastName == null || lastName.isBlank()) {
            validationErrors.add("Last name is required.");
        }

        if (email == null || email.isBlank()) {
            validationErrors.add("Email is required.");
        }

        if (password == null || password.isBlank()) {
            validationErrors.add("Password is required.");
        }

        // Check email format
        if (email != null && !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            validationErrors.add("Invalid email format.");
        }

        return validationErrors;
    }

    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }
}

