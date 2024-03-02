package org.example.hibernatetest.service;

import org.example.hibernatetest.model.Role;
import org.example.hibernatetest.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@Transactional
@SpringBootTest
public class UserServiceTests {
    private UserService userService;

    private User user;

    @Autowired
    public UserServiceTests(UserService userService) {
        this.userService = userService;
        user = new User();
    }

    @BeforeEach
    public void beforeEach() {
        user.setId(5);
        user.setUsername("Nick");
        user.setPassword("1111");
    }

    @Test
    public void getAllUsers() {
        int expectedNumber = 3;
        int receivedNumber = userService.getAll().size();
        Assertions.assertEquals(expectedNumber, receivedNumber);
    }

    @Test
    public void createUser() {
        User tempUser = new User("Marian", "54321");
        User receivedUser = userService.create(tempUser);
        Assertions.assertEquals(receivedUser.getUsername(), tempUser.getUsername());
        Assertions.assertEquals(receivedUser.getPassword(), tempUser.getPassword());
    }

    @Test
    public void readUserById() {
        User receivedUser = userService.readById(user.getId());
        Assertions.assertEquals(receivedUser, user);
    }

    @Test
    public void readUserByIdError() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> userService.readById(1000));
    }

    @Test
    public void updateUser() {
        String newName = "Noname";
        user.setUsername(newName);
        userService.update(user);

        String receivedName = userService.readById(user.getId()).getUsername();
        Assertions.assertEquals(receivedName, newName);
    }

    @Test
    public void deleteUser() {
        int expectedNumber = userService.getAll().size() - 1;
        userService.delete(user.getId());
        int receivedNumber = userService.getAll().size();
        Assertions.assertEquals(expectedNumber, receivedNumber);
    }

    @Test
    public void deleteUserError() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> userService.delete(1000));
    }
}
