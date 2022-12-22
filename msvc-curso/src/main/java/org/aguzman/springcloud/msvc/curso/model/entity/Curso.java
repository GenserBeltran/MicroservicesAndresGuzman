package org.aguzman.springcloud.msvc.curso.model.entity;

import lombok.Data;
import org.aguzman.springcloud.msvc.curso.model.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "nombre", length = 250, nullable = false)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "curso_id")
    private List<CursoUsuario> cursoUsuarios;

    @Transient
    private List<Usuario> usuarios;

    public Curso() {
        cursoUsuarios = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    //Metodos para agregar o quitar cursoUsuario
    public void addCursoUsuario(CursoUsuario cursoUsuario) {
        cursoUsuarios.add(cursoUsuario);
    }

    public void removeCursoUsuario(CursoUsuario cursoUsuario) {
        cursoUsuarios.remove(cursoUsuario);
    }



}
