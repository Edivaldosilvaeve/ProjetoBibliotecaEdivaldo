/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDao;

import Model.Autor;
import Model.Pessoa;
import com.sun.org.apache.bcel.internal.generic.RETURN;
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
 * @author EDIVALDOS4342_00
 */
public class AutorDao {

    Statement st;
    Autor autor;

    public AutorDao() {

        try {
            st = ConexaoDao.getConexao().createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de cadastro" + ex);
        }

    }

    public Autor getAutorById() {
        ResultSet rs;
        Autor autores;

        try {
            rs = st.executeQuery("\"SELECT IDAUTOR, NOME FROM AUTOR WHERE = IDAAUTOR = \" + id");
        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean insereAutor(Autor autor) {
        String sql = "";
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(IDAUTOR)+1,1) AS IDAUTOR FROM AUTOR";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDAUTOR");
            }

            autor.setIdautor(id);
            sql = "INSERT INTO AUTOR (idautor, nome )"
                    + "VALUES (" + autor.getIdautor()
                    + "  ,  '" + autor.getNome()
                    + "')";
            System.out.println(sql);
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir Autor" + ex);
            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }
        return false;
    }

    public ArrayList<Autor> getAutor() {
        ResultSet rs;
        Autor autores;
        ArrayList<Autor> lista = new ArrayList<>();
        try {
            rs = st.executeQuery("SELECT IDAUTOR, NOME FROM AUTOR");
            while (rs.next()) {
                autores = new Autor();
                autores.setIdautor(rs.getInt("IDAUTOR"));
                autores.setNome(rs.getString("NOME"));
                lista.add(autores);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }

    public boolean updateAutor(Autor autor) {
        Date data = new Date();
        String sql = "UPDATE autor SET "
                + "idautor=" + autor.getIdautor() + ","
                + "nome='" + autor.getNome() + "', "
                + " WHERE idautor=" + autor.getIdautor() + "',";
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Update" + ex);
        }
        return false;
    }

    public ArrayList<Autor> getPesquisa(String nome) {
        ResultSet rs;
        Autor pesquisa;
        ArrayList listaAutor = new ArrayList();

        try {
            rs = st.executeQuery("SELECT IDAUTOR, NOME FROM AUTOR WHERE NOME like '%" + nome + "%'");
            while (rs.next()) {
                pesquisa = new Autor();
                pesquisa.setIdautor(rs.getInt("IDAUTOR"));
                pesquisa.setNome(rs.getString("NOME"));
                listaAutor.add(pesquisa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaAutor;
    }

    public boolean deleteAutor(int id) {
        String sql = "DELETE FROM AUTOR WHERE IDAUTOR = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro delete");
        }

        return false;
    }

}
