package com.taller.taller_mecanico.Controller;


import com.taller.taller_mecanico.Model.Inventario;
import com.taller.taller_mecanico.Service.InventarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventario")
public class InventarioController {

    private final InventarioService service;
    public InventarioController(InventarioService service){ this.service = service; }
    @PostMapping
    public ResponseEntity<Inventario> crear(@RequestBody Inventario nuevo){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(nuevo));
    }
    @GetMapping
    public List<Inventario> listar(){ return service.listar(); }
    @GetMapping("/{id}")
    public Inventario obtener(@PathVariable Integer id){ return service.obtener(id); }
    @PutMapping("/{id}")
    public Inventario actualizar(@PathVariable Integer id,@RequestBody Inventario datos){
        Inventario e = service.obtener(id);
        return service.guardar(e);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id){ service.eliminar(id); }
}
