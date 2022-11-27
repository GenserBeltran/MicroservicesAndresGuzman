package org.guzman.springcloud.msvc.usuarios.service;

import org.guzman.springcloud.msvc.usuarios.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> listar();

    Optional<Usuario> porId(Long id);

    Usuario guardar(Usuario usuario);

    void eliminar(Long id);
}
