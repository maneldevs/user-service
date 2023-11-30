package es.maneldevs.qa.userservice.adapter.output.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import es.maneldevs.qa.userservice.application.out.UserPort;
import es.maneldevs.qa.userservice.domain.User;

public interface UserRepository extends UserPort, JpaRepository<User, Long> {
}
