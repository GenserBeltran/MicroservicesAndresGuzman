package org.guzman.springcloud.msvc.usuarios.controller;

import org.guzman.springcloud.msvc.usuarios.model.Usuario;
import org.guzman.springcloud.msvc.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(usuarioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.porId(id));
    }

//    Alternativa I & II
//    @PostMapping
//    public ResponseEntity<?> crear(@Valid @RequestBody Usuario usuario, BindingResult result) {
//
//        if ( !usuario.getEmail().isEmpty() && usuarioService.porEmail(usuario.getEmail()).isPresent()) {
//            return ResponseEntity.badRequest().body(Collections.singletonMap("mensaje", "Ya existe un usuario con ese email"));
//        }
//
//        if (result.hasErrors()) {
//            return validar(result);
//        }
//        return new ResponseEntity<>(usuarioService.guardar(usuario), HttpStatus.CREATED);
//    }

    //Alternativa III
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Usuario usuario, BindingResult result) {

        if (result.hasErrors()) {
            return validar(result);
        }
        if (!usuario.getEmail().isEmpty() &&
                usuarioService.byEmailExists(usuario.getEmail())) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("mensaje", "Ya existe un usuario con ese email"));
        }
        return new ResponseEntity<>(usuarioService.guardar(usuario), HttpStatus.CREATED);
    }

    //Alternativa I & II
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Usuario usuario, BindingResult result, @PathVariable Long id) {


        if (result.hasErrors()) {
            return validar(result);
        }

        Optional<Usuario> o = usuarioService.porId(id);
        if (o.isPresent()) {
            Usuario usuarioDb = o.get();

            if (!usuario.getEmail().isEmpty() &&
                    !usuario.getEmail().equalsIgnoreCase(usuarioDb.getEmail()) &&
                    usuarioService.porEmail(usuario.getEmail()).isPresent()) {
                return ResponseEntity.badRequest().body(Collections.singletonMap("mensaje", "Ya existe un usuario con ese email"));
            }

            usuarioDb.setNombre(usuario.getNombre());
            usuarioDb.setEmail(usuario.getEmail());
            usuarioDb.setPassword(usuario.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(usuarioDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Usuario> o = usuarioService.porId(id);
        if (o.isPresent()) {
            usuarioService.eliminar(id);
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

    private static ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String, String> errores = new HashMap<>();//Si hay error muestro un mensaje y no el json
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }


}
