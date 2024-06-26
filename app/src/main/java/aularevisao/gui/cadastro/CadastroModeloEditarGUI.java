package aularevisao.gui.cadastro;

import aularevisao.dao.FabricanteDAO;
import aularevisao.entity.Fabricante;
import javax.swing.JOptionPane;

public class CadastroModeloEditarGUI extends javax.swing.JDialog {

    private FabricanteDAO dao = new FabricanteDAO();
    private Fabricante fabricanteEditar = null;
    private CadastroFabricanteGUI parentDialog;

    public CadastroModeloEditarGUI(java.awt.Frame parent, boolean modal, CadastroFabricanteGUI dialogParent) {
        super(parent, modal);
        parentDialog = dialogParent;
        initComponents();
    }

    public void carregarFabricante(int id) {
        fabricanteEditar = dao.select(id);

        txtNome.setText(fabricanteEditar.getNome());
    }

    private void limparCampos() {
        txtNome.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNome.setText("Nome:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(274, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (fabricanteEditar == null) {
            Fabricante novoFabricante = new Fabricante();
            novoFabricante.setNome(txtNome.getText());

            try {
                dao.insert(novoFabricante);

                JOptionPane.showMessageDialog(this, "Fabricante Inserido com Sucesso!", "SUCESS", JOptionPane.INFORMATION_MESSAGE);

                parentDialog.carregarLista();

                limparCampos();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            fabricanteEditar.setNome(txtNome.getText());

            try {
                dao.update(fabricanteEditar);

                JOptionPane.showMessageDialog(this, "Fabricante Editado com Sucesso!", "SUCESS", JOptionPane.INFORMATION_MESSAGE);

                parentDialog.carregarLista();

                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnSalvarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
