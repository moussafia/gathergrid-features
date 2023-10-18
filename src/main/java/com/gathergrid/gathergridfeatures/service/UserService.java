package com.gathergrid.gathergridfeatures.service;

import com.gathergrid.gathergridfeatures.domain.User;
import com.gathergrid.gathergridfeatures.repository.interfacesImpl.UserRepository;
import com.gathergrid.gathergridfeatures.repository.interfacesImpl.crudRepository;

import java.util.Optional;

public class UserService {
    private final UserRepository<User> userRepository;

    public UserService() {
        userRepository = new UserRepository<User>();
    }

    public Optional<User> save(User user){
        Optional<User> byEmail = userRepository.findByEmail(user);
        if (byEmail.isEmpty()) {
            userRepository.save(user);
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }

}

