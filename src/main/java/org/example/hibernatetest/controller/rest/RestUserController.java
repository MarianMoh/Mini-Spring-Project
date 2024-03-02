package org.example.hibernatetest.controller.rest;

import lombok.Getter;
import org.example.hibernatetest.dto.UserRequest;
import org.example.hibernatetest.dto.UserResponse;
import org.example.hibernatetest.model.Role;
import org.example.hibernatetest.model.User;
import org.example.hibernatetest.service.RoleService;
import org.example.hibernatetest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class RestUserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable("id") long id) {
        return new UserResponse(userService.readById(id));
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        User user = User.of(userRequest);
        return new UserResponse(userService.create(user));
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable("id") long id,
                                   @RequestBody UserRequest userRequest) {
        User user = User.of(userRequest);
        user.setId(id);
        return new UserResponse(userService.update(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
    }
}
