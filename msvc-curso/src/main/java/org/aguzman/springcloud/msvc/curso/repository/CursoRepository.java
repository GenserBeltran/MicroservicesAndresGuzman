package org.aguzman.springcloud.msvc.curso.repository;

import org.aguzman.springcloud.msvc.curso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
