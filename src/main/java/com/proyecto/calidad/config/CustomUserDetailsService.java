package com.proyecto.calidad.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.proyecto.calidad.models.Usuario;
import com.proyecto.calidad.repositories.UsuarioRepository;


@Component
public class CustomUserDetailsService implements AuthenticationProvider  {

    @Autowired
    private UsuarioRepository userRepository; 

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Usuario user = userRepository.findByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            List<GrantedAuthority> authorities = new ArrayList<>();

            return new UsernamePasswordAuthenticationToken(username, password, authorities);
        } else {
            throw new BadCredentialsException("Credenciales inválidas");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
