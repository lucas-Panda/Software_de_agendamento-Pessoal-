package com.ananke.agendaananke.DTO;

import com.ananke.agendaananke.entity.RecursoEntity;
import org.springframework.beans.BeanUtils;

public class RecursoDTO {

    private Long id;
    private String nome;
    private String chave;

    public RecursoDTO(RecursoEntity recurso){
        BeanUtils.copyProperties(recurso, this);
    }

    public RecursoDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}
