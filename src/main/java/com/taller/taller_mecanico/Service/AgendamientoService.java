package com.taller.taller_mecanico.Service;


import com.taller.taller_mecanico.Model.Agendamiento;
import com.taller.taller_mecanico.Repository.AgendamientoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamientoService {
    private final AgendamientoRepository repo;
    public AgendamientoService(AgendamientoRepository repo){ this.repo = repo; }
    public Agendamiento guardar(Agendamiento e){ return repo.save(e); }
    public List<Agendamiento> listar(){ return repo.findAll(); }
    public Agendamiento obtener(Integer id){
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamiento "+id+" no encontrado")); }
    public void eliminar(Integer id){ repo.deleteById(id);}
    }
