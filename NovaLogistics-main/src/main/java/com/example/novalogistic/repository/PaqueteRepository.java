package com.example.novalogistic.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.novalogistic.model.Paquete;

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete,Long>{

}