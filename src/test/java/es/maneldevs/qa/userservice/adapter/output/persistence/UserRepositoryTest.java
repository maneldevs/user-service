package es.maneldevs.qa.userservice.adapter.output.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import es.maneldevs.qa.userservice.MysqlTestBase;
import es.maneldevs.qa.userservice.domain.User;

public class UserRepositoryTest extends MysqlTestBase {
    private User savedUser;
    @Autowired
    private TestEntityManager em;
    @Autowired
    private UserRepository repositoryUnderTest;

    @BeforeEach
    void beforeEach() {
        User user = User.builder()
                .username("username")
                .firstName("firstName")
                .lastName("lastName")
                .email("email@email.com").build();
        savedUser = em.persist(user);
    }

    @Test
    void findByUsername_existentUsername_user() {
        Optional<User> result = repositoryUnderTest.findByUsername("username");
        assertTrue(result.isPresent());
        assertEquals(savedUser, result.get());
    }

    @Test
    void findByUsername_nonExistentUsername_optional_Empty() {
        Optional<User> result = repositoryUnderTest.findByUsername("nonexistent");
        assertTrue(result.isEmpty());
    }

}
