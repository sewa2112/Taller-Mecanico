package com.taller.taller_mecanico.Model;


import jakarta.persistence.*;

@Entity
@Table
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anio;
    private String color;
    // getters y setters
}
