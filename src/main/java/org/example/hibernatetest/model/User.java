package org.example.hibernatetest.model;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import org.example.hibernatetest.dto.UserRequest;
import org.hibernate.mapping.Array;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User { //implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z-]{2,20}$")
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;

    public User() {
        roles = new ArrayList<>();
    }

    public User(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, List<Role> roles) {
        this();
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (Role role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
//        }
//        return authorities;
//    }

    ///@Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //@Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //@Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //@Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username)
                && Objects.equals(password, user.password)
                && Objects.equals(roles, user.roles)
                && Objects.equals(tasks, user.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, roles, tasks);
    }

    @Override
    public String toString() {
        return "\nid: " + id
                + "\nusername: " + username
                + "\npassword: " + password
                + "\nroles: " + roles;
    }

    public static User of(UserRequest userRequest) {
//        List<Role> roles = Arrays.stream(userRequest.getRoles().split(" "))
//                .map(Role::new)
//                .collect(Collectors.toList());
        User user = new User(userRequest.getUsername(), userRequest.getPassword());
        Role role = new Role(userRequest.getRoles(), user);
        user.setRoles(Collections.singletonList(role));
        return user;
    }

    public static User of(UserRequest userRequest, long id) {
//        List<Role> roles = Arrays.stream(userRequest.getRoles().split(" "))
//                .map(Role::new)
//                .collect(Collectors.toList());
        User user = new User(userRequest.getUsername(), userRequest.getPassword());
        user.setId(id);
        Role role = new Role(userRequest.getRoles(), user);
        user.setRoles(Collections.singletonList(role));
        return user;
    }
}
