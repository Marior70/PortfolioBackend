package com.portfolio.backend.servicios;

//import com.portfolio.backend.conversionEntidadDto.PersonaConv;
//import com.portfolio.backend.dto.PersonaDTO;
import com.portfolio.backend.interfaces.IPersonaService;
import com.portfolio.backend.modelo.Localidad;
import com.portfolio.backend.modelo.Persona;
import com.portfolio.backend.modelo.Provincia;
import com.portfolio.backend.repositorio.LocalidadRepo;
import com.portfolio.backend.repositorio.PersonaRepo;
import com.portfolio.backend.repositorio.ProvinciaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {

   @Autowired
   public PersonaRepo personaRepo;
   
   @Override
   public List<Persona> obtenerPersonas() {

      List<Persona> listPersona = personaRepo.findAll();
      return listPersona;
   }

   @Override
   public void crearPersona(Persona per) {

      personaRepo.save(per);
   }

   @Override
   public void borrarPersona(Long id) {

      personaRepo.deleteById(id); // Borrado REAL del registro en la BD.

      /* Persona per = personaRepo.findById(id).orElseThrow(null);
      per.setBorrado(true); */   // Borrado lógico del registro en la BS.
   }

   @Override
   public Persona buscarPersona(Long id) {

      Persona per = personaRepo.findById(id).orElseThrow(null);
      return per;
   }

   @Override
   public void editarPersona(Long id, Persona perRequest) {
      // per, si existe en la BD, es el registro a actualizar
      // perRequest, es el registro recibido, con los nuevos valores
      Persona per = personaRepo.findById(id).orElseThrow(null);
      // Actualizo el registro per obtenido de la base de datos
      // con los datos contenidos en perRequest.
      per.setId(perRequest.getId());
      per.setNombres(perRequest.getNombres());
      per.setApellidos(perRequest.getApellidos());
      per.setAcercade(perRequest.getAcercade());
      per.setFoto(perRequest.getFoto());
      per.setEmail(perRequest.getEmail());
      per.setMovil(perRequest.getMovil());

      LocalidadRepo localidadRepo;
      Boolean encontrado = false;
      List<Localidad> listLocalidad = localidadRepo.findAll();
      listLocalidad.forEach((loc) -> {
      if (loc.getNombre() == perRequest.getLocalidad().getNombre()) {
      per.setLocalidad(loc);
      localidadRepo.save(loc);
      encontrado = true;
      }
      });
      if (encontrado != true) {
      Localidad localidad = new Localidad();
      localidad.setNombre(perRequest.getLocalidad().getNombre());
      encontrado = false;
      ProvinciaRepo provinciaRepo;
      List<Provincia> listProvincia = provinciaRepo.findAll();
      listProvincia.forEach(pro) -> {
      if (pro.getNombre() == perRequest.getLocalidad().getProvincia().getNombre()) {
         
      }
      };
      localidad.getProvincia()
      }
      
      ;
      
      List<Titulo> listTitulo = TituloRepo.findAll();
      listTitulo.forEach((tit) -> {
      if (tit.getTitulo() != perRequest.getTitulo()) {
      localidadRepo.save(tit);
      }
      per.setTitulo(tit);
      });
      
      
      // Guardo en la BD el registro per actualizado
      personaRepo.save(per);
      
   }

}
