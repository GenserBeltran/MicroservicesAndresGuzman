package org.guzman.springcloud.msvc.usuarios.repository;

import org.guzman.springcloud.msvc.usuarios.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //Metodo para buscar por Email
    Optional<Usuario> findByEmail(String email);

    //Alternativa 2
    @Query("select u from Usuario u where u.email=?1")
    Optional<Usuario> buscaPorEmail(String email);

    //Alternativa 3
    boolean existsByEmail(String email);




}
