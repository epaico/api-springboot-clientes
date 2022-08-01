package com.dinonee.springboot.api.repositories;

import com.dinonee.springboot.api.models.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente,Long> {
}
