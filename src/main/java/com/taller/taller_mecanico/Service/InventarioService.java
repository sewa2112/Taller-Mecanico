package com.taller.taller_mecanico.Service;
import com.taller.taller_mecanico.Model.Inventario;
import com.taller.taller_mecanico.Repository.InventarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

        private final InventarioRepository repo;

        public InventarioService(InventarioRepository repo) {
            this.repo = repo;
        }

        public Inventario guardar(Inventario e) {
            return repo.save(e);
        }

        public List<Inventario> listar() {
            return repo.findAll();
        }

        public Inventario obtener(Integer id) {
            return repo.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Inventario " + id + " no encontrado"));
        }

        public void eliminar(Integer id) {
            repo.deleteById(id);
        }
    }


