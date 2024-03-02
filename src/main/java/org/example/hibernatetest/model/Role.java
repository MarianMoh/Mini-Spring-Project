package org.example.hibernatetest.model;

//import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role { //implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(nullable = false)
    private String authority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    public Role(String authority, User user) {
        this.authority = authority;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //@Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id && Objects.equals(authority, role.authority) && Objects.equals(user, role.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authority, user);
    }

    @Override
    public String toString() {
        return "\nid: " + id
                + "\nauthority: " + authority
                + "\nusers: " + user;
    }
}
