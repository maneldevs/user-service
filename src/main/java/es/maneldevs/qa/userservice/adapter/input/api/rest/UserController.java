package es.maneldevs.qa.userservice.adapter.input.api.rest;

import org.springframework.web.bind.annotation.RestController;

import es.maneldevs.qa.userservice.adapter.input.api.UserApi;
import es.maneldevs.qa.userservice.application.in.UserQueryUseCase;
import es.maneldevs.qa.userservice.application.model.response.UserResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final UserQueryUseCase userQueryUseCase;

    @Override
    public UserResponse show(String username) {
        return userQueryUseCase.getUser(username);
    }

}
