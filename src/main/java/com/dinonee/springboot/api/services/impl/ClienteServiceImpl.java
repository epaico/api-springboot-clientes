package com.dinonee.springboot.api.services.impl;

import com.dinonee.springboot.api.exceptions.ResourceNotFoundException;
import com.dinonee.springboot.api.models.entities.Cliente;
import com.dinonee.springboot.api.models.request.ClienteNewDTO;
import com.dinonee.springboot.api.repositories.ClienteRepository;
import com.dinonee.springboot.api.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Transactional
    @Override
    public Cliente save(ClienteNewDTO clienteNewDTO) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteNewDTO.getNombre());
        cliente.setApellido(clienteNewDTO.getApellido());
        cliente.setEmail(clienteNewDTO.getEmail());

        return clienteRepository.save(cliente);
    }

    @Transactional
    @Override
    public Cliente upate(Cliente cliente) {
        Cliente clienteBD = clienteRepository.findById(cliente.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Registro no Encontrado"));

        clienteBD.setNombre(cliente.getNombre());
        clienteBD.setApellido(cliente.getApellido());
        clienteBD.setEmail(cliente.getEmail());

        return clienteRepository.save(clienteBD);

    }

    @Transactional
    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro no Encontrado"));
    }

    @Transactional
    @Override
    public void delete(Long idCliente) {
        Cliente clienteDelete = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new ResourceNotFoundException("Registro no Encontrado"));
        clienteRepository.deleteById(clienteDelete.getId());
    }
}
