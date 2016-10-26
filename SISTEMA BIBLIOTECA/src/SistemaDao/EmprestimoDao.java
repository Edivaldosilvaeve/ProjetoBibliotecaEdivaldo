/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDao;

import Model.Editora;
import Model.Emprestimos;
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
public class EmprestimoDao {

    Statement st;
    Emprestimos emprestimo;

    public EmprestimoDao() {

        try {
            st = ConexaoDao.getConexao().createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro conexao" + ex);
        }

    }

    public Editora getEmprestimoById(int id) {
        ResultSet rs;
        Emprestimos emprestimo;

        try {
            rs = st.executeQuery("SELECT  IDEMPRESTIMO, PREVISAO_ENTREGA, DATA_DEVOLUCAO FROM EMPRESTIMOS WHERE = IDEMPRESTIMO = " + id);

        } catch (SQLException ex) {
            Logger.getLogger(SistemaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean insereEmprestimos(Emprestimos emprestimo) {
        String sql = "";
        Date data = new Date();
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(IDEMPRESTIMO)+1,1) AS IDEMPRESTIMO FROM EMPRESTIMOS";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDEMPRESTIMO");
            }

            emprestimo.setIdEmprestimo(id);

            sql = "INSERT INTO EMPRESTIMOS (IDEMPRESTIMO, PREVISAO_ENTREGA, DATA_DEVOLUCAO, IDLIVRO, IDUSUARIO)"
                    + "VALUES (" + emprestimo.getIdEmprestimo()
                    + "  ,  '" + emprestimo.getDataEmprestimo()
                    + "'  ,  '" + emprestimo.getDataDevolucao()
                    + "' , " + emprestimo.getIdLivro()
                    + " , " + emprestimo.getIdAluno()                    
                    + ")";
            System.out.println(sql);
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir emprestimo" + ex);
            emprestimo.setIdEmprestimo(0);
            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }
        return false;
    }

    public boolean updateEmprestimo(Emprestimos emprestimo) {
        //  Date data = new Date();
        String sql = "UPDATE emprestimos SET "
                + "idemprestimo=" + emprestimo.getIdEmprestimo() + ","
                + "previsao_entrega=" + emprestimo.getDataEmprestimo()+","
                + "data_devolucao=" + emprestimo.getDataDevolucao()
                + " WHERE idemprestimo=" + emprestimo.getIdEmprestimo();
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Update" + ex + "\n" + sql);
        }
        return false;
    }
    
     public ArrayList<Emprestimos> getPesquisar(String nome) {
        ResultSet rs;
        Emprestimos emprestimos;
        ArrayList<Emprestimos> lista = new ArrayList<>();
        try {
           rs = st.executeQuery(" IDemprestimo, EMPRESTIMOS.idusuario, idlivro, previsao_entrega, data_devolucao FROM EMPRESTIMOS LEFT JOIN PESSOAS ON PESSOAS.PESSOAID = EMPRESTIMOS.IDUSUARIO WHERE LOWER(PESSOAS.NOME) LIKE  LOWER('%"+nome+"%')");            
            while (rs.next()) {
                emprestimos = new Emprestimos();
                emprestimos.setIdEmprestimo(rs.getInt("IDEMPRESTIMOS"));
                emprestimos.setIdAluno(rs.getInt("IDALUNO"));
                emprestimos.setIdLivro(rs.getInt("IDLIVRO"));
                emprestimos.setDataEmprestimo(rs.getString("PREVISAO_ENTREGA"));
                emprestimos.setDataDevolucao(rs.getString("DATA_DEVOLUCAO"));               
                
                lista.add(emprestimos);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }
      public ArrayList<Emprestimos> getEmprestimosByIDAluno(int id ) {
        ResultSet rs;
        Emprestimos emprestimos;
        ArrayList<Emprestimos> lista = new ArrayList<>();
        try {
           rs = st.executeQuery("select IDemprestimo, idusuario, idlivro, previsao_entrega, data_devolucao FROM EMPRESTIMOS WHERE  idusuario ="+id);            
            while (rs.next()) {
                emprestimos = new Emprestimos();
                emprestimos.setIdEmprestimo(rs.getInt("IDEMPRESTIMO"));
                emprestimos.setIdAluno(rs.getInt("idusuario"));
                emprestimos.setIdLivro(rs.getInt("idlivro"));
                emprestimos.setDataEmprestimo(rs.getString("previsao_entrega"));
                emprestimos.setDataDevolucao(rs.getString("data_devolucao"));               
                
                lista.add(emprestimos);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }
     
     public boolean deleteEmprestimo(int id) {
        String sql = "DELETE FROM EMPRESTIMOS WHERE IDEMPRESTIMO = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro delete");
        }

        return false;
    }


}
