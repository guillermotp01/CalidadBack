package com.proyecto.calidad.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.calidad.config.JwtUtils;
import com.proyecto.calidad.models.JwtRequest;
import com.proyecto.calidad.models.JwtResponse;
import com.proyecto.calidad.models.Usuario;
import com.proyecto.calidad.services.UsuarioService;
import com.proyecto.calidad.services.Impl.UserDetailsServiceImpl;

@RestController
@RequestMapping("/validar")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/ingresar")
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            autenticar(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (DisabledException exception) {
            throw new Exception("Usuario deshabilitado: " + exception.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("Credenciales inválidas: " + e.getMessage());
        } catch (Exception exception) {
            throw new Exception("Error durante la autenticación: " + exception.getMessage());
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }


    private void autenticar(String username, String password) throws Exception {
        Usuario usuario = usuarioService.obtenerUsuario(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new BadCredentialsException("Credenciales inválidas");
        }
    }

    @GetMapping("/actual-usuario")
    public Usuario obtenerUsuarioActual(Principal principal) {
        return (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
    }
}
