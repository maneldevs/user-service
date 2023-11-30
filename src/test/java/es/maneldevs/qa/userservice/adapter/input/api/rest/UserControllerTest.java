package es.maneldevs.qa.userservice.adapter.input.api.rest;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import es.maneldevs.libs.exceptionhandling.NotFoundException;
import es.maneldevs.qa.userservice.application.in.UserQueryUseCase;
import es.maneldevs.qa.userservice.application.model.response.UserResponse;

@WebFluxTest(controllers = UserController.class)
public class UserControllerTest {
    private UserResponse userResponse;
    @MockBean
    private UserQueryUseCase userQueryService;
    @Autowired
    private WebTestClient webClient;

    @BeforeEach
    void beforeEach() {
        userResponse = UserResponse.builder()
                .username("maneldevs")
                .firstName("Manuel")
                .lastName("Máñez")
                .email("maneldevs@gmail.com").build();
    }

    @Test
    void show_existentUsername_ok() {
        when(userQueryService.getUser(userResponse.getUsername())).thenReturn(userResponse);
        webClient
                .get()
                .uri("/users/" + userResponse.getUsername())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.username").isEqualTo(userResponse.getUsername())
                .jsonPath("$.firstName").isEqualTo(userResponse.getFirstName())
                .jsonPath("$.lastName").isEqualTo(userResponse.getLastName())
                .jsonPath("$.email").isEqualTo(userResponse.getEmail());
    }

    @Test
    void show_inexistentUsername_notFound() {
        String nonExistentUsername = "nonexistentuser";
        String path = "/users/" + nonExistentUsername;
        when(userQueryService.getUser(nonExistentUsername)).thenThrow(new NotFoundException("User not found with username: " + nonExistentUsername));
        webClient
                .get()
                .uri(path)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody()
                .jsonPath("$.path").isEqualTo(path)
                .jsonPath("$.message").isEqualTo("User not found with username: " + nonExistentUsername);
    }
}
