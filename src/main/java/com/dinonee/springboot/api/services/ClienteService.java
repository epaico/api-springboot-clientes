package com.dinonee.springboot.api.services;

import com.dinonee.springboot.api.models.entities.Cliente;
import com.dinonee.springboot.api.models.request.ClienteRequest;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();

    Cliente findById(Long id);

    Cliente save(ClienteRequest clienteNewDTO);

    Cliente upate(Cliente cliente);

    void delete(Long idCliente);


}
