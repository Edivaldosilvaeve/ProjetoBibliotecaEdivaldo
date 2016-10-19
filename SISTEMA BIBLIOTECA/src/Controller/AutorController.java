/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Autor;
import SistemaDao.AutorDao;
import java.util.ArrayList;

/**
 *
 * @author EDIVALDOS4342_00
 */
public class AutorController {
    AutorDao autordao;

    public AutorController() {
        if (autordao == null) {
            autordao = new AutorDao();
        }
    }  

    public boolean insereAutor(Autor autor) {

        if (autor.getIdautor()!= 0) {

            return autordao.updateAutor(autor);
        } else {
            return autordao.insereAutor(autor);
        }

    }
    public ArrayList<Autor> getAutor() {
        return autordao.getAutor();
    } 
     public boolean deleteAutor(int id) {
        return autordao.deleteAutor(id);
    }
     public ArrayList<Autor> getPesquisa(String nome){
         return autordao.getPesquisa(nome);
     }
    
}
