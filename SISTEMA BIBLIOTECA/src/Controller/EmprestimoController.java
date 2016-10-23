/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Editora;
import Model.Emprestimos;
import SistemaDao.EditoraDao;
import SistemaDao.EmprestimoDao;
import java.util.ArrayList;

/**
 *
 * @author Edivaldo
 */
public class EmprestimoController {
    EmprestimoDao emprestimoDao;

    public EmprestimoController(){
        if (emprestimoDao == null) {
            emprestimoDao = new EmprestimoDao();
        }
    }

   
    public boolean insereEmprestimo(Emprestimos emprestimo) {

        if (emprestimo.getIdEmprestimo()!= 0) {

            return emprestimoDao.updateEmprestimo(emprestimo);
        } else {
            return emprestimoDao.insereEmprestimos(emprestimo);
        }

    }
   
    
    
}
