package org.aguzman.springcloud.msvc.curso.clients;

import org.aguzman.springcloud.msvc.curso.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(name = "msvc-usuarios", path = "/api/usuario", url = "msvc-usuarios:8000")
public interface UsuarioClientRest {

    @GetMapping("/{id}")
    Usuario detalle(@PathVariable Long id);

    @PostMapping
    Usuario crear(@RequestBody Usuario usuario);

    //Muestra los usuarios por ids
    @GetMapping("/usuarios-por-cursos")
    List<Usuario> obtenerAlumnosPorCurso(@RequestParam Iterable<Long> ids);
}
