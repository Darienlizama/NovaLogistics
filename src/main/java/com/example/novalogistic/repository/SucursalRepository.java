package com.example.novalogistic.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.novalogistic.model.Sucursal; 

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer>
{
    List<Sucursal> findByDirection(String direccion);
    @Query("SELECT s FROM Sucursal s WHERE s.direccion = id")
    Sucursal findByDirectionQuery(String direccion);

    
}
