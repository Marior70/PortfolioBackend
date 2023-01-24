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

import com.portfolio.backend.modelo.Aptitud;
import com.portfolio.backend.interfaces.IAptitudService;

@RestController
public class AptitudCont {

   @Autowired
   private IAptitudService aptitudServ;

   @GetMapping("/api/aptitud/listar")
   @ResponseBody
   public List<Aptitud> obtenerAptitudes() {
      return aptitudServ.obtenerAptitudes();
   }

   @GetMapping("/api/aptitud/buscar/{id}")
   @ResponseBody
   public Aptitud buscarAptitud(@PathVariable Long id) {
      return aptitudServ.buscarAptitud(id);
   }

   @PostMapping("/api/aptitud/nueva")
   public void crearAptitud(@RequestBody Aptitud apt) {
      aptitudServ.crearAptitud(apt);
   }

   @DeleteMapping("api/aptitud/borrar/{id}")
   public void borrarAptitud(@PathVariable Long id) {
      aptitudServ.borrarAptitud(id);
   }

   @PutMapping("/api/aptitud/editar/{id}")
   public void editarAptitud(@PathVariable("id") Long id, @RequestBody Aptitud apt) {
      aptitudServ.editarAptitud(id, apt);
   }

}
