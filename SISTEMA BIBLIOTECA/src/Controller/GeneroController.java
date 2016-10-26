/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Genero;
import SistemaDao.GeneroDao;
import java.util.ArrayList;

/**
 *
 * @author Senai
 */
public class GeneroController {

    GeneroDao generoDao;

    public GeneroController() {
        if (generoDao == null) {
            generoDao = new GeneroDao();
        }
    }

    public ArrayList<Genero> getGeneroByNome(String texto) {
        return generoDao.getGeneroByNome(texto);
    }
    
      public ArrayList<Genero> getGenero(String texto) {
        return generoDao.getGenero();
    }

    public boolean insereGenero(Genero genero) {
        if (genero.getIdGenero() != 0) {

            return generoDao.updateGenero(genero);
        } else {
            return generoDao.insereGenero(genero);
        }

    }
    
    public boolean deleteGenero(int id) {
        return generoDao.deleteGenero(id);
    }

}


