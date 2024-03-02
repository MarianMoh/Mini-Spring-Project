package org.example.hibernatetest.repository;

import org.example.hibernatetest.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;


}


//@ExtendWith(SpringExtension.class)
//@ActiveProfiles("test")
//@Transactional
//@SpringBootTest
//public class UserRepositoryTests {
//    private UserRepository userRepository;
//
//    private User user;
//
//    @Autowired
//    public UserRepositoryTests(UserRepository userRepository) {
//        this.userRepository = userRepository;
//        user = new User();
//    }
//
//    @BeforeEach
//    public void beforeEach() {
//        user.setId(5);
//        user.setName("Nick");
//        user.setPassword(1111);
//    }
//
//    @Test
//    public void findByName() {
//        User receivedUser = userRepository.findByName("Nick");
//        Assertions.assertEquals(receivedUser, user);
//    }
//
//    @Test
//    public void findByTasksName() {
//        User receivedUser = userRepository.findByTasksName("Task #2");
//        Assertions.assertEquals(receivedUser, user);
//    }
//}
