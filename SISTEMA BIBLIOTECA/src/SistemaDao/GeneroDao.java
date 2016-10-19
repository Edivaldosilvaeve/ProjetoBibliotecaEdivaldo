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

    public boolean insereUsuario(Genero genero) {
        String sql = "";
        Date data = new Date();
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(IDGENERO)+1,1) AS IDGENERO FROM GENERO";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDGENERO");
            }

            genero.setIdGenero(id);

            sql = "INSERT INTO genero (idgenero, genero)"
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
        String sql = "UPDATE login SET "
                + "idlogin=" + genero.getIdGenero() + ","
                + "idfuncionario=" + genero.getGenero() + ","
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
    
    
}
