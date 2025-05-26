package com.taller.taller_mecanico.Controller;


import com.taller.taller_mecanico.Model.Agendamiento;
import com.taller.taller_mecanico.Service.AgendamientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/agendamiento")
public class AgendamientoController {
    private final AgendamientoService service;
    public AgendamientoController(AgendamientoService service){ this.service = service; }
    @PostMapping
    public ResponseEntity<Agendamiento> crear(@RequestBody Agendamiento nuevo){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(nuevo));
    }
    @GetMapping
    public List<Agendamiento> listar(){ return service.listar(); }
    @GetMapping("/{id}")
    public Agendamiento obtener(@PathVariable Integer id){ return service.obtener(id); }
    @PutMapping("/{id}")
    public Agendamiento actualizar(@PathVariable Integer id,@RequestBody Agendamiento datos){
        Agendamiento e = service.obtener(id);
        return service.guardar(e);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id){ service.eliminar(id); }
}
