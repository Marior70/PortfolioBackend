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
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.modelo.Educacion;
import com.portfolio.backend.interfaces.IEducacionService;

@RestController
public class EducacionCont {


   @Autowired
   private IEducacionService educacionServ;

   @GetMapping("/api/educacion/listar")
   @ResponseBody
   public List<Educacion> obtenerEducacion() {
      return educacionServ.obtenerEducacion();
   }

   @GetMapping("/api/educacion/bucar/{id}")
   @ResponseBody
   public Educacion buscarEducacion(@PathVariable Long id) {
      return educacionServ.buscarEducacion(id);
   }

   @PostMapping("/api/educacion/nueva")
   public void crearEducacion(@RequestBody Educacion edu) {
      educacionServ.crearEducacion(edu);
   }

   @DeleteMapping("api/educacion/borrar/{id}")
   public void borrarEducacion(@PathVariable Long id) {
      educacionServ.borrarEducacion(id);
   }
   
   @PutMapping("/api/educacion/editar/{id}")
   public void editarEducacion(@PathVariable("id") Long id, @RequestBody Educacion edu) {
      educacionServ.editarEducacion(id, edu);
   }

}
