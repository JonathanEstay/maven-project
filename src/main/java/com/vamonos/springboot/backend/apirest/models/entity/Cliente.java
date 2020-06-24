package com.vamonos.springboot.backend.apirest.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clientes") // Cuando la clase se llama igual que la tabla, no es necesaria esta anotacion
public class Cliente implements Serializable {

    // Es requerido cuando se implementa Serializable
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrementa
    private Long id;

    //@Column(name = "nombre") // Cuando el atributo se llama igual que el nombre del campo, no es necesaria esta anotacion
    private String nombre;

    private String apellido;
    private String email;

    //@Temporal(TemporalType.TIME)
    //@Temporal(TemporalType.TIMESTAMP)
    @Temporal(TemporalType.DATE) // Solo para las fechas
    @Column(name = "create_at")
    private Date createAt;


    @PrePersist // Se ejecuta antes de que se haga un "save" o "persist"
    public void prePersist() {
        this.createAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
