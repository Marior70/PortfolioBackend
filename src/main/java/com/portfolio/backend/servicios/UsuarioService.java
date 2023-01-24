package com.portfolio.backend.servicios;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.interfaces.IUsuarioService;
import com.portfolio.backend.modelo.Usuario;
import com.portfolio.backend.repositorio.UsuarioRepo;

@Service
public class UsuarioService implements IUsuarioService{

   @Autowired
   public UsuarioRepo usuarioRepo;

   @Override
   public List<Usuario> obtenerUsuarios() {
      return usuarioRepo.findAll();
   }

   @Override
   public void crearUsuario(Usuario usr) {
      usr.setEsAdmin(false);
      usuarioRepo.save(usr);
   }

   @Override
   public void borrarUsuario(Long id) {
      usuarioRepo.deleteById(id);     
   }

   @Override
   public Usuario buscarUsuario(Long id) {
      return usuarioRepo.findById(id).orElse(null);
   }

   @Override
   public void editarUsuario(Long id, Usuario usrRequest){
      Usuario usr = usuarioRepo.findById(id).orElseThrow(null);
      usr.setId(usrRequest.getId());
      usr.setNombre(usrRequest.getNombre());
      usr.setEmail(usrRequest.getEmail());
      usr.setClave(usrRequest.getClave());
      usr.setEsAdmin(false);
      usr.setEntidad(usrRequest.getEntidad());
      // usr.setPersona(usrRequest.getPersona());
      usuarioRepo.save(usr);
   }
   
}