package com.gathergrid.gathergridfeatures.repository.Test;


import com.gathergrid.gathergridfeatures.controller.methodes.RegistrationValidation;
import com.gathergrid.gathergridfeatures.domain.Comment;
import com.gathergrid.gathergridfeatures.domain.User;
import com.gathergrid.gathergridfeatures.repository.interfaces.CommentRepositry;
import com.gathergrid.gathergridfeatures.repository.interfacesImpl.CommentRepositryImpl;
import com.gathergrid.gathergridfeatures.service.UserService;

import java.util.List;
import java.util.Optional;

public class test {
    public static void main(String[] args) {
        UserService service =new UserService();
            String hashed = RegistrationValidation.hashPassword("1234");
            User newUser = new User("mohammed", "moussafia", "email@gmail.com", hashed);
            service.save(newUser);

    }
}
