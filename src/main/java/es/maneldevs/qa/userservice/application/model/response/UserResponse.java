package es.maneldevs.qa.userservice.application.model.response;

import es.maneldevs.qa.userservice.domain.User;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@Builder
public class UserResponse {
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String email;

    public UserResponse(User user) {
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }
}
