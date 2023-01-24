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

import com.portfolio.backend.modelo.Proyecto;
import com.portfolio.backend.interfaces.IProyectoService;

@RestController
public class ProyectoCont {

   // === Proyectos ========================================================
   @Autowired
   private IProyectoService proyectoServ;

   @GetMapping("/api/proyecto/listar")
   @ResponseBody
   public List<Proyecto> obtenerProyectos() {
      return proyectoServ.obtenerProyectos();
   }

   @GetMapping("/api/proyecto/buscar/{id}")
   @ResponseBody
   public Proyecto buscarProyecto(@PathVariable Long id) {
      return proyectoServ.buscarProyecto(id);
   }

   @PostMapping("/api/proyecto/nuevo")
   public void crearProyecto(@RequestBody Proyecto pro) {
      proyectoServ.crearProyecto(pro);
   }

   @DeleteMapping("api/proyecto/borrar/{id}")
   public void borrarProyecto(@PathVariable Long id) {
      proyectoServ.borrarProyecto(id);
   }
   
   @PutMapping("/api/proyecto/editar/{id}")
   public void editarProyecto(@PathVariable("id") Long id, @RequestBody Proyecto pro) {
      proyectoServ.editarProyecto(id, pro);
   }

}
