package com.example.novalogistic.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.novalogistic.model.Sucursal;
import feign.Param; 

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer>
{
    @Query("SELECT s FROM Sucursal s WHERE s.direccion = :direccion")
    Sucursal findByDirectionQuery(@Param("direccion") String direccion);
    
}
