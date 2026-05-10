package com.example.novalogistic.repository;

import com.example.novalogistic.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Para buscar si un RUT ya existe antes de registrar
    boolean existsByRut(String rut);
}