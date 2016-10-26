/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDao;

import Model.Genero;
import Model.Pessoa;
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
public class GeneroDao {

    Statement st;
    Genero generos;

    public GeneroDao() {

        try {
            st = ConexaoDao.getConexao().createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro conexao login" + ex);
        }

    }
    public Genero getGeneroById(int id) {
        ResultSet rs;
        Genero genero;

        try {
            rs = st.executeQuery("SELECT IDGENERO, GENERO FROM GENERO WHERE = IDLOGIN = " + id);

        } catch (SQLException ex) {
            Logger.getLogger(SistemaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }


    public boolean insereGenero(Genero genero) {
        String sql = "";
        Date data = new Date();
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(IDGENERO)+1,1) AS IDGENERO FROM GENEROS";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDGENERO");
            }

            genero.setIdGenero(id);

            sql = "INSERT INTO generos (idgenero, genero)"
                    + "VALUES (" + genero.getIdGenero()
                    + "  ,  '" + genero.getGenero()
                    + "')";
            System.out.println(sql);
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir genero" + ex);
            genero.setIdGenero(0);
            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }
        return false;
    }

    public boolean updateGenero(Genero genero) {
        Date data = new Date();
        String sql = "UPDATE generos SET "
                + "idgenero=" + genero.getIdGenero() + ","
                + "genero=" + genero.getGenero() + ","
                + " WHERE idgenero=" + genero.getIdGenero() + ",";
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Update" + ex + "\n" + sql);
        }
        return false;
    }

    
     public ArrayList<Genero> getGeneroByNome(String texto) {
        ResultSet rs;
        Genero genero;
        ArrayList<Genero> lista = new ArrayList<Genero>();
        try {
            rs = st.executeQuery("SELECT idgenero, genero   FROM generos  WHERE LOWER(GENERO) LIKE LOWER('%"+texto+"%')");
            while (rs.next()) {
                genero = new Genero();
                genero.setIdGenero(rs.getInt("idgenero"));
                genero.setGenero(rs.getString("genero"));
                lista.add(genero);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }
     
     public ArrayList<Genero> getGenero() {
        ResultSet rs;
        Genero genero;

        ArrayList<Genero> lista = new ArrayList<>();

        try {
            rs = st.executeQuery("SELECT  IDGENERO, GENERO FROM GENEROS");
            while (rs.next()) {
                genero = new Genero();
                genero.setIdGenero(rs.getInt("IDGENERO"));
                genero.setGenero(rs.getString("GENERO"));
                
                lista.add(genero);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de consulta");
        }
        return lista;
    }    
     
      public boolean deleteGenero(int id) {
        String sql = "DELETE FROM GENERO WHERE IDGENERO = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro delete");
        }

        return false;
    }
    
    
}
