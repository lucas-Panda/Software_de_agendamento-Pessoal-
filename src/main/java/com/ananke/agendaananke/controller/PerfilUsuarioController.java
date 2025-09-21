package com.ananke.agendaananke.controller;

import com.ananke.agendaananke.DTO.PerfilUsuarioDTO;
import com.ananke.agendaananke.service.PerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/perfilusuario")
@CrossOrigin
public class PerfilUsuarioController {

    @Autowired
    private PerfilUsuarioService perfilUsarioService;

    @GetMapping
    public List<PerfilUsuarioDTO> listarTodos(){
        return perfilUsarioService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody PerfilUsuarioDTO perfilUsuario){
        perfilUsarioService.inserir(perfilUsuario);
    }

    @PutMapping
    public PerfilUsuarioDTO alterar(@RequestBody PerfilUsuarioDTO perfilUsuario){
        return perfilUsarioService.alterar(perfilUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        perfilUsarioService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
