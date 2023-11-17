package es.maneldevs.qa.userservice.adapter.input.api.rest;

import org.springframework.web.bind.annotation.RestController;

import es.maneldevs.libs.exceptionhandling.NotFoundException;
import es.maneldevs.qa.userservice.adapter.input.api.UserApi;
import es.maneldevs.qa.userservice.application.model.response.UserResponse;

@RestController
public class UserController implements UserApi {

    @Override
    public UserResponse show(String username) {

        if(!"maneldevs".equals(username)) {
            throw new NotFoundException("user not found");
        }

        return UserResponse.builder()
                .username("maneldevs")
                .firstName("Manuel")
                .lastName("Máñez")
                .email("maneldevs@gmail.com").build();
    }

}
