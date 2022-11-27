package org.aguzman.springcloud.msvc.curso.service;

import org.aguzman.springcloud.msvc.curso.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> listar();

    Optional<Curso> porId(Long id);

    Curso guardar(Curso curso);

    void eliminar(Long id);
}
