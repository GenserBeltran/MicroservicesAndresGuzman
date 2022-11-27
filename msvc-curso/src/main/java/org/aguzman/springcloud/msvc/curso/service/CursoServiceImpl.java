package org.aguzman.springcloud.msvc.curso.service;

import org.aguzman.springcloud.msvc.curso.model.Curso;
import org.aguzman.springcloud.msvc.curso.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository CursoRepository;

    @Override
    public List<Curso> listar(){
        return CursoRepository.findAll();
    }

    @Override
    public Optional<Curso> porId(Long id){
        return CursoRepository.findById(id);
    }

    @Override
    public Curso guardar(Curso curso){
        return CursoRepository.save(curso);
    }

    @Override
    public void eliminar(Long id){
        CursoRepository.deleteById(id);
    }

}
