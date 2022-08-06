package com.dinonee.springboot.api.controllers;

import com.dinonee.springboot.api.models.entities.Cliente;
import com.dinonee.springboot.api.models.request.ClienteRequest;
import com.dinonee.springboot.api.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody @Validated ClienteRequest clienteNewDTO) {
        Cliente clienteNuevo = clienteService.save(clienteNewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteNuevo);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Cliente cliente) {
        Cliente clienteUpdate = clienteService.upate(cliente);
        return new ResponseEntity<>(clienteUpdate, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllClientes() {
        List<Cliente> clientes = clienteService.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<?> findClienteById(@PathVariable("idCliente") Long idCliente) {
        Cliente cliente = clienteService.findById(idCliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idCliente}")
    public ResponseEntity<?> delete(@PathVariable Long idCliente) {

        clienteService.delete(idCliente);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Registro eliminado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
