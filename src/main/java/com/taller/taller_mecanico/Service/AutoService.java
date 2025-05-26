package com.taller.taller_mecanico.Service;

import com.taller.taller_mecanico.Model.Auto;
import com.taller.taller_mecanico.Repository.AutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {
    private final AutoRepository repo;
    public AutoService(AutoRepository repo){ this.repo = repo; }
    public Auto guardar(Auto e){ return repo.save(e); }
    public List<Auto> listar(){ return repo.findAll(); }
    public Auto obtener(Integer id){
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Auto "+id+" no encontrado")); }
    public void eliminar(Integer id){ repo.deleteById(id); }
}
