package com.proyecto.calidad.config;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.proyecto.calidad.services.Impl.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestTokenHeader = request.getHeader("Authorization");//obtiene el encabezado de la solicitud HTTP que contiene el token
        String username = null;
        String jwtToken = null;

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) { //verifica que el token comience con la palabra bearer, ya que es un formato de autorizacion
            jwtToken = requestTokenHeader.substring(7);//si empieza con bearer, pues procedemos a eliminar eso para que solo pase el token

            try {
                username = this.jwtUtil.getUsernameFromToken(jwtToken);//obtiene el nombre de usuario del token
            } catch (ExpiredJwtException exception) {
                System.out.println("El token ha expirado");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Token inválido, no empieza con 'Bearer' string");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) { // si el usuario es nulo o no esta autenticado
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);//se cargan los datos del usuario desde la bd
            if (this.jwtUtil.isTokenValid(jwtToken, userDetails)) { //se valida el token
                //si el token es correcto entonces se crea un usernamePasswordAuthenticationToken para que sea enviado a SecurityContextHolder
                //y spring security reconozca que el usuario esta autenticado
                //esas funciones mencionadas anteriormente son de spring security, no fueron creadas por nosotros
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        } else {
            System.out.println("El token no es válido");
        }
        //si todo es correo, se sigue con el flujo
        //valida el token y luego al usuario con el spring security
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        // Si la ruta empieza por /mercadoPago/, no apliques el filtro
        String path = request.getServletPath();
        return path.startsWith("/mercadoPago/");
    }
}