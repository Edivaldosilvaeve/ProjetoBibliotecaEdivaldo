/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDao;

import Model.Pessoa;
import Model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Senai
 */
public class UsuarioDao {

    Statement st;
    Usuario usuario;

    public UsuarioDao() {

        try {
            st = ConexaoDao.getConexao().createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro conexao login" + ex);
        }

    }

    public Usuario getUsuarioById(int id) {
        ResultSet rs;
        Usuario usuario;

        try {
            rs = st.executeQuery("SELECT IDLOGIN,IDFUNCIONARIO, DESCRICAO, SENHA, IDGRUPO FROM LOGIN WHERE = IDLOGIN = " + id);

        } catch (SQLException ex) {
            Logger.getLogger(SistemaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Usuario Login(Usuario usuario) {

        try {
            String sql = "SELECT IDLOGIN, IDFUNCIONARIO, DESCRICAO, SENHA, IDGRUPO FROM LOGIN WHERE DESCRICAO = '" + usuario.getLogin() + "'"
                    + " AND SENHA = '" + usuario.getSenha() + "'";

            ResultSet rs;

            rs = st.executeQuery(sql);

            while (rs.next()) {
                usuario.setIdlogin(rs.getInt("IDLOGIN"));
                usuario.setIdFuncionario(rs.getInt("IDFUNCIONARIO"));
                usuario.setLogin(rs.getString("DESCRICAO"));
                usuario.setSenha("SENHA");
                usuario.setIdGrupo(rs.getInt("IDGRUPO"));
                return usuario;
            }
            return usuario;
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }

        return usuario;
    }

    public boolean insereUsuario(Usuario usuario) {
        String sql = "";
        Date data = new Date();
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(IDLOGIN)+1,1) AS IDLOGIN FROM LOGIN";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDLOGIN");
            }

            usuario.setIdlogin(id);

            sql = "INSERT INTO login (idlogin, idfuncionario, descricao, senha, idgrupo)"
                    + "VALUES (" + usuario.getIdlogin()
                    + "  ,  '" + usuario.getIdFuncionario()
                    + "'  ,  '" + usuario.getLogin()
                    + "' , '" + usuario.getSenha()
                    + "' , '" + usuario.getIdGrupo()
                    + "')";
            System.out.println(sql);
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir usuario" + ex);
            usuario.setIdlogin(0);
            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }
        return false;
    }
      public boolean updateLogin(Usuario usuario) {
        Date data = new Date();
        String sql = "UPDATE login SET "
                + "idlogin=" + usuario.getIdlogin()+ ","
                + "idfuncionario=" + usuario.getIdFuncionario()+ ","
                + "descricao='" + usuario.getLogin()+ "', "
                + "senha='" + usuario.getSenha()+ "',"
                + "idgrupo='" + usuario.getIdGrupo()+ "',"
                
                + " WHERE idlogin=" + usuario.getIdlogin()+ ",";
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Update" + ex + "\n" +sql );
        }
        return false;
    }
}
