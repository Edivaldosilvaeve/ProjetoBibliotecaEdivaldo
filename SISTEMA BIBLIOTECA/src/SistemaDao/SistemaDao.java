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
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author EDIVALDOS4342_00
 */
public class SistemaDao {

    Statement st;
    Pessoa pessoa;

    public SistemaDao() {

        try {
            st = ConexaoDao.getConexao().createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro conexao login" + ex);
        }

    }

    public Usuario getSistemaById(int id) {
        ResultSet rs;
        Usuario sistema;

        try {
            rs = st.executeQuery("SELECT IDLOGIN, DESCRICAO, SENHA FROM LOGIN WHERE = IDLOGIN = " + id);

        } catch (SQLException ex) {
            Logger.getLogger(SistemaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Usuario Login(Usuario sistema) {

        try {
            String sql = "SELECT IDLOGIN, DESCRICAO, SENHA, IDGRUPO FROM LOGIN WHERE DESCRICAO = '" + sistema.getLogin() + "'"
                    + " AND SENHA = '" + sistema.getSenha() + "'";

            ResultSet rs;
           

            rs = st.executeQuery(sql);

            while (rs.next()) {
                sistema.setIdlogin(rs.getInt("IDLOGIN"));
                sistema.setLogin(rs.getString("DESCRICAO"));
                sistema.setSenha("SENHA");
                sistema.setIdGrupo(rs.getInt("IDGRUPO"));
                return sistema;
            }
            return sistema;
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }

        return sistema;
    }

    public boolean inserePessoa(Pessoa pessoa) {
        String sql = "";
        Date data = new Date();
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(PESSOAID)+1,1) AS PESSOAID FROM PESSOAS";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("PESSOAID");
            }

            pessoa.setIdpessoa(id);

            sql = "INSERT INTO pessoas (pessoaid, nome, cpf, rg, sexo, datanascimento, telefone,"
                    + "endereco, datacadastro)"
                    + "VALUES (" + pessoa.getIdpessoa()
                    + "  ,  '" + pessoa.getNome()
                    + "' , '" + pessoa.getCpf()
                    + "' , '" + pessoa.getRg()
                    + "' , '" + pessoa.getSexo()
                    + "' , '" + pessoa.getDatanascimento()
                    + "' , '" + pessoa.getFone()
                    + "' , '" + pessoa.getEndereco()
                    + "' , '" + pessoa.getDatacadastro()
                    + "')";
            System.out.println(sql);
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir usuario" + ex);
            pessoa.setIdpessoa(0);
            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }
        return false;
    }

    public ArrayList<Pessoa> getPessoas() {
        ResultSet rs;
        Pessoa pessoas;
        ArrayList<Pessoa> lista = new ArrayList<>();
        try {
            rs = st.executeQuery("SELECT PESSOAID, NOME, CPF, RG, SEXO, DATANASCIMENTO, TELEFONE, ENDERECO, DATACADASTRO FROM PESSOAS");
            while (rs.next()) {
                pessoas = new Pessoa();
                pessoas.setIdpessoa(rs.getInt("PESSOAID"));
                pessoas.setNome(rs.getString("NOME"));
                pessoas.setCpf(rs.getString("CPF"));
                pessoas.setRg(rs.getString("RG"));
                pessoas.setSexo(rs.getString("SEXO"));
                pessoas.setDatanascimento(rs.getString("DATANASCIMENTO"));
                pessoas.setFone(rs.getString("TELEFONE"));
                pessoas.setEndereco(rs.getString("ENDERECO"));
                pessoas.setDatacadastro(rs.getString("DATACADASTRO"));
                lista.add(pessoas);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }

    public boolean updatePessoa(Pessoa pessoa) {
        Date data = new Date();
        String sql = "UPDATE pessoas SET "
                + "pessoaid=" + pessoa.getIdpessoa() + ","
                + "nome='" + pessoa.getNome() + "', "
                + "cpf='" + pessoa.getCpf() + "',"
                + "rg='" + pessoa.getRg() + "',"
                + "sexo='" + pessoa.getSexo() + "',"
                + "datanascimento='" + pessoa.getDatanascimento() + "',"
                + "telefone='" + pessoa.getFone() + "',"
                + " endereco='" + pessoa.getEndereco() + "',"
                + " datacadastro='" + pessoa.getDatacadastro() + "',"
                + " WHERE pessoaid=" + pessoa.getIdpessoa() + ",";
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Update" + ex + "\n" +sql );
        }
        return false;
    }

    public ArrayList<Pessoa> getPesquisar(String nome){
        ResultSet rs;  
       

        Pessoa pesquisa;
        ArrayList<Pessoa> lista = new ArrayList<>();
        try {
            rs = st.executeQuery("SELECT PESSOAID, NOME, CPF, RG, SEXO, DATANASCIMENTO, TELEFONE, ENDERECO, DATACADASTRO FROM PESSOAS WHERE NOME like '%"+nome+"%'");
            while (rs.next()) {
                pesquisa = new Pessoa();
                pesquisa.setNome(rs.getString("NOME"));
                pesquisa.setIdpessoa(rs.getInt("PESSOAID"));                
                pesquisa.setCpf(rs.getString("CPF"));
                pesquisa.setRg(rs.getString("RG"));
                pesquisa.setSexo(rs.getString("SEXO"));
                pesquisa.setDatanascimento(rs.getString("DATANASCIMENTO"));
                pesquisa.setFone(rs.getString("TELEFONE"));
                pesquisa.setEndereco(rs.getString("ENDERECO"));
                pesquisa.setDatacadastro(rs.getString("DATACADASTRO"));
                lista.add(pesquisa);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao pesquisar" + ex);
        }
        return lista;
    }
    
    public boolean deletePessoa(int id) {
        String sql = "DELETE FROM PESSOAS WHERE PESSOAID = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro delete");
        }

        return false;
    }

}
