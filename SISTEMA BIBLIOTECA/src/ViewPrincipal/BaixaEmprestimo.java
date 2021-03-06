/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewPrincipal;



import Controller.EmprestimoController;
import Model.Emprestimos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edivaldo
 */
public class BaixaEmprestimo extends javax.swing.JDialog {
    
    private ArrayList<Emprestimos> listaEmprestimos;
    private DefaultTableModel modelo;
    private Emprestimos emprestimos;

    /**
     * Creates new form BaixaEmprestimo
     */
    public BaixaEmprestimo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setModelo();
        pesquisar(0);
    }
    
    public BaixaEmprestimo(int id) {
        pesquisar(id);
        pegaIdSelecionado(id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDeleteEmprestimo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarAluno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblDeleteEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDeleteEmprestimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDeleteEmprestimoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDeleteEmprestimo);

        jLabel1.setText("Aluno");

        txtBuscarAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarAlunoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        pesquisar(0);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarAlunoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAlunoKeyTyped
        pesquisar(0);
    }//GEN-LAST:event_txtBuscarAlunoKeyTyped

    private void tblDeleteEmprestimoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDeleteEmprestimoKeyPressed
        pesquisar(0);
    }//GEN-LAST:event_tblDeleteEmprestimoKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BaixaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaixaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaixaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaixaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BaixaEmprestimo dialog = new BaixaEmprestimo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDeleteEmprestimo;
    private javax.swing.JTextField txtBuscarAluno;
    // End of variables declaration//GEN-END:variables
private void pesquisar(int id) {
        ArrayList<Emprestimos> lista;
        if (id == 0) {
            lista = new EmprestimoController().getEmprestimosByNome(txtBuscarAluno.getText());
            setModelo();
            for (Emprestimos emprestimos : lista) {
                insereTabela(emprestimos);
            }
        } else {
            lista = new EmprestimoController().getEmprestimosByNome("");
        }
        listaEmprestimos = lista;
    }

    public void insereTabela(Emprestimos emprestimos) {
        Object[] linha = new Object[5];
        linha[0] = emprestimos.getIdEmprestimo();
        linha[1] = emprestimos.getIdAluno();
        linha[2] = emprestimos.getIdLivro();
        linha[3] = emprestimos.getDataEmprestimo();
        linha[4] = emprestimos.getDataDevolucao();
        modelo.addRow(linha);
    }

    private void setModelo() {
        modelo = new DefaultTableModel();
        modelo.addColumn("IDEmprestimos");
        modelo.addColumn("IDAluno");
        modelo.addColumn("IDLIvro");
        modelo.addColumn("DATA_EMPRESTIMO");
        modelo.addColumn("DATA_DEVOLUCAO");
        tblDeleteEmprestimo.setModel(modelo);
    }

    private void pegaIdSelecionado(int id) {

        if (id == 0) {
            int linha = tblDeleteEmprestimo.getSelectedRow();
            id = Integer.parseInt(modelo.getValueAt(linha, 0).toString());
        }
        for (Emprestimos emprestimo : listaEmprestimos) {
            if (id == emprestimo.getIdEmprestimo()) {
                this.emprestimos = emprestimos;
            }
        }
        this.dispose();
    }

    public Emprestimos getEmprestimoSelecionado() {
        return emprestimos;
    }

}
