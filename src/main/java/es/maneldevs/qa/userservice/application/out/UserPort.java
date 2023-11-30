package es.maneldevs.qa.userservice.application.out;

import java.util.Optional;

import es.maneldevs.qa.userservice.domain.User;

public interface UserPort {
    Optional<User> findByUsername(String username);
}
