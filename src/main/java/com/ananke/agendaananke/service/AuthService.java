package com.ananke.agendaananke.service;

import com.ananke.agendaananke.DTO.AcessDTO;
import com.ananke.agendaananke.DTO.AuthenticationDTO;
import com.ananke.agendaananke.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessDTO login(AuthenticationDTO authDto){
        try {
        UsernamePasswordAuthenticationToken userAuth =
                new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(userAuth);

        UserDetailsImpl userAuthenticate = (UserDetailsImpl)authentication.getPrincipal();

        String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

        AcessDTO accessDto = new AcessDTO(token);

        return accessDto;

        }catch (BadCredentialsException e){

        }
        return new AcessDTO("Acesso negado");
    }
}
