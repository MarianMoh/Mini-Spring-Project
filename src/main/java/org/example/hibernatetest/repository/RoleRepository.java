package org.example.hibernatetest.repository;

import org.example.hibernatetest.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    void deleteRoleByUserId(long id);
}
