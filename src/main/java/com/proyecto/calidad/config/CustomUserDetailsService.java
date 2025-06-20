package com.proyecto.calidad.config;

    /*
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements AuthenticationProvider  {

    @Autowired
    private UsuarioRepository userRepository; 

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserEntity user = userRepository.findByUsername(username);
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
    */