package com.gathergrid.gathergridfeatures.repository.interfaces;

import com.gathergrid.gathergridfeatures.domain.Event;
import com.gathergrid.gathergridfeatures.domain.User;

import java.util.List;

public interface UserRepository {
    public User save(User user);
    public void delete(long id);
    public void update(User user);
    public User find(long id);
    public List<User> findAll();
}
