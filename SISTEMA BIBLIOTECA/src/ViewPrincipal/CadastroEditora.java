/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewPrincipal;

import Controller.EditoraController;
import Model.Editora;
import Model.Livro;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edivaldo
 */
public class CadastroEditora extends javax.swing.JInternalFrame {
    Editora editora;
    EditoraController editoraController;
    ArrayList<Editora> listaEditora;
    /**
     * Creates new form CadastroEditora
     */
    public CadastroEditora() {
        initComponents();
       setModelo();
        editoraController = new EditoraController();
        Dimension tamTela = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension tamJan = getSize();
        setLocation(new Point((tamTela.width - tamJan.width) / 2, (tamTela.height - tamJan.height) / 2));
        listaEditora();
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
        txtIdEditora = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEditora = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("Cadastro Editora");

        jLabel1.setText("IdEditora: ");

        jLabel2.setText("Nome:");

        txtIdEditora.setEnabled(false);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Save-icon.png"))); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
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

        tblEditora.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblEditora);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpar)
                        .addComponent(btnExcluir)))
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(txtIdEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        addEditora();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
       limpaCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        deleteEditora();
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEditora;
    private javax.swing.JTextField txtIdEditora;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
 DefaultTableModel modelo;

    private void setModelo() {
        modelo = new DefaultTableModel();
        modelo.addColumn("CodEditora");
        modelo.addColumn("Nome");    

        tblEditora.setModel(modelo);

    }

    public void addEditora() {
        if (txtNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campa nome invalido");
        }
        if (editora == null) {
            editora = new Editora();
        }
     

        editora.setNome(txtNome.getText());

        if (editoraController.insereEditora(editora)) {
            listaEditora();           
            limpaCampos();

        }
    }

    public void insereTabela(Editora editora) {
        Object[] linha = new Object[3];
        linha[0] = editora.getIdEditora();
        linha[1] = editora.getNome();
        
        modelo.addRow(linha);
    }

    public void listaEditora() {
        setModelo();
        ArrayList<Editora> lista;
        lista = editoraController.getEditora();

        for (Editora us : lista) {
            insereTabela(us);
        }
        listaEditora = lista;
    }

    private void limpaCampos() {
        editora = null;
        txtIdEditora.setText("");
        txtNome.setText("");
             

    }

    private int pegaIdSelecionado() {
        int linha = tblEditora.getSelectedRow();
        return Integer.parseInt(modelo.getValueAt(linha, 0).toString());
    }

    private void carregaEditora() {
        int id = pegaIdSelecionado();
        for (int x = 0; x < listaEditora.size(); x++) {
            Editora ed = listaEditora.get(x);
            if (id == ed.getIdEditora()) {
                txtIdEditora.setText(ed.getIdEditora()+ "");
                txtNome.setText(ed.getNome()+ "");
                              
                editora = ed;
                break;
            }
        }
    }

    private void novo() {
        txtIdEditora.setEnabled(true);
        txtNome.setEnabled(true);       
    }
    
    private void deleteEditora() {
        editoraController.deleteEditora(pegaIdSelecionado());
        listaEditora();
    }

}
