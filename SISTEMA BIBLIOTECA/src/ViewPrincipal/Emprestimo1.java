/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewPrincipal;

import Controller.EmprestimoController;
import Controller.LivroController;
import Model.Emprestimos;
import Model.Livro;
import Model.Pessoa;
import SistemaDao.LivroDao;

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
public class Emprestimo1 extends javax.swing.JInternalFrame {
    
    Emprestimos emprestimo;
    EmprestimoController emprestimoController;
    Pessoa pessoa;
    
    ArrayList<Livro> livros;

    /**
     * Creates new form Emprestimo
     */
    public Emprestimo1() {
        initComponents();
        emprestimoController = new EmprestimoController();
        Dimension tamTela = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension tamJan = getSize();
        setLocation(new Point((tamTela.width - tamJan.width) / 2, (tamTela.height - tamJan.height) / 2));
        setModelo();
        livros = new ArrayList<Livro>();
        setModelo();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDataEmprestimo = new javax.swing.JFormattedTextField();
        txtDataDevolucao = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtIDLivro = new javax.swing.JTextField();
        txtIdAluno = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblNomeLivro = new javax.swing.JLabel();
        lblNomeAluno = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLivro = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setMaximizable(true);

        jLabel2.setText("Data Emprestimo");

        jLabel3.setText("Data Devolução");

        txtDataEmprestimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDataEmprestimoKeyPressed(evt);
            }
        });

        txtDataDevolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDataDevolucaoKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Save-icon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton1KeyTyped(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lixeira_1.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setText("Livro");

        txtIDLivro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDLivroKeyPressed(evt);
            }
        });

        txtIdAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdAlunoKeyPressed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel5.setText("Aluno");

        lblNomeLivro.setText("Nome Livro");

        lblNomeAluno.setText("Nome Aluno");

        tblLivro.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblLivro);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Limpeza.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNomeLivro, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                        .addGap(177, 177, 177))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtIdAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNomeAluno))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomeAluno, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(4, 4, 4)
                                .addComponent(txtDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNomeLivro)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        pesquisaLivro();
        

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        pesquisaPessoa();
        listaLivros();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtIDLivroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDLivroKeyPressed
        if (evt.getKeyCode() == 10) {
            pesquisaLivro();
        }
        

    }//GEN-LAST:event_txtIDLivroKeyPressed

    private void txtIdAlunoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdAlunoKeyPressed
        if (evt.getKeyCode() == 10) {
            txtDataEmprestimo.grabFocus();
            pesquisaPessoa();
        }
       
    }//GEN-LAST:event_txtIdAlunoKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addEmprestimo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        deleteEmprestimo();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyTyped
        //addEmprestimo();
    }//GEN-LAST:event_jButton1KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpaCampos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtDataEmprestimoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataEmprestimoKeyPressed
        if (evt.getKeyCode() == 10) {
            txtDataDevolucao.grabFocus();
        }
    }//GEN-LAST:event_txtDataEmprestimoKeyPressed

    private void txtDataDevolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataDevolucaoKeyPressed
         if (evt.getKeyCode() == 10) {
            txtIDLivro.grabFocus();
         }
    }//GEN-LAST:event_txtDataDevolucaoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblNomeAluno;
    private javax.swing.JLabel lblNomeLivro;
    private javax.swing.JTable tblLivro;
    private javax.swing.JFormattedTextField txtDataDevolucao;
    private javax.swing.JFormattedTextField txtDataEmprestimo;
    private javax.swing.JTextField txtIDLivro;
    private javax.swing.JTextField txtIdAluno;
    // End of variables declaration//GEN-END:variables
