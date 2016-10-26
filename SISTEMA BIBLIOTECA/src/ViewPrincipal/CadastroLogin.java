/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewPrincipal;

import Controller.UsuarioController;


import Model.Usuario;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EDIVALDOS4342_00
 */
public class CadastroLogin extends javax.swing.JInternalFrame {
    Usuario usuario;
    UsuarioController usuarioController;
     ArrayList<Usuario> listaUsuario;
    ArrayList<Usuario> pesquisa;
    /**
     * Creates new form CadastroLogin
     */
    public CadastroLogin() {
        initComponents();
        usuarioController = new UsuarioController();
        Dimension tamTela = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension tamJan = getSize();
        setLocation(new Point((tamTela.width - tamJan.width) / 2, (tamTela.height - tamJan.height) / 2));
    listaUsuario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdLogin = new javax.swing.JTextField();
        txtIdFuncionario = new javax.swing.JTextField();
        txtIdGrupo = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        btnGravar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLogin = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("Cadastro Login");

        jLabel1.setText("IdLogin");

        jLabel2.setText("IdFuncionario");

        jLabel3.setText("IdGrupo");

        jLabel4.setText("Nome");

        jLabel5.setText("Senha");

        txtIdLogin.setEnabled(false);

        btnGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Save-icon.png"))); // NOI18N
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Limpeza.png"))); // NOI18N
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lixeira_1.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tblLogin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoginMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLogin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(61, 61, 61)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtIdFuncionario)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(txtIdLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtIdGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
       addLogin();
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpaCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        deleteUsuario();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoginMouseClicked
       carregaUsuario();
    }//GEN-LAST:event_tblLoginMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLogin;
    private javax.swing.JTextField txtIdFuncionario;
    private javax.swing.JTextField txtIdGrupo;
    private javax.swing.JTextField txtIdLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel modelo;

    private void setModelo() {
        modelo = new DefaultTableModel();
        modelo.addColumn("IdLogin");
        modelo.addColumn("IdFuncionario");
        modelo.addColumn("IdGrupo");
        modelo.addColumn("Nome");
        modelo.addColumn("Senha");  
        tblLogin.setModel(modelo);

    }
    
    public void addLogin() {
        if (txtNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campa nome invalido");
        }
        if (usuario == null) {
            usuario = new Usuario();
        }
        usuario.setIdFuncionario(Integer.parseInt(txtIdFuncionario.getText()));
        usuario.setLogin(txtNome.getText());
        usuario.setSenha(txtSenha.getText());
        usuario.setIdGrupo(Integer.parseInt(txtIdGrupo.getText()));

        if (usuarioController.insereUsuario(usuario)) {
            JOptionPane.showMessageDialog(null, "Usuario Gravado com Sucesso");
            listaUsuario();
            // insereTabela(pessoa);
           limpaCampos();

        }
    }

    private void limpaCampos() {
        usuario = null;
        txtIdLogin.setText("");
        txtIdFuncionario.setText("");
        txtIdGrupo.setText("");
        txtNome.setText("");
        txtSenha.setText("");

    }
    
     public void insereTabela(Usuario usuario) {
        Object[] linha = new Object[5];
        linha[0] = usuario.getIdlogin();
        linha[1] = usuario.getIdFuncionario();
        linha[2] = usuario.getIdGrupo();
        linha[3] = usuario.getLogin();
        linha[4] = usuario.getSenha();        

        modelo.addRow(linha);

    }

    public void listaUsuario() {
        setModelo();
        ArrayList<Usuario> lista;
        lista = usuarioController.getUsuario();

        for (Usuario us : lista) {
            insereTabela(us);
        }
        listaUsuario = lista;
    }

  

    private int pegaIdSelecionado() {
        int linha = tblLogin.getSelectedRow();
        return Integer.parseInt(modelo.getValueAt(linha, 0).toString());
    }

    private void carregaUsuario() {
        int id = pegaIdSelecionado();
        for (int x = 0; x < listaUsuario.size(); x++) {
            Usuario us = listaUsuario.get(x);
            if (id == us.getIdlogin()) {
                //txtIdLogin.setText(us.getLogin()+ "");
               // txtIdFuncionario.setText(us.getIdFuncionario()+"");
               // txtIdGrupo.setText(us.getIdGrupo()+"");
                txtNome.setText(us.getLogin());
                txtSenha.setText(us.getSenha());             
                break;
            }
        }
    }  

    private void deleteUsuario() {
        usuarioController.deleteUsuario(pegaIdSelecionado());
        listaUsuario();
    }


}
