package es.maneldevs.qa.userservice.application.in.service;

import org.springframework.stereotype.Service;

import es.maneldevs.libs.exceptionhandling.NotFoundException;
import es.maneldevs.qa.userservice.application.in.UserQueryUseCase;
import es.maneldevs.qa.userservice.application.model.response.UserResponse;
import es.maneldevs.qa.userservice.application.out.UserPort;
import es.maneldevs.qa.userservice.domain.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserQueryService implements UserQueryUseCase {
    private final UserPort userPort;

    @Override
    public UserResponse getUser(String username) {
        User user = userPort.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found with username: " + username));
        return new UserResponse(user);
    }
    
}
