/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDao;

import Model.Editora;
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
public class EditoraDao {
    
    Statement st;
    EditoraDao editora;

    public EditoraDao() {

        try {
            st = ConexaoDao.getConexao().createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro conexao" + ex);
        }

    }

    public Editora getEditoraById(int id) {
        ResultSet rs;
        Editora editora;

        try {
            rs = st.executeQuery("SELECT  IDEDITORA, NOME FROM EDITORA WHERE = IDEDITORA = " + id);

        } catch (SQLException ex) {
            Logger.getLogger(SistemaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean insereEditora(Editora editora) {
        String sql = "";
        Date data = new Date();
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(IDEDITORA)+1,1) AS IDEDITORA FROM EDITORA";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDEDITORA");
            }

            editora.setIdEditora(id);

            sql = "INSERT INTO EDITORA (ideditora, nome)"
                    + "VALUES (" + editora.getIdEditora()
                    + "  ,  '" + editora.getNome()                                    
                    + "')";
            System.out.println(sql);
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir editora" + ex);
            editora.setIdEditora(0);
            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }
        return false;
    }

    public ArrayList<Editora> getEditora() {
        ResultSet rs;
        Editora editora;
        ArrayList<Editora> lista = new ArrayList<>();
        try {
            rs = st.executeQuery("SELECT  IDEDITORA, NOME FROM EDITORA");
            while (rs.next()) {
                editora = new Editora();
                
                editora.setIdEditora(rs.getInt("IDEDITORA"));
                editora.setNome(rs.getString("NOME"));                
                
                lista.add(editora);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }

    public boolean updateEditora(Editora editora) {
        Date data = new Date();
        String sql = "UPDATE editora SET "
                + "ideditora=" + editora.getIdEditora()+ ","
                + "nome='" + editora.getNome()+ "',"               
                + " WHERE ideditora=" + editora.getIdEditora()+ ",";
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Update" + ex + "\n" + sql);
        }
        return false;
    }   
    public boolean deleteEditora(int id) {
        String sql = "DELETE FROM EDITORA WHERE IDEDITORA = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro delete");
        }

        return false;
    }
    
}
