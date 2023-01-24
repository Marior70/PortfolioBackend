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

import com.portfolio.backend.modelo.Experiencia;
import com.portfolio.backend.interfaces.IExperienciaService;

@RestController
public class ExperienciaCont {

   @Autowired
   private IExperienciaService experienciaServ;

   @GetMapping("/api/experiencia/listar")
   @ResponseBody
   public List<Experiencia> obtenerExperiencias() {
      return experienciaServ.obtenerExperiencias();
   }

   @GetMapping("/api/experiencia/buscar/{id}")
   @ResponseBody
   public Experiencia buscarExperiencia(@PathVariable Long id) {
      return experienciaServ.buscarExperiencia(id);
   }

   @PostMapping("/api/experiencia/nueva")
   public void crearExperiencia(@RequestBody Experiencia exp) {
      experienciaServ.crearExperiencia(exp);
   }

   @DeleteMapping("api/experiencia/borrar/{id}")
   public void borrarExperiencia(@PathVariable Long id) {
      experienciaServ.borrarExperiencia(id);
   }
   
   @PutMapping("/api/experiencia/editar/{id}")
   public void editarExperiencia(@PathVariable("id") Long id, @RequestBody Experiencia exp) {
      experienciaServ.editarExperiencia(id, exp);
   }   

}
