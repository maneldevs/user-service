package es.maneldevs.qa.userservice.adapter.input.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.maneldevs.libs.exceptionhandling.ValidationException;
import jakarta.validation.Valid;

@RestController
public class TestCotroller { // BORRAR
    
    @GetMapping
    String test(@Valid InputData input) {
        //throw new NotFoundException("holaaa");
        Map<String, String> errors = new HashMap<>();
        errors.put("id", "no puede ser nulo");
        errors.put("name", "no puede ser nulo");
        throw new ValidationException(errors);
    }
}
