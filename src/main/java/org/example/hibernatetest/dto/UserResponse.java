package org.example.hibernatetest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hibernatetest.model.Role;
import org.example.hibernatetest.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
    private long id;

    private String username;

    private String password;

    private String roles;

    public UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = user.getRoles().stream()
                .map(Role::getAuthority)
                .collect(Collectors.joining(" "));
    }
}
