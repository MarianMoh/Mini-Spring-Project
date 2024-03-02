package org.example.hibernatetest.controller;

import org.example.hibernatetest.model.Role;
import org.example.hibernatetest.model.User;
import org.example.hibernatetest.repository.RoleRepository;
import org.example.hibernatetest.service.RoleService;
import org.example.hibernatetest.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    private RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/info/{id}")
    public String showUsers(@PathVariable("id") long id, Model model) {
        User user = userService.readById(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "create-user";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user) {
        Role role = new Role("USER", user);
        user.setRoles(Collections.singletonList(role));
        userService.create(user);
        roleService.create(role);
        return "redirect:/home";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.readById(id));
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") long id) {
        user.setId(id);
        userService.update(user);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/home";
    }
}
