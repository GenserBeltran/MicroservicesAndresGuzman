package org.aguzman.springcloud.msvc.curso.service;

import org.aguzman.springcloud.msvc.curso.model.Usuario;
import org.aguzman.springcloud.msvc.curso.model.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> listar();

    Optional<Curso> porId(Long id);

    Curso guardar(Curso curso);

    void eliminar(Long id);

    //Metodos para administrar la data
    Optional<Usuario>asignarUsuario(Usuario usuario, Long cursoId);

    Optional<Usuario>crearUsuario(Usuario usuario, Long cursoId);

    Optional<Usuario>eliminarUsuario(Usuario usuario, Long cursoId);
    //Metodo para consultar todos los user por id
    Optional<Curso> porIdConUsuarios(Long id);

    //Metodo para eliminar por id el usuario
    void eliminarCursoUsuarioPorId(long id);
}