DefaultTableModel modelo;
    
    private void setModelo() {
        modelo = new DefaultTableModel();
        modelo.addColumn("IDEmprestimo");
        modelo.addColumn("Nome Aluno");
        modelo.addColumn("Nome Livro");
        modelo.addColumn("data emprestimo");
        modelo.addColumn("data Devolucao ");
        
        tblLivro.setModel(modelo);
        
    }
    
    public void insereTabela(Emprestimos emprestimos, Livro livro) {
        Object[] linha = new Object[9];
        linha[0] = emprestimos.getIdEmprestimo();
        linha[1] = pessoa.getNome();
        linha[2] = livro.getTitulo();
        linha[3] = emprestimos.getDataEmprestimo();
        linha[4] = emprestimos.getDataDevolucao();
        modelo.addRow(linha);
    }
    
    private void pesquisaLivro() {
        PesquisaLivro pesquisa;
        int id;
        try {
            id = Integer.parseInt(txtIDLivro.getText());
        } catch (Exception ex) {
            id = 0;
        }
        
        if (id == 0) {
            pesquisa = new PesquisaLivro(null, closable);
            pesquisa.setVisible(true);
        } else {
            pesquisa = new PesquisaLivro(id);
        }
        Livro livro = pesquisa.getLivroSelecionado();
        txtIDLivro.setText(livro.getIdLivro() + "");
        lblNomeLivro.setText(livro.getTitulo());
        emprestimo = addEmprestimo();
        insereTabela(emprestimo, livro);
        livros.add(livro);
        //limpaCampos();
    }
    
    private void pesquisaPessoa() {
        livros = new ArrayList<Livro>();
        setModelo();        
        PesquisaPessoa pesquisaPessoa;
        int id;
        try {
            id = Integer.parseInt(txtIdAluno.getText());
        } catch (Exception ex) {
            id = 0;
        }
        
        if (id == 0) {
            pesquisaPessoa = new PesquisaPessoa(null, closable);
            pesquisaPessoa.setVisible(true);
        } else {
            pesquisaPessoa = new PesquisaPessoa(id);
        }
        pessoa = pesquisaPessoa.getPessoaSelecionado();
        txtIdAluno.setText(pessoa.getIdpessoa() + "");
        lblNomeAluno.setText(pessoa.getNome());
        limpaCampos();
        
    }
    
    public Emprestimos addEmprestimo() {
        
        if (emprestimo == null) {
            emprestimo = new Emprestimos();
        }
        // emprestimo.setIdEmprestimo(Integer.parseInt(txtIdEmprestimo.getText()));
        emprestimo.setDataEmprestimo(txtDataEmprestimo.getText());
        emprestimo.setDataDevolucao(txtDataDevolucao.getText());
        emprestimo.setIdAluno(Integer.parseInt(txtIdAluno.getText()));
        emprestimo.setIdLivro(Integer.parseInt(txtIDLivro.getText()));
        
        if (emprestimoController.insereEmprestimo(emprestimo)) {
            
        }
        return emprestimo;
    }
    
    private void limpaCampos() {
        emprestimo = null;        
        
        txtDataEmprestimo.setText("");
        txtDataDevolucao.setText("");
        txtIDLivro.setText("");
        
    }
    
    private void novo() {        
        txtDataEmprestimo.setEnabled(true);
        txtDataDevolucao.setEnabled(true);
        
    }
    
    private void listaLivros() {
        setModelo();
        ArrayList<Emprestimos> listaEmprestimos = emprestimoController.getLivrosByIDAluno(Integer.parseInt(txtIdAluno.getText()));
        for (Emprestimos emp : listaEmprestimos) {
            Livro livro = new LivroController().getLivroByID(emp.getIdLivro());
            insereTabela(emp, livro);
        }
        
    }

    private int pegaIdSelecionado() {
        int linha = tblLivro.getSelectedRow();
        modelo.getValueAt(linha, 0);
        return Integer.parseInt(modelo.getValueAt(linha, 0).toString());
        
    }

    private void deleteEmprestimo() {
        emprestimoController.deleteEmprestimo(pegaIdSelecionado());
        listaLivros();
    }
    
}