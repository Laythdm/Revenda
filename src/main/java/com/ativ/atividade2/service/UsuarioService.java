package com.ativ.atividade2.service;

import com.ativ.atividade2.data.PerfilUsuario;
import com.ativ.atividade2.data.UsuarioEntity;
import com.ativ.atividade2.data.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioEntity criarUsuarioSeNaoExistir(String login, String senhaPura, PerfilUsuario perfil) {
        return usuarioRepository.findByLogin(login).orElseGet(() -> {
            UsuarioEntity u = new UsuarioEntity();
            u.setLogin(login);
            u.setSenha(passwordEncoder.encode(senhaPura));
            u.setPerfil(perfil);
            return usuarioRepository.save(u);
        });
    }
}
