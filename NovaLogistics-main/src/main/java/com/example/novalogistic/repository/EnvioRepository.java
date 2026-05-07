package com.example.novalogistic.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.novalogistic.model.Envio;

@Repository
public interface EnvioRepository extends JpaRepository<Envio,Long >{

}
