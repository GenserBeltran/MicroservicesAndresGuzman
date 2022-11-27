package org.aguzman.springcloud.msvc.curso.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 250, nullable = false)
    private String nombre;



}
