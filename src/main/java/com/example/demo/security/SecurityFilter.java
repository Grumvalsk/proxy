package com.example.demo.security;

import com.example.demo.exception.AuthException;
//import com.example.demo.utility.ValidationJwt;
import lombok.SneakyThrows;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter  extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = request.getHeader("Authorization");
            if (jwt == null || jwt.isEmpty()) {
                throw new Exception("Jwt assente");
            } else {
//                ValidationJwt.validateJwt(jwt);
                System.out.println("FILTRO");
                filterChain.doFilter(request, response);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            throw new ServletException("Non authorizzato");


        }

    }
}
