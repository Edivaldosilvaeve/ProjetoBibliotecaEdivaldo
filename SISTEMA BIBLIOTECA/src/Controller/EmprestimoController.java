/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Emprestimos;
import Model.Livro;
import SistemaDao.EmprestimoDao;
import SistemaDao.LivroDao;
import java.util.ArrayList;

/**
 *
 * @author Edivaldo
 */
public class EmprestimoController {

    EmprestimoDao emprestimoDao;

    public EmprestimoController() {
        if (emprestimoDao == null) {
            emprestimoDao = new EmprestimoDao();
        }
    }

    public boolean insereEmprestimo(Emprestimos emprestimo) {

        if (emprestimo.getIdEmprestimo() != 0) {

            //return emprestimoDao.updateEmprestimo(emprestimo);
        //} else
        }
           return emprestimoDao.insereEmprestimos(emprestimo);
        

    }

    public ArrayList<Emprestimos> getEmprestimosByNome(String nome) {
        return emprestimoDao.getPesquisar(nome);
    }

    public boolean insereEmprestimos(ArrayList<Livro> livros, Emprestimos emprestimo) {

        for (Livro livro : livros) {
            emprestimo.setIdLivro(livro.getIdLivro());
            emprestimoDao.insereEmprestimos(emprestimo);

        }
        return true;
    }

    public ArrayList<Emprestimos> getLivrosByIDAluno(int id) {

       return emprestimoDao.getEmprestimosByIDAluno(id);
    }
      public boolean deleteEmprestimo(int id) {
        return emprestimoDao.deleteEmprestimo(id);
    }
}
