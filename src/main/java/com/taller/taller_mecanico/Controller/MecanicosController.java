package com.taller.taller_mecanico.Controller;


import com.taller.taller_mecanico.Model.Mecanicos;
import com.taller.taller_mecanico.Service.MecanicosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mecanicos")
public class MecanicosController {
    private final MecanicosService service;
    public MecanicosController(MecanicosService service){ this.service = service; }
    @PostMapping
    public ResponseEntity<Mecanicos> crear(@RequestBody Mecanicos nuevo){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(nuevo));
    }
    @GetMapping
    public List<Mecanicos> listar(){ return service.listar(); }
    @GetMapping("/{id}")
    public Mecanicos obtener(@PathVariable Integer id){ return service.obtener(id); }
    @PutMapping("/{id}")
    public Mecanicos actualizar(@PathVariable Integer id,@RequestBody Mecanicos datos){
        Mecanicos e = service.obtener(id);
        return service.guardar(e);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public void eliminar(@PathVariable Integer id){ service.eliminar(id); }
}
