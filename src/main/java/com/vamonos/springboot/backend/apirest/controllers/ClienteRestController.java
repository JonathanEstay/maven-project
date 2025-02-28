package com.vamonos.springboot.backend.apirest.controllers;

import com.vamonos.springboot.backend.apirest.models.entity.Cliente;
import com.vamonos.springboot.backend.apirest.models.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"}, methods = {RequestMethod.GET}) // Esto es un "CORS"
@RestController
@RequestMapping("/api")
public class ClienteRestController {

    @Autowired
    private IClienteService clienteService;


    @GetMapping("/clientes")
    public List<Cliente> index() {
        return clienteService.findAll();
    }


    @GetMapping("/clientes/{id}")
    public Cliente show(@PathVariable Long id) {
        return clienteService.findById(id);
    }


    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED) // 201
    public Cliente create(@RequestBody Cliente cliente) { // @RequestBody se usa para recibir el JSON
        // cliente.setCreateAt(new Date());
        return clienteService.save(cliente);
    }


    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED) // 201
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente clienteActual = clienteService.findById(id);

        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setApellido(cliente.getApellido());
        clienteActual.setEmail(cliente.getEmail());

        return clienteService.save(clienteActual);
    }


    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void delete(@PathVariable Long id) {
        clienteService.delete(id);
    }
}
