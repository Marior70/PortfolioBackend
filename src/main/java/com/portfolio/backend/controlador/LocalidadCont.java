package com.portfolio.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import com.portfolio.backend.interfaces.ILocalidadService;
import com.portfolio.backend.modelo.Localidad;

public class LocalidadCont {

   @Autowired
   private ILocalidadService localidadServ;

   @GetMapping("/api/localidad/listar")
   @ResponseBody
   public List<Localidad> obtenerLocalidades() {
      return localidadServ.obtenerLocalidades();
   }

   @GetMapping("/api/localidad/buscar/{id}")
   @ResponseBody
   public Localidad buscarLocalidad(@PathVariable Long id) {
      return localidadServ.buscarLocalidad(id);
   }

   @PostMapping("/api/localidad/nueva")
   public void crearLocalidad(@RequestBody Localidad loc) {
      // listaLocalidades.add(loc);
      localidadServ.crearLocalidad(loc);
   }

   @DeleteMapping("api/localidad/borrar/{id}")
   public void borrarLocalidad(@PathVariable Long id) {
      localidadServ.borrarLocalidad(id);
   }

   @PutMapping("/api/localidad/editar/{id}")
   public void editarLocalidad(@PathVariable("id") Long id, @RequestBody Localidad loc) {
      localidadServ.editarLocalidad(id, loc);
   }

}
