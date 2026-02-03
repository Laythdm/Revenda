package com.ativ.atividade2.config;

import com.ativ.atividade2.data.UsuarioEntity;
import com.ativ.atividade2.data.UsuarioRepository;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class DetalheUsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public DetalheUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity u = usuarioRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        String role = "ROLE_" + u.getPerfil().name();

        return new org.springframework.security.core.userdetails.User(
                u.getLogin(),
                u.getSenha(),
                List.of(new SimpleGrantedAuthority(role))
        );
    }
}
