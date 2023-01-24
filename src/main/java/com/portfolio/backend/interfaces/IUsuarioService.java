package com.portfolio.backend.interfaces;

import com.portfolio.backend.modelo.Usuario;
import java.util.List;

public interface IUsuarioService {
   public List<Usuario> obtenerUsuarios();

   public Usuario buscarUsuario(Long id);

   public void crearUsuario(Usuario usr);

   public void borrarUsuario(Long id);

   public void editarUsuario(Long id, Usuario usr);

}
