package es.maneldevs.qa.userservice.adapter.input.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.maneldevs.qa.userservice.application.model.response.UserResponse;

@RequestMapping("users")
public interface UserApi {

    @GetMapping("{username}")
    UserResponse show(@PathVariable String username);
    
}
