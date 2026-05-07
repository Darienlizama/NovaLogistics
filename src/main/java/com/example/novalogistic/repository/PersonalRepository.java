package com.example.novalogistic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.novalogistic.model.Personal;

@Repository
public interface PersonalRepository extends JpaRepository<Personal,Long>{  
} 