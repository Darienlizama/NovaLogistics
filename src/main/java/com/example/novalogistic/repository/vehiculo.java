package com.example.novalogistic.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.novalogistic.model.vehiculos; 

@Repository
public interface vehiculo extends JpaRepository<vehiculos, Long>
{
    
}
