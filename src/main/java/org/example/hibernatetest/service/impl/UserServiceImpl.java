package org.example.hibernatetest.service.impl;

import org.example.hibernatetest.model.User;
import org.example.hibernatetest.repository.UserRepository;
import org.example.hibernatetest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

//import static org.springframework.security.core.userdetails.User.withUsername;


@Service
public class UserServiceImpl implements UserService { //, UserDetailsService {
    private final static String ENTITY_NOT_FOUND = "User wasn't found by id %s";

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User readById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(ENTITY_NOT_FOUND, id)));
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        readById(user.getId());
        return userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(readById(id));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        User user = getAll().stream()
//                .filter(u -> u.getUsername().equals(username))
//                .findFirst().orElse(null);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found!");
//        }
//        return user;
//    }


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found!");
//        }
//
//        UserBuilder userBuilder = org.springframework.security.core.userdetails.User.withUsername(username);
//        userBuilder.password(user.getPassword());
//        userBuilder.roles(String.valueOf(user.getRoles()));
//
//        return userBuilder.build();
//    }
}
