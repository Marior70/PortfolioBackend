package com.portfolio.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.portfolio.backend.interfaces.IUsuarioService;
import com.portfolio.backend.modelo.Usuario;

@RestController
@CrossOrigin
public class UsuarioCont {

   @Autowired
   private IUsuarioService usuarioServ;

   @PostMapping("/api/usuario")
   public void crearUsuario(@RequestBody Usuario tit) {
      usuarioServ.crearUsuario(tit);
   }

   @GetMapping("/api/usuario/listar")
   @ResponseBody
   public List<Usuario> obtenerUsuarios() {
      return usuarioServ.obtenerUsuarios();
   }

   @DeleteMapping("api/usuario/borrar/{id}")
   public void borrarUsuario(@PathVariable Long id) {
      usuarioServ.borrarUsuario(id);
   }

}
