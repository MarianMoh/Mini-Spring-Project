package org.example.hibernatetest.service;

import org.example.hibernatetest.model.Role;

import java.util.List;

public interface RoleService {
    Role readById(long id);

    List<Role> readByName(String name);

    Role create(Role role);

    Role update(Role role);

    void delete(long id);

    void deleteByUserId(long id);

    List<Role> getAll();
}
