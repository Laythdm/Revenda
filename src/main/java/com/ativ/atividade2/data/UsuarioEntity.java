package com.ativ.atividade2.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "login não pode estar em branco")
    @Column(unique = true, nullable = false)
    private String login;

    
    @NotBlank(message = "senha não pode estar em branco")
    @Column(nullable = false)
    private String senha;

    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PerfilUsuario perfil;
}
