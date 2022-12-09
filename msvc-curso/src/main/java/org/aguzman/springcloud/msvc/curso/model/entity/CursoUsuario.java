package org.aguzman.springcloud.msvc.curso.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "curso_usuarios")
public class CursoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", unique = true )
    private Long usuarioId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CursoUsuario )) return false;
        CursoUsuario obj = (CursoUsuario) o;
        return this.usuarioId != null && this.usuarioId.equals(obj.usuarioId);
    }

}
