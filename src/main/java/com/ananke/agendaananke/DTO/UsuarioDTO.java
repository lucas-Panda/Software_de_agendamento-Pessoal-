package com.ananke.agendaananke.DTO;

import com.ananke.agendaananke.entity.UsuarioEntity;
import com.ananke.agendaananke.entity.enums.TipoSituacaoUsuario;
import jakarta.persistence.Column;
import org.springframework.beans.BeanUtils;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private TipoSituacaoUsuario situacao;

    public UsuarioDTO(UsuarioEntity usuario) {
        BeanUtils.copyProperties(usuario, this);
    }
    public UsuarioDTO(){

    }

//----------------ID-----------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//----------------Nome---------------------------

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//----------------Login--------------------------

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

//----------------Senha--------------------------

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

//----------------Email--------------------------

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
//-----------------------------------------------

    public TipoSituacaoUsuario getSituacao() {
        return situacao;
    }

    public void setSituacao(TipoSituacaoUsuario situacao) {
        this.situacao = situacao;
    }
}
