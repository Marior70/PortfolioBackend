package com.portfolio.backend.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.modelo.Localidad;

@Repository
public interface LocalidadRepo extends JpaRepository <Localidad,Long>{

   Optional<Localidad> findOneByNombre(String nombre);
   
}
