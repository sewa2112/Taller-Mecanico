package com.taller.taller_mecanico.Model;


import jakarta.persistence.*;

@Entity
@Table(name="agendamiento")
public class Agendamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    // getters y setters
}
