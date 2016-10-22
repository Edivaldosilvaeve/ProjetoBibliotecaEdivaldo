/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDao;

import Model.Livro;
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
public class LivroDao {

    Statement st;
    Livro livro;

    public LivroDao() {

        try {
            st = ConexaoDao.getConexao().createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro conexao login" + ex);
        }

    }

    public Livro getLivroById(int id) {
        ResultSet rs;
        Livro livro;

        try {
            rs = st.executeQuery("SELECT IDLIVRO, IDGENERO, IDAUTOR, IDEDITORA, TITULO FROM LIVRO WHERE = IDLIVRO = " + id);

        } catch (SQLException ex) {
            Logger.getLogger(SistemaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean insereLivro(Livro livro) {
        String sql = "";
        Date data = new Date();
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(IDLIVRO)+1,1) AS IDLIVRO FROM LIVROS";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDLIVRO");
            }

            livro.setIdLivro(id);

            sql = "INSERT INTO LIVROS (idlivro, idgenero, idautor, ideditora, titulo)"
                    + "VALUES (" + livro.getIdLivro()
                    + "  ,  '" + livro.getIdGenero()
                    + "' , '" + livro.getIdAutor()
                    + "' , '" + livro.getIdEditora()
                    + "' , '" + livro.getTitulo()                    
                    + "')";
            System.out.println(sql);
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir livro" + ex);
            livro.setIdLivro(0);
            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }
        return false;
    }

    public ArrayList<Livro> getLivros() {
        ResultSet rs;
        Livro livros;
        ArrayList<Livro> lista = new ArrayList<>();
        try {
            rs = st.executeQuery("SELECT IDLIVRO, IDGENERO, IDAUTOR, IDEDITORA, TITULO FROM LIVROS");
            while (rs.next()) {
                livros = new Livro();
                livros.setIdLivro(rs.getInt("IDLIVRO"));
                livros.setIdGenero(rs.getInt("IDGENERO"));
                livros.setIdAutor(rs.getInt("IDAUTOR"));
                livros.setIdEditora(rs.getInt("IDEDITORA"));
                livros.setTitulo(rs.getString("TITULO"));                
                
                lista.add(livros);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }

    public boolean updateLivro(Livro livro) {
        Date data = new Date();
        String sql = "UPDATE livros SET "
                + "idlivro=" + livro.getIdLivro()+ ","
                + "idgenero=" + livro.getIdGenero()+ ", "
                + "idautor=" + livro.getIdAutor()+ ","
                + "ideditora=" + livro.getIdEditora()+ ","
                + "titulo='" + livro.getTitulo()+ "',"               
                + " WHERE idlivro=" + livro.getIdLivro()+ ",";
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Update" + ex + "\n" + sql);
        }
        return false;
    }   
    public boolean deleteLivro(int id) {
        String sql = "DELETE FROM LIVROS WHERE IDLIVRO = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro delete");
        }

        return false;
    }

     public ArrayList<Livro> getPesquisar(String nome) {
        ResultSet rs;
        Livro livros;
        ArrayList<Livro> lista = new ArrayList<>();
        try {
            rs = st.executeQuery("SELECT IDLIVRO, IDGENERO, IDAUTOR, IDEDITORA, TITULO FROM LIVROS   WHERE LOWER(TITULO) LIKE LOWER('%"+nome+"%')");
            while (rs.next()) {
                livros = new Livro();
                livros.setIdLivro(rs.getInt("IDLIVRO"));
                livros.setIdGenero(rs.getInt("IDGENERO"));
                livros.setIdAutor(rs.getInt("IDAUTOR"));
                livros.setIdEditora(rs.getInt("IDEDITORA"));
                livros.setTitulo(rs.getString("TITULO"));                
                
                lista.add(livros);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }
    
}
