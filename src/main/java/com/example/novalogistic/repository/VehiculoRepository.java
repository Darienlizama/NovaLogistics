package com.example.novalogistic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.novalogistic.model.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer>
{
    List<Vehiculo> findByPatente(String patente);
    @Query("SELECT v FROM Vehiculo v WHERE v.patente = :patente")
    Vehiculo findByPatenteQuery(String patente);
}
