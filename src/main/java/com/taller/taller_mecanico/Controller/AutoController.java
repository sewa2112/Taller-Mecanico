package com.taller.taller_mecanico.Controller;


import com.taller.taller_mecanico.Model.Auto;
import com.taller.taller_mecanico.Service.AutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/autos")
public class AutoController {
    private final AutoService service;
    public AutoController(AutoService service){ this.service = service; }
    @PostMapping
    public ResponseEntity<Auto> crear(@RequestBody Auto nuevo){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(nuevo));
    }
    @GetMapping
    public List<Auto> listar(){ return service.listar(); }
    @GetMapping("/{id}")
    public Auto obtener(@PathVariable Integer id){ return service.obtener(id); }
    @PutMapping("/{id}")
    public Auto actualizar(@PathVariable Integer id,@RequestBody Auto datos){
        Auto e = service.obtener(id);
        return service.guardar(e);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id){ service.eliminar(id); }
}
