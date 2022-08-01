package com.dinonee.springboot.api.services;

import com.dinonee.springboot.api.models.entities.Cliente;
import com.dinonee.springboot.api.models.request.ClienteNewDTO;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();

    Cliente findById(Long id);

    Cliente save(ClienteNewDTO clienteNewDTO);

    Cliente upate(Cliente cliente);

    void delete(Long idCliente);


}
