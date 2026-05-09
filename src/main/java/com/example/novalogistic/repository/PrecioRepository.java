package com.example.novalogistic.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.novalogistic.model.Precio; 

@Repository
public interface PrecioRepository extends JpaRepository<Precio, Integer>
{
    List<Precio> findByPrecioBase(Double precio_base);
    @Query("SELECT p FROM Precio p WHERE p.precio_base = :precio_base")
    Precio findByQueryPrecioBase(Double precio_base);    
}
