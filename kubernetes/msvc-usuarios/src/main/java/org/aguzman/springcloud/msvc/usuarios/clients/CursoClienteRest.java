package org.aguzman.springcloud.msvc.usuarios.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msvc-curso", path = "/api/curso", url = "${msvc.curso.url}")
public interface CursoClienteRest {

    //Metodo para eliminar usuario LO QUE HACEMOS ES ELIMINAR LA RELACION desasignar el uysario del curso
    @DeleteMapping("/eliminar-curso-usuario/{id}")
    void eliminarUsuarioporId(@PathVariable Long id);
}
