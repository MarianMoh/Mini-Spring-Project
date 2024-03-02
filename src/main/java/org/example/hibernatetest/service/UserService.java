package org.example.hibernatetest.service;

import org.example.hibernatetest.model.User;

import java.util.List;

public interface UserService {
    User readById(long id);

    User create(User user);

    User update(User user);

    void delete(long id);

    List<User> getAll();
}
