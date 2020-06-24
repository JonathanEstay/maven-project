package com.vamonos.springboot.backend.apirest.models.service;

import com.vamonos.springboot.backend.apirest.models.entity.Cliente;

import java.util.List;

public interface IClienteService { // Esta interface es nuestro CONTRATO

    // Los metodos serian nuestro CONTRATO de implementacion
    public List<Cliente> findAll();

    public Cliente findById(Long id);

    public Cliente save(Cliente cliente);

    public void delete(Long id);
}
