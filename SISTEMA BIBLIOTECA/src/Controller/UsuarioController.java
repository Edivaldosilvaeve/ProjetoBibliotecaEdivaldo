/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pessoa;
import Model.Usuario;
import SistemaDao.UsuarioDao;
import java.util.ArrayList;

/**
 *
 * @author Senai
 */
public class UsuarioController {
    UsuarioDao usuariodao;
     public UsuarioController(){
       if (usuariodao == null) {
            usuariodao = new UsuarioDao();
        }
    }

    public Usuario Login(Usuario usuario) {
        return usuariodao.Login(usuario);
    }

    
     public boolean insereUsuario(Usuario usuario) {

        if (usuario.getIdlogin()!= 0) {

            return usuariodao.updateLogin(usuario);
        } else {
            return usuariodao.insereUsuario(usuario);
        }

    }
      public ArrayList<Usuario> getUsuario() {
        return usuariodao.getUsuario();
    }
    public boolean deleteUsuario(int id) {
        return usuariodao.deleteUsuario(id);
    }
}
