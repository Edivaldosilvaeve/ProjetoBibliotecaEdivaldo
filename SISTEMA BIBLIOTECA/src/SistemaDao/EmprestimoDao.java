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
            rs = st.executeQuery("SELECT  IDEMPRESTIMO, PREVISAO_ENTREGA, DATA_DEVOLUCAO FROM EMPRESTIMO WHERE = IDEMPRESTIMO = " + id);

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

            sql = "SELECT COALESCE(MAX(IDEMPRESTIMO)+1,1) AS IDEMPRESTIMO FROM EMPRESTIMO";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDEMPRESTIMO");
            }

            emprestimo.setIdEmprestimo(id);

            sql = "INSERT INTO EMPRESTIMO (IDEMPRESTMO, PREVISAO_ENTREGA, DATA_DEVOLUCAO)"
                    + "VALUES (" + emprestimo.getIdEmprestimo()
                    + "  ,  '" + emprestimo.getDataEmprestimo()
                    + "'  ,  '" + emprestimo.getDataDevolucao()
                    + "')";
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
        Date data = new Date();
        String sql = "UPDATE emprestimos SET "
                + "idemprestimo=" + emprestimo.getIdEmprestimo() + ","
                + "data_emprestimo='" + emprestimo.getDataEmprestimo() + "',"
                + "previsao_entrega='" + emprestimo.getDataDevolucao() + "',"
                + " WHERE idemprestimo=" + emprestimo.getIdEmprestimo() + ",";
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Update" + ex + "\n" + sql);
        }
        return false;
    }

}
