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

import com.portfolio.backend.interfaces.IPersonaService;
import com.portfolio.backend.modelo.Persona;

@RestController
@CrossOrigin
public class PersonaCont {

   @Autowired
   private IPersonaService personaServ;

   @GetMapping("/api/persona/listar")
   @ResponseBody
   public List<Persona> obtenerPersonas() {
      return personaServ.obtenerPersonas();
   }

   /* @GetMapping("/api/persona/buscar/{id}")
   @ResponseBody
   public Persona buscarPersona(@PathVariable Long id) {
      return personaServ.buscarPersona(id);
   } */

   @PostMapping("/api/persona/nueva")
   public void crearPersona(@RequestBody Persona per) {
      personaServ.crearPersona(per);
   }

   @DeleteMapping("api/persona/{id}")
   public void borrarPersona(@PathVariable Long id) {
      personaServ.borrarPersona(id);
   }

   @PutMapping("/api/persona/editar/{id}")
   public void editarPersona(@PathVariable("id") Long id, @RequestBody Persona per) {
      personaServ.editarPersona(id, per);
   }

}
