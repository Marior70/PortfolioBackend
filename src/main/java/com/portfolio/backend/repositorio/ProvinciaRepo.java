package com.portfolio.backend.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.modelo.Provincia;

@Repository
public interface ProvinciaRepo extends JpaRepository <Provincia,Long>{

   Optional<Provincia> findOneByNombre(String nombre);
   
}
