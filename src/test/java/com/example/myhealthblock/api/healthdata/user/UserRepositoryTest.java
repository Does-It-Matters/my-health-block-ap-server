package com.example.myhealthblock.api.healthdata.user;

import com.example.myhealthblock.user.adapter.out.persistence.UserEntity;
import com.example.myhealthblock.user.adapter.out.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveAndFindUser() {
        // Given
        UserEntity user = new UserEntity("user", "password", "PATIENT");

        // When
        userRepository.save(user);
        UserEntity foundUser = userRepository.findById(user.getId()).orElse(null);

        // Then
        assertNotNull(foundUser);
        assertEquals("user", foundUser.getId());
    }
}