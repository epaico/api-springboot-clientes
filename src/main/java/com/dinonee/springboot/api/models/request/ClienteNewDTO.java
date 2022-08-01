package com.dinonee.springboot.api.models.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class ClienteNewDTO {
    @NotEmpty(message = "Nombre no puede ser vacio")
    private String nombre;
    private String apellido;
    @NotEmpty(message = "Email no puede ser vacio")
    @Email
    private String email;
}
