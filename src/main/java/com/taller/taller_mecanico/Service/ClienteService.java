package com.taller.taller_mecanico.Service;


import com.taller.taller_mecanico.Model.Cliente;
import com.taller.taller_mecanico.Repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repo;
    public ClienteService(ClienteRepository repo){ this.repo = repo; }
    public Cliente guardar(Cliente e){ return repo.save(e); }
    public List<Cliente> listar(){ return repo.findAll(); }
    public Cliente obtener(Integer id){
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente "+id+" no encontrado")); }
    public void eliminar(Integer id){ repo.deleteById(id);}
}
