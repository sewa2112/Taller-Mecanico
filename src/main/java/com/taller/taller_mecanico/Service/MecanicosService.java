package com.taller.taller_mecanico.Service;


import com.taller.taller_mecanico.Model.Mecanicos;
import com.taller.taller_mecanico.Repository.MecanicosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MecanicosService {
    private final MecanicosRepository repo;
    public MecanicosService(MecanicosRepository repo){ this.repo = repo; }
    public Mecanicos guardar(Mecanicos e){ return repo.save(e); }
    public List<Mecanicos> listar(){ return repo.findAll(); }
    public Mecanicos obtener(Integer id){
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mecanicos "+id+" no encontrado")); }
    public void eliminar(Integer id) { repo.deleteById(id); }
}
