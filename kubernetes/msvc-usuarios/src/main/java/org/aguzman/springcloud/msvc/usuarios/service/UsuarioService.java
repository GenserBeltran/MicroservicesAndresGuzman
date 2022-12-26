package org.aguzman.springcloud.msvc.usuarios.service;

import org.aguzman.springcloud.msvc.usuarios.model.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> listar();

    Optional<Usuario> porId(Long id);

    Usuario guardar(Usuario usuario);

    void eliminar(Long id);

    Optional<Usuario> porEmail(String email);

    //Alternativa III
    boolean byEmailExists(String email);

    //listar todos los usuarios por id
    List<Usuario> listarPorIds(Iterable<Long> ids);
}
