package com.vamonos.springboot.backend.apirest.models.dao;

import com.vamonos.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

//Esto es DataJPA
public interface IClienteDao extends CrudRepository<Cliente, Long> { // <NombreClaseEntity, TipoDatoDelId>

}
