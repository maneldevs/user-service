package es.maneldevs.qa.userservice.application.in;

import es.maneldevs.qa.userservice.application.model.response.UserResponse;

public interface UserQueryUseCase {
    UserResponse getUser(String username);
}
