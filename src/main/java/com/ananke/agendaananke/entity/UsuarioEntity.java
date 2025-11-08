package com.ananke.agendaananke.entity;

import com.ananke.agendaananke.DTO.UsuarioDTO;
import com.ananke.agendaananke.entity.enums.TipoSituacaoUsuario;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "ENT_USUARIO")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoSituacaoUsuario situacao;

    public UsuarioEntity(UsuarioDTO usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

    public UsuarioEntity() {

    }

//----------------ID-----------------------------
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

//----------------NOME---------------------------
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

//---------------------------------------------

    public TipoSituacaoUsuario getSituacao() {
        return situacao;
    }

    public void setSituacao(TipoSituacaoUsuario situacao) {
        this.situacao = situacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

