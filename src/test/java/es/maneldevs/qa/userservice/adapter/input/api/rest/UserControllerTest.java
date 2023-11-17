package es.maneldevs.qa.userservice.adapter.input.api.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import es.maneldevs.qa.userservice.application.model.response.UserResponse;

@WebFluxTest(controllers = UserController.class)
public class UserControllerTest {
    private static final String USERNAME_INEXISTENT = "another";
    private static final String NOT_FOUND_ERROR_MESSAGE = "user not found";
    private static final UserResponse USER_EXISTENT = UserResponse.builder()
            .username("maneldevs")
            .firstName("Manuel")
            .lastName("Máñez")
            .email("maneldevs@gmail.com").build();

    @Autowired
    WebTestClient webClient;

    @Test
    void show_existentUsername_ok() {
        webClient
                .get()
                .uri("/users/" + USER_EXISTENT.getUsername())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.username").isEqualTo(USER_EXISTENT.getUsername())
                .jsonPath("$.firstName").isEqualTo(USER_EXISTENT.getFirstName())
                .jsonPath("$.lastName").isEqualTo(USER_EXISTENT.getLastName())
                .jsonPath("$.email").isEqualTo(USER_EXISTENT.getEmail());
    }

    @Test
    void show_inexistentUsername_notFound() {
        webClient
                .get()
                .uri("/users/" + USERNAME_INEXISTENT)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody()
                .jsonPath("$.path").isEqualTo("/users/" + USERNAME_INEXISTENT)
                .jsonPath("$.message").isEqualTo(NOT_FOUND_ERROR_MESSAGE);
    }
}
