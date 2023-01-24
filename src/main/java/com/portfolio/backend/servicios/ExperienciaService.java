package com.portfolio.backend.servicios;

import com.portfolio.backend.interfaces.IExperienciaService;
import com.portfolio.backend.modelo.Experiencia;
import com.portfolio.backend.repositorio.ExperienciaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService implements IExperienciaService {

   @Autowired
   public ExperienciaRepo experienciaRepo;
   
   @Override
   public List<Experiencia> obtenerExperiencias() {
      return experienciaRepo.findAll();
   }

   @Override
   public void crearExperiencia(Experiencia exp) {
      experienciaRepo.save(exp);
   }

   @Override
   public void borrarExperiencia(Long id) {
      experienciaRepo.deleteById(id);
   }

   @Override
   public Experiencia buscarExperiencia(Long id) {
      return experienciaRepo.findById(id).orElse(null);
   }

   @Override
   public void editarExperiencia(Long id, Experiencia expRequest) {
      Experiencia exp = experienciaRepo.findById(id).orElseThrow(null);
      exp.setId(expRequest.getId());
      exp.setRol(expRequest.getRol());
      exp.setFechaIni(expRequest.getFechaIni());
      exp.setFechaFin(expRequest.getFechaFin());
      exp.setDescripcion(expRequest.getDescripcion());
      // Resolver como generar los datos relacionales
      // exp.setTitulo(expRequest.get(Titulo));
      // exp.setEntidad(expRequest.get(Entidad));
      // exp.setPersona(expRequest.getPersona());
      
      experienciaRepo.save(exp);
   }

}
