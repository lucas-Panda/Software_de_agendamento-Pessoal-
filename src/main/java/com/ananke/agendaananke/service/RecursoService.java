package com.ananke.agendaananke.service;

import com.ananke.agendaananke.DTO.RecursoDTO;
import com.ananke.agendaananke.entity.RecursoEntity;
import com.ananke.agendaananke.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;

    public List<RecursoDTO> listarTodos(){
        List<RecursoEntity> recurso = recursoRepository.findAll();
        return recurso.stream().map(RecursoDTO::new).toList();
    }

    public void inserir(RecursoDTO recurso){
        RecursoEntity recursoEntity = new RecursoEntity(recurso);
        recursoRepository.save(recursoEntity);
    }

    public RecursoDTO alterar(RecursoDTO recurso){
        RecursoEntity recursoEntity = new RecursoEntity(recurso);
        return new RecursoDTO(recursoRepository.save(recursoEntity));
    }

    public void excluir(Long id){
        RecursoEntity recurso = recursoRepository.findById(id).get();
        recursoRepository.delete(recurso);
    }

    public RecursoDTO buscarPorId(Long id){
        return new RecursoDTO(recursoRepository.findById(id).get());
    }
}
