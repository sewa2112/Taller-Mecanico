package com.taller.taller_mecanico.Repository;

import com.taller.taller_mecanico.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
