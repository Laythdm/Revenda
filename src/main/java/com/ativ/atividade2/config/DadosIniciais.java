package com.ativ.atividade2.config;

import com.ativ.atividade2.data.PerfilUsuario;
import com.ativ.atividade2.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DadosIniciais {

    @Bean
    public CommandLineRunner seedUsuarios(UsuarioService usuarioService) {
        return args -> {
            usuarioService.criarUsuarioSeNaoExistir("gerente", "123", PerfilUsuario.GERENTE);
            usuarioService.criarUsuarioSeNaoExistir("vendedor", "123", PerfilUsuario.VENDEDOR);
        };
    }
}
