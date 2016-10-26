/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDao;

import Model.Funcionario;
import Model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Edivaldo
 */
public class FuncionarioDao {
    
    Statement st;
  Funcionario funcionario;

    public FuncionarioDao() {

        try {
            st = ConexaoDao.getConexao().createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro conexao login" + ex);
        }

    }

    public Usuario getSistemaById(int id) {
        ResultSet rs;
        Funcionario funcionario;

        try {
            rs = st.executeQuery("SELECT IDFUNCIONARIO, PESSOAID, SALARIO FROM FUNCIONARIOS WHERE = IDFUNCIOARIO = " + id);

        } catch (SQLException ex) {
            Logger.getLogger(SistemaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

   

    public boolean insereFuncionario(Funcionario funcionario) {
        String sql = "";
        Date data = new Date();
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(IDFUNCIONARIO)+1,1) AS IDFUNCIONARIO FROM FUNCIONARIOS";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDFUNCIONARIO");
            }

            funcionario.setIdFuncionario(id);

            sql = "INSERT INTO funcionarios (idfuncionario, pessoaid, salario)"
                    + "VALUES (" + funcionario.getIdFuncionario()
                    + "  ,  " + funcionario.getPessoaId()
                    + " , '" + funcionario.getSalario()                    
                    + "')";
            System.out.println(sql);
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir funcionario" + ex);
            funcionario.setIdFuncionario(0);
            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }
        return false;
    }

    public ArrayList<Funcionario> getFuncionario() {
        ResultSet rs;
        Funcionario funcionario;
        ArrayList<Funcionario> lista = new ArrayList<>();
        try {
            rs = st.executeQuery("SELECT IDFUNCIONARIO, PESSOAID, SALARIO FROM FUNCIONARIOS");
            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("IDFUNCIONARIO"));
                funcionario.setPessoaId(rs.getInt("PESSOAID"));
                funcionario.setSalario(rs.getFloat("SALARIO"));
                
                
                lista.add(funcionario);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }

    public boolean updateFuncionario(Funcionario funcionario) {
        Date data = new Date();
        String sql = "UPDATE funcionarios SET "
                + "idfuncionario=" + funcionario.getIdFuncionario()+ ","
                + "pessoaid=" + funcionario.getPessoaId()+ " , "
                + "salario='" + funcionario.getSalario()+ "',"                
                + " WHERE idfuncionario=" + funcionario.getIdFuncionario()+ ",";
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Update" + ex + "\n" +sql );
        }
        return false;
    }

    public ArrayList<Funcionario> getPesquisar(String nome){
        ResultSet rs;  
       

        Funcionario pesquisa;
        ArrayList<Funcionario> lista = new ArrayList<>();
        try {
            rs = st.executeQuery("SELECT IDFUNCIONARIO, PESSOAID, SALARIO FROM FUNCIONARIOS WHERE NOME like '%"+nome+"%'");
            while (rs.next()) {
                pesquisa = new Funcionario();
                pesquisa.setIdFuncionario(rs.getInt("IDFUNCIONARIO"));
                pesquisa.setPessoaId(rs.getInt("PESSOAID"));                
                pesquisa.setSalario(rs.getFloat("SALARIO"));               
                lista.add(pesquisa);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao pesquisar" + ex);
        }
        return lista;
    }
    
    public boolean deleteFuncionario(int id) {
        String sql = "DELETE FROM FUNCIONARIOS WHERE IDFUNCIONARIO = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro delete");
        }

        return false;
    }

    
}
