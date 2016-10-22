/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Livro;


import SistemaDao.LivroDao;

import java.util.ArrayList;

/**
 *
 * @author Edivaldo
 */
public class LivroController {
     LivroDao livroDao;

    public LivroController(){
        if (livroDao == null) {
            livroDao = new LivroDao();
        }
    }

   
    public boolean insereLivros(Livro livro) {

        if (livro.getIdLivro()!= 0) {

            return livroDao.updateLivro(livro);
        } else {
            return livroDao.insereLivro(livro);
        }

    }
    public ArrayList<Livro> getLivros() {
        return livroDao.getLivros();
    }
   
 public ArrayList<Livro> getLivroByNome(String nome){
       return livroDao.getPesquisar(nome);
   }
    
     public boolean deleteLivro(int id) {
        return livroDao.deleteLivro(id);
    }
    
}
