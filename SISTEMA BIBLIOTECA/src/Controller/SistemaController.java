/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pessoa;
import Model.Usuario;
import SistemaDao.SistemaDao;
import java.util.ArrayList;

/**
 *
 * @author EDIVALDOS4342_00
 */
public class SistemaController {

    SistemaDao sistemadao;

    public SistemaController() {
        if (sistemadao == null) {
            sistemadao = new SistemaDao();
        }
    }

    public Usuario Login(Usuario sistema) {
        return sistemadao.Login(sistema);
    }

    public boolean inserePessoa(Pessoa pessoa) {

        if (pessoa.getIdpessoa() != 0) {

            return sistemadao.updatePessoa(pessoa);
        } else {
            return sistemadao.inserePessoa(pessoa);
        }

    }
    public ArrayList<Pessoa> getPessoa() {
        return sistemadao.getPessoas();
    }
   
 public ArrayList<Pessoa> getPessoaByNome(String nome){
       return sistemadao.getPesquisar(nome);
   }
}
