package org.guzman.springcloud.msvc.usuarios.service;

import org.guzman.springcloud.msvc.usuarios.model.Usuario;
import org.guzman.springcloud.msvc.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> porId(Long id) {

        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario guardar(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

}
