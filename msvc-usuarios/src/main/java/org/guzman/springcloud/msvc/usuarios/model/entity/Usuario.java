package org.guzman.springcloud.msvc.usuarios.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El campo Nombre no puede estar vacio") //No puede llegar vacio
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotEmpty
    @Email
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @NotEmpty
    @Column(name = "password", nullable = false, length = 100)
    private String password;

}
