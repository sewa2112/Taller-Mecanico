package com.taller.taller_mecanico.Model;


import jakarta.persistence.*;

@Entity
@Table(name="mecanicos")
public class Mecanicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    // getters y setters

}
