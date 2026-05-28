package view;

import dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmConsultas extends javax.swing.JFrame {

    public FrmConsultas() {
        initComponents();
        configurarTabela("Produtos");
        txtTotalRegistrosConsultas.setText("0");
    }

    private void configurarTabela(String tipo) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        if (tipo.equals("Produtos")) {
            modelo.setColumnIdentifiers(new Object[]{"ID", "Nome", "Valor"});
        } else if (tipo.equals("Clientes")) {
            modelo.setColumnIdentifiers(new Object[]{"ID", "Nome"});
        }
    }

    private void atualizarTotalRegistros() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        txtTotalRegistrosConsultas.setText(String.valueOf(modelo.getRowCount()));
    }

    private void listarTodos() {
        String tipo = txtComboTipoConsulta.getSelectedItem().toString();
        configurarTabela(tipo);

        String sql = "";

        if (tipo.equals("Produtos")) {
            sql = "SELECT id, nome, valor FROM produto";
        } else if (tipo.equals("Clientes")) {
            sql = "SELECT id, nome FROM cliente";
        }

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

            while (rs.next()) {
                if (tipo.equals("Produtos")) {
                    modelo.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("valor")
                    });
                } else if (tipo.equals("Clientes")) {
                    modelo.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("nome")
                    });
                }
            }

            atualizarTotalRegistros();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar dados: " + e.getMessage());
        }
    }

    private void pesquisar() {
        String tipo = txtComboTipoConsulta.getSelectedItem().toString();
        String filtro = txtFiltroConsulta.getText().trim();

        configurarTabela(tipo);

        String sql = "";

        if (tipo.equals("Produtos")) {
            sql = "SELECT id, nome, valor FROM produto WHERE nome LIKE ?";
        } else if (tipo.equals("Clientes")) {
            sql = "SELECT id, nome FROM cliente WHERE nome LIKE ?";
        }

        try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + filtro + "%");

            ResultSet rs = stmt.executeQuery();
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

            while (rs.next()) {
                if (tipo.equals("Produtos")) {
                    modelo.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("valor")
                    });
                } else if (tipo.equals("Clientes")) {
                    modelo.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("nome")
                    });
                }
            }

            atualizarTotalRegistros();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao pesquisar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtComboTipoConsulta = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtFiltroConsulta = new javax.swing.JTextField();
        btnPesquisarConsulta = new javax.swing.JButton();
        btnListarTodasConsultas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtTotalRegistrosConsultas = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("CONSULTAS DO SISTEMA");

        jLabel2.setText("Tipo de Consulta:");

        txtComboTipoConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Produtos", "Clientes" }));
        txtComboTipoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComboTipoConsultaActionPerformed(evt);
            }
        });

        jLabel3.setText("Filtro:");

        txtFiltroConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroConsultaActionPerformed(evt);
            }
        });

        btnPesquisarConsulta.setText("Pesquisar");
        btnPesquisarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarConsultaActionPerformed(evt);
            }
        });

        btnListarTodasConsultas.setText("Listar Todos");
        btnListarTodasConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTodasConsultasActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Valor", "Data", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setText("Total de registros:");

        txtTotalRegistrosConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalRegistrosConsultasActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalRegistrosConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnListarTodasConsultas)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtFiltroConsulta))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtComboTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisarConsulta))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVoltar))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtComboTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFiltroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarConsulta))
                .addGap(18, 18, 18)
                .addComponent(btnListarTodasConsultas)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotalRegistrosConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarConsultaActionPerformed
        pesquisar();
    }//GEN-LAST:event_btnPesquisarConsultaActionPerformed

    private void btnListarTodasConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTodasConsultasActionPerformed
        listarTodos();
    }//GEN-LAST:event_btnListarTodasConsultasActionPerformed

    private void txtTotalRegistrosConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalRegistrosConsultasActionPerformed

    }//GEN-LAST:event_txtTotalRegistrosConsultasActionPerformed

    private void txtFiltroConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroConsultaActionPerformed

    }//GEN-LAST:event_txtFiltroConsultaActionPerformed

    private void txtComboTipoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComboTipoConsultaActionPerformed

    }//GEN-LAST:event_txtComboTipoConsultaActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmConsultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListarTodasConsultas;
    private javax.swing.JButton btnPesquisarConsulta;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> txtComboTipoConsulta;
    private javax.swing.JTextField txtFiltroConsulta;
    private javax.swing.JTextField txtTotalRegistrosConsultas;
    // End of variables declaration//GEN-END:variables
}
