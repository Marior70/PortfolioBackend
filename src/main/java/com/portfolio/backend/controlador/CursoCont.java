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

import com.portfolio.backend.interfaces.ICursoService;
import com.portfolio.backend.modelo.Curso;

@RestController
@CrossOrigin
public class CursoCont {

   @Autowired
   private ICursoService cursoServ;

   @GetMapping("/api/curso/listar")
   @ResponseBody
   public List<Curso> obtenerCursos() {
      return cursoServ.obtenerCursos();
   }

   @GetMapping("/api/curso/buscar/{id}")
   @ResponseBody
   public Curso buscarCurso(@PathVariable Long id) {
      return cursoServ.buscarCurso(id);
   }

   @PostMapping("/api/curso/nuevo")
   public void crearCurso(@RequestBody Curso cur) {
      cursoServ.crearCurso(cur);
   }

   @DeleteMapping("api/curso/borrar/{id}")
   public void borrarCurso(@PathVariable Long id) {
      cursoServ.borrarCurso(id);
   }
   
   @PutMapping("/api/curso/editar/{id}")
   public void editarCurso(@PathVariable("id") Long id, @RequestBody Curso cur) {
      cursoServ.editarCurso(id, cur);
   }

}
