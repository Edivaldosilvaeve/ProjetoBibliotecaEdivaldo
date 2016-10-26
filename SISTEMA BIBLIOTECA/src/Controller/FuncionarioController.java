/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Funcionario;

import SistemaDao.FuncionarioDao;

import java.util.ArrayList;

/**
 *
 * @author Edivaldo
 */
public class FuncionarioController {

    FuncionarioDao funcionarioDao;

    public FuncionarioController() {
        if (funcionarioDao == null) {
            funcionarioDao = new FuncionarioDao();
        }
    }

    public boolean insereFuncionario(Funcionario funcionario) {

        if (funcionario.getIdFuncionario() != 0) {

            return funcionarioDao.updateFuncionario(funcionario);
        } else {
            return funcionarioDao.insereFuncionario(funcionario);
        }

    }

    public ArrayList<Funcionario> getFuncionario() {
        return funcionarioDao.getFuncionario();
    }

    public ArrayList<Funcionario> getFuncionarioByNome(String nome) {
        return funcionarioDao.getPesquisar(nome);
    }

    public boolean deleteFuncionario(int id) {
        return funcionarioDao.deleteFuncionario(id);
    }
}
