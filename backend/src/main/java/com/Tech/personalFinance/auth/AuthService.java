package com.Tech.personalFinance.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.Tech.personalFinance.domain.dto.LoginRequest;
import com.Tech.personalFinance.domain.dto.LoginResponse;
import com.Tech.personalFinance.security.CustomUserDetailsService;
import com.Tech.personalFinance.security.JwtService;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    public AuthService(
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            CustomUserDetailsService userDetailsService) {

        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.contrasenia()
                )
        );

        UserDetails user = userDetailsService
                .loadUserByUsername(request.username());

        String token = jwtService.generateToken(user);

        return new LoginResponse(token);
    }
}
