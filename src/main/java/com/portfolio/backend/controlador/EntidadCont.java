package com.portfolio.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.interfaces.IEntidadService;
import com.portfolio.backend.modelo.Entidad;

@RestController
@CrossOrigin
public class EntidadCont {
   
   @Autowired
   private IEntidadService entidadServ;

   @GetMapping("/api/entidad/listar")
   @ResponseBody
   public List<Entidad> obtenerEntidades() {
      return entidadServ.obtenerEntidades();
   }

   @GetMapping("/api/entidad/buscar/{id}")
   @ResponseBody
   public Entidad buscarEntidad(@PathVariable Long id) {
      return entidadServ.buscarEntidad(id);
   }

   @PostMapping("/api/entidad/nueva")
   public void crearEntidad(@RequestBody Entidad ent) {
      entidadServ.crearEntidad(ent);
   }

   @DeleteMapping("api/entidad/borrar/{id}")
   public void borrarEntidad(@PathVariable Long id) {
      entidadServ.borrarEntidad(id);
   }

   @PutMapping("/api/entidad/editar/{id}")
   public void editarEntidad(@PathVariable("id") Long id, @RequestBody Entidad ent) {
      entidadServ.editarEntidad(id, ent);
   }

}
