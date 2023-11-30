package es.maneldevs.qa.userservice.application.in.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import es.maneldevs.libs.exceptionhandling.NotFoundException;
import es.maneldevs.qa.userservice.application.model.response.UserResponse;
import es.maneldevs.qa.userservice.application.out.UserPort;
import es.maneldevs.qa.userservice.domain.User;

@ExtendWith(value = MockitoExtension.class)
public class UserQueryServiceTest {
    private User user;
    private UserResponse userResponse;
    @Mock
    private UserPort userPort;
    @InjectMocks
    private UserQueryService serviceUnderTest;

    @BeforeEach
    void beforeEach() {
        user = User.builder()
                .id(1L)
                .version(0)
                .username("username")
                .firstName("firstname")
                .lastName("lastname")
                .email("email@email.com").build();
        userResponse = UserResponse.builder()
                .username("username")
                .firstName("firstname")
                .lastName("lastname")
                .email("email@email.com").build();
    }

    @Test
    void getUser_existentUsername_userResponse() {
        when(userPort.findByUsername(user.getUsername())).thenReturn(Optional.of(user));
        UserResponse response = serviceUnderTest.getUser(user.getUsername());
        assertEquals(userResponse, response);
    }

    @Test
    void getUser_nonExistentUsername_NotFoundException() {
        when(userPort.findByUsername(anyString())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> serviceUnderTest.getUser("nonexistentuser"));
    }
}
