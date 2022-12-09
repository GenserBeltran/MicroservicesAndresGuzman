package org.guzman.springcloud.msvc.usuarios.service;

import org.guzman.springcloud.msvc.usuarios.clients.CursoClienteRest;
import org.guzman.springcloud.msvc.usuarios.model.entity.Usuario;
import org.guzman.springcloud.msvc.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoClienteRest cursoClienteRest;

    @Override
    @Transactional
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Usuario> porId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
        cursoClienteRest.eliminarUsuarioporId(id);
    }

    //Alternativa I
//    @Override
//    public Optional<Usuario> porEmail(String email) {
//        return usuarioRepository.buscaPorEmail(email);
//    }

    //Alternaitva II
    @Override
    public Optional<Usuario> porEmail(String email) {
        return usuarioRepository.buscaPorEmail(email);
    }

    //Alternativa III
    @Override
    public boolean byEmailExists(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    //listar todos los usuarios por id
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarPorIds(Iterable<Long> ids) {
        return (List<Usuario>) usuarioRepository.findAllById(ids);
    }


}
