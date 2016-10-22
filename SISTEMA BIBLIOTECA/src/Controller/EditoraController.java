/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Editora;
import Model.Livro;
import SistemaDao.EditoraDao;
import SistemaDao.LivroDao;
import java.util.ArrayList;

/**
 *
 * @author Edivaldo
 */
public class EditoraController {
    
    EditoraDao editoraDao;

    public EditoraController(){
        if (editoraDao == null) {
            editoraDao = new EditoraDao();
        }
    }

   
    public boolean insereEditora(Editora editora) {

        if (editora.getIdEditora()!= 0) {

            return editoraDao.updateEditora(editora);
        } else {
            return editoraDao.insereEditora(editora);
        }

    }
    public ArrayList<Editora> getEditora() {
        return editoraDao.getEditora();
    }
   
  //public ArrayList<Pessoa> getPesquisar(String nome){
    //   return sistemadao.getPesquisar(nome);
   //}
    
     public boolean deleteEditora(int id) {
        return editoraDao.deleteEditora(id);
    }
    
    
}
