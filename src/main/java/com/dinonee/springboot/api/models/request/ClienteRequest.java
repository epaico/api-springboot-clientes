package com.dinonee.springboot.api.models.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class ClienteRequest {
    @NotEmpty(message = "no puede ser vacio")
    private String nombre;
    private String apellido;
    @NotEmpty(message = "no puede ser vacio")
    @Email(message = "debe ser una direccion de correo valida")
    private String email;
}
