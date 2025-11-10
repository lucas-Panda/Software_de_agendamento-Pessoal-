package com.ananke.agendaananke.controller;

import com.ananke.agendaananke.DTO.AuthenticationDTO;
import com.ananke.agendaananke.DTO.UsuarioDTO;
import com.ananke.agendaananke.service.AuthService;
import com.ananke.agendaananke.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDTO){
        return ResponseEntity.ok(authService.login(authDTO));
    }

    @PostMapping(value = "/novoUsuario")
    public void inserirNovoUsuario(@RequestBody UsuarioDTO novoUsuario){
        usuarioService.inserirNovoUsuario(novoUsuario);
    }

}
