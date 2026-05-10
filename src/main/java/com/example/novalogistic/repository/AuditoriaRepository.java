package com.example.novalogistic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.novalogistic.model.Auditoria;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria,Long > {

    
} 
