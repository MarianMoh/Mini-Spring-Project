package org.example.hibernatetest.service.impl;

import org.example.hibernatetest.model.Role;
import org.example.hibernatetest.repository.RoleRepository;
import org.example.hibernatetest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private final static String ENTITY_NOT_FOUND = "Role wasn't found by id %s";

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role readById(long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(ENTITY_NOT_FOUND, id)));
    }

    @Override
    public List<Role> readByName(String name) {
        return roleRepository.findAll().stream()
                .filter(role -> Objects.equals(role.getAuthority(), name))
                .collect(Collectors.toList());
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        readById(role.getId());
        return roleRepository.save(role);
    }

    @Override
    public void delete(long id) {
        roleRepository.delete(readById(id));
    }

    @Override
    public void deleteByUserId(long id) {
        roleRepository.deleteRoleByUserId(id);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
