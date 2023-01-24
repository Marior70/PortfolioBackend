package com.portfolio.backend.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.modelo.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository <Usuario, Long>{
   
   Optional<Usuario> findOneByEmail(String email);

}
