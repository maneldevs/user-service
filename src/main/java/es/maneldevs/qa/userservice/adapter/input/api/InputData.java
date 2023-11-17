package es.maneldevs.qa.userservice.adapter.input.api;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InputData { // BORRAR
    @NotNull String id;
}
