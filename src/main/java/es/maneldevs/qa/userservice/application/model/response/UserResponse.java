package es.maneldevs.qa.userservice.application.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class UserResponse {
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String email;
}
